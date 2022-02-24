package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while(results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employee = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee " +
				"WHERE first_name ILIKE ? AND last_name ILIKE ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");

		while(results.next()) {
			employee.add(mapRowToEmployee(results));
		}

		return employee;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
					"FROM employee JOIN project_employee USING (employee_id) " +
					"WHERE project_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) " +
					"VALUES (?, ?);";

		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee " +
					"WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
					"FROM employee " +
					"LEFT JOIN project_employee USING (employee_id) " +
					"WHERE project_employee.employee_id IS NULL;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}

		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();

		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));

		Date birthDate = rowSet.getDate("birth_date");
		if (birthDate != null) {
			employee.setBirthDate(birthDate.toLocalDate());
		}
		Date hireDate = rowSet.getDate("hire_date");
		if (hireDate != null) {
			employee.setHireDate(hireDate.toLocalDate());
		}

		return employee;
	}


}
