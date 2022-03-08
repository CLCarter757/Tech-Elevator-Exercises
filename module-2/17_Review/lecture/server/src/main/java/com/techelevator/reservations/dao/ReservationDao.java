package com.techelevator.reservations.dao;

import java.util.List;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> findAll(String username);

    List<Reservation> findByHotel(int hotelId, String username) throws HotelNotFoundException;

    Reservation get(int reservationId, String username) throws ReservationNotFoundException;

    Reservation create(Reservation reservation, int hotelId) throws HotelNotFoundException, ReservationNotFoundException;

    Reservation update(Reservation reservation, int id) throws ReservationNotFoundException;

    void delete(int id) throws ReservationNotFoundException;

}