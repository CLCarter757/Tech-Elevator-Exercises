package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        Park park = null;

        // 1. write the query
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ?;";

        // 2. execute the query
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        // 3. process the results
        if(results.next()) {
            park = mapRowToPark(results);
        }

        return park;
    }



    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                "FROM park p " +
                "JOIN park_state ps ON p.park_id = ps.park_id " +
                "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {
        String sql = "INSERT INTO park (park_name, date_established, area, has_camping) " +
                "VALUES (?, ?, ?, ?) RETURNING park_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());

        return getPark(newId);
    }

    @Override
    public void updatePark(Park park) {
        String sql = "UPDATE park " +
                "SET park_name = ?, date_established = ?, area = ?, has_camping = ? " +
                "WHERE park_id = ?;";
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());
    }

    @Override
    public void deletePark(long parkId) {
        String sql = "DELETE FROM park_state WHERE park_id = ?;";
        jdbcTemplate.update(sql, parkId);
        sql = "DELETE FROM park WHERE park_id = ?";
        jdbcTemplate.update(sql, parkId);
    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
        String sql = "INSERT INTO park_state (park_id, state_abbreviation) VALUES (?, ?);";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {
        String sql = "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?;";
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }


    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();

        long parkId = rowSet.getLong("park_id");
        park.setParkId(parkId);

        String parkName = rowSet.getString("park_name");
        park.setParkName(parkName);

        Date dateEstablished = rowSet.getDate("date_established");
        if(dateEstablished != null) {
            park.setDateEstablished(dateEstablished.toLocalDate());
        }

        double area = rowSet.getDouble("area");
        park.setArea(area);

        boolean hasCamping = rowSet.getBoolean("has_camping");
        park.setHasCamping(hasCamping);

        return park;
    }
}
