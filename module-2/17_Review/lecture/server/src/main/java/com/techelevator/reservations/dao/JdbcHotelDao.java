package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class JdbcHotelDao implements HotelDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcHotelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hotel> list() {
        List<Hotel> hotels = new ArrayList<>();

        String sql = "SELECT * FROM hotel JOIN address USING (address_id);";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Hotel hotel = mapRowToHotel(results);
            hotels.add(hotel);
        }

        return hotels;
    }

    @Override
    public void create(Hotel hotel) {
        // TODO
    }

    @Override
    public Hotel get(int id) throws HotelNotFoundException {

        String sql = "SELECT * FROM hotel JOIN address USING (address_id) WHERE hotel_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToHotel(results);
        }

        throw new HotelNotFoundException();
    }

    private Hotel mapRowToHotel(SqlRowSet results) {
        Address address = new Address();

        address.setId(results.getInt("address_id"));
        address.setAddress(results.getString("address"));
        address.setAddress2(results.getString("address2"));
        address.setCity(results.getString("city"));
        address.setState(results.getString("state"));
        address.setZip(results.getString("zip"));

        Hotel hotel = new Hotel();

        hotel.setId(results.getInt("hotel_id"));
        hotel.setAddress(address);
        hotel.setName(results.getString("name"));
        hotel.setCostPerNight(results.getDouble("cost_per_night"));
        hotel.setRoomsAvailable(results.getInt("rooms_available"));

        return hotel;
    }
}
