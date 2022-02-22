package com.techelevator.dao;

import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/*

        CRUD

        CREATE e.g. Insert
        RETRIEVE e.g. Select (Get/Get All)
        UPDATE e.g. Update
        DELETE e.g. Delete


        JdbcTemplate
         Methods (to execute SQL)
          - queryForObject: use when you expect exactly 1 result (1 row, 1 column)
          - queryForRowSet: use when you expect many results (many columns, rows)
          - update: use when you don't expect output (you do get back how many rows were impacted)
         */

public class JdbcCityDao implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public City getCity(long cityId) {
        City city = null;

        // 1. Define our query
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area" +
                     "FROM city " +
                     "WHERE city_id = ?;";

        // 2. Execute the query
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);

        // 3. Process the results
        /*
               city_id     city_name   state_abbreviation      population      area
      ->    1.     1       "Pittsburgh"         PA              300,000         100
            2.     2       "New York"           NY              8,000,000       1000

         */

        if (results.next()) {
            city = mapRowToCity(results);
        }

        return city;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        List<City> cities = new ArrayList<>();

        // 1. Write the query
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";

        // 2. Execute the query
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // 3. Process the query results

         /*
               city_id     city_name   state_abbreviation      population      area
            1.     1       "Pittsburgh"         PA              300,000         100
            2.     2       "Allentown"          PA              8,000,000       1000

         */

        while (results.next()) {
            City city = mapRowToCity(results);
            cities.add(city);
        }

        return cities;
    }

    @Override
    public City createCity(City city) {

        // 1. write the query
        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     "VALUES (?, ?, ?, ?) RETURNING city_id;";

        // 2. execute the query
        Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());

        // 3. process the results -> take a city_id and call getCity to get back a City object.
        City newCity = getCity(newId);
        return newCity;
    }

    @Override
    public void updateCity(City city) {
        // 1. write the query
        String sql = "UPDATE city " +
                    "SET city_name = ?, " +
                    "    state_abbreviation = ?, " +
                    "    population = ?, " +
                    "    area = ? " +
                    "WHERE city_id = ?;";

        // 2. execute the query
        jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(),
                city.getArea(), city.getCityId());
    }

    @Override
    public void deleteCity(long cityId) {
        String sql = "DELETE FROM city WHERE city_id = ?;";
        jdbcTemplate.update(sql, cityId);
    }

    private City mapRowToCity(SqlRowSet rowSet) {
        City city = new City();

        long cityId = rowSet.getLong("city_id");
        city.setCityId(cityId);

        city.setCityName(rowSet.getString("city_name"));

        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));

        city.setPopulation(rowSet.getLong("population"));

        city.setArea(rowSet.getDouble("area"));
        return city;
    }
}
