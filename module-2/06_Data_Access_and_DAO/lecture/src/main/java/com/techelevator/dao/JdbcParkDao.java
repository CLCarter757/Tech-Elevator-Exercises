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

        String sql = "SELECT park_id, park_name, date_established, area, has_cmping " +
                    "FROM park " +
                    "WHERE park_id = ?;";

        SqlRowSet results =jdbcTemplate.queryForRowSet(sql, parkId);

        if(results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<Park>();
    }

    @Override
    public Park createPark(Park park) {
        return new Park();
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public void deletePark(long parkId) {

    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {

    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();

        park.setParkId(rowSet.getLong("park_id"));
        park.setParkName(rowSet.getString("park_name"));

        Date dateEstablished = rowSet.getDate("date_established");
        if (dateEstablished != null) {
            LocalDate establishDate = dateEstablished.toLocalDate();
            park.setDateEstablished(establishDate);
        }

        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        return new Park();
    }
}
