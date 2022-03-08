package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Reservation;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class JdbcReservationDao implements ReservationDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reservation> findAll(String username) {
        List<Reservation> reservations = new ArrayList<>();

        String sql = "SELECT reservation.*, \"user\".username " +
                "FROM reservation " +
                "JOIN \"user\" USING (user_id) " +
                "WHERE username = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);

        while(results.next()) {
            Reservation reservation = mapRowToReservation(results);
            reservations.add(reservation);
        }

        return reservations;
    }

    @Override
    public List<Reservation> findByHotel(int hotelId, String username) throws HotelNotFoundException {
        Boolean doesHotelExist = doesHotelExist(hotelId);
        if(doesHotelExist == null|| !doesHotelExist) {
            throw new HotelNotFoundException();
        }

        List<Reservation> reservations = new ArrayList<>();

        String sql = "SELECT reservation.*, \"user\".username " +
                "FROM reservation " +
                "JOIN \"user\" USING (user_id) " +
                "JOIN hotel USING (hotel_id) " +
                "WHERE hotel_id = ? AND username = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, hotelId, username);

        while(results.next()) {
            Reservation reservation = mapRowToReservation(results);
            reservations.add(reservation);
        }

        return reservations;
    }

    @Override
    public Reservation get(int reservationId, String username) throws ReservationNotFoundException {
        String sql = "SELECT reservation.*, \"user\".username " +
                "FROM reservation " +
                "JOIN \"user\" USING (user_id) " +
                "WHERE reservation_id = ? AND username = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reservationId, username);

        if (results.next()) {
            return mapRowToReservation(results);
        }

        throw new ReservationNotFoundException();
    }

    @Override
    public Reservation create(Reservation reservation, int hotelId) throws HotelNotFoundException, ReservationNotFoundException {
        Boolean doesHotelExist = doesHotelExist(hotelId);
        if(doesHotelExist == null|| !doesHotelExist) {
            throw new HotelNotFoundException();
        }

        String sql = "INSERT INTO reservation (hotel_id, user_id, fullname, check_in_date, check_out_date, guests) " +
                "VALUES (?, (SELECT user_id FROM \"user\" WHERE username = ?), ?, ?, ?, ?) " +
                "RETURNING reservation_id;";

        Integer reservationId = jdbcTemplate.queryForObject(sql, Integer.class,
                reservation.getHotelId(),
                reservation.getUsername(),
                reservation.getFullName(),
                reservation.getCheckinDate(),
                reservation.getCheckoutDate(),
                reservation.getGuests());

        return get(reservationId, reservation.getUsername());
    }

    @Override
    public Reservation update(Reservation reservation, int id) throws ReservationNotFoundException {
        String sql = "UPDATE reservation " +
                "SET hotel_id = ?," +
                "check_in_date = ?," +
                "check_out_date = ?," +
                "guests = ?," +
                "fullname = ? " +
                "WHERE reservation_id = ?;";

        jdbcTemplate.update(sql,
                reservation.getHotelId(),
                reservation.getCheckinDate(),
                reservation.getCheckoutDate(),
                reservation.getGuests(),
                reservation.getFullName(),
                id);

        return get(id, reservation.getUsername());
    }

    @Override
    public void delete(int id) throws ReservationNotFoundException {
        String sql = "DELETE FROM reservation WHERE reservation_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected == 0) throw new ReservationNotFoundException();
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation reservation = new Reservation();

        reservation.setId(results.getInt("reservation_id"));
        reservation.setHotelId(results.getInt("hotel_id"));
        reservation.setUsername(results.getString("username"));
        reservation.setFullName(results.getString("fullname"));
        reservation.setGuests(results.getInt("guests"));

        Date checkInDate = results.getDate("check_in_date");
        if(checkInDate != null) {
            reservation.setCheckinDate(checkInDate.toLocalDate());
        }

        Date checkOutDate = results.getDate("check_out_date");
        if(checkOutDate != null) {
            reservation.setCheckoutDate(checkOutDate.toLocalDate());
        }

        return reservation;
    }

    private Boolean doesHotelExist(int hotelId) {
        String sqlHotelExists = "SELECT EXISTS (SELECT * FROM hotel WHERE hotel_id = ?);";
        return jdbcTemplate.queryForObject(sqlHotelExists, Boolean.class, hotelId);
    }
}
