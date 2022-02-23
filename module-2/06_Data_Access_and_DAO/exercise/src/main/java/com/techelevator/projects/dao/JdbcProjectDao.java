package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;

		String sql = "SELECT project_id, name, from_date, to_date " +
					"FROM project " +
					"WHERE project_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		if(results.next()) {
			project = mapRowToProject(results);
		}

		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();

		String sql = "SELECT project_id, name, from_date, to_date " +
					"FROM project;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while(results.next()) {
			Project project = mapRowToProject(results);
			projects.add(project);
		}

		return projects;
	}

	@Override
	public Project createProject(Project newProject) {

		String sql = "INSERT INTO project (name, from_date, to_date) " +
					"VALUES (?, ?, ?) RETURNING project_id;";

		Long newID = jdbcTemplate.queryForObject(sql, Long.class, newProject.getName(),
				newProject.getFromDate(), newProject.getToDate());

		return getProject(newID);
	}

	@Override
	public void deleteProject(Long projectId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId);

		sql = "DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId);

	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();

		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));

		Date fromDate = rowSet.getDate("from_date");
		if(fromDate != null) {
			project.setFromDate(fromDate.toLocalDate());
		}
		Date toDate = rowSet.getDate("to_date");
		if(fromDate != null) {
			project.setToDate(toDate.toLocalDate());
		}

		return project;
	}
	

}
