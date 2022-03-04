package com.techelevator.reservations.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;

@Component
public class MemoryReservationDao implements ReservationDao {

    private List<Reservation> reservations = new ArrayList<>();
    private HotelDao hotelDao;

    public MemoryReservationDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
        initializeReservationData();
    }

    public List<Reservation> findAll() {
        return Collections.unmodifiableList(reservations);
    }

    @Override
    public List<Reservation> findByHotel(int hotelId) throws HotelNotFoundException {
        List<Hotel> hotels = hotelDao.list();
        boolean hotelExists = false;
        for (Hotel hotel : hotels) {
            if (hotel.getId() == hotelId) {
                hotelExists = true;
                break;
            }
        }

        if (!hotelExists) {
            throw new HotelNotFoundException();
        }

        List<Reservation> hotelReservations = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getHotelId() == hotelId) {
                hotelReservations.add(r);
            }
        }

        return hotelReservations;
    }

    @Override
    public Reservation get(int reservationID) throws ReservationNotFoundException {
        for (Reservation res : reservations) {
            if (res.getId() == reservationID) {
                return res;
            }
        }

        throw new ReservationNotFoundException();
    }

    @Override
    public Reservation create(Reservation reservation, int hotelID) {
        reservation.setId(getMaxIdPlusOne());
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation, int id) throws ReservationNotFoundException {
        Reservation reservationToUpdate = get(id);

        reservations.remove(reservationToUpdate);

        reservation.setId(id);
        reservations.add(reservation);

        return reservation;
    }

    @Override
    public void delete(int id) throws ReservationNotFoundException {
        // loop through reservations and see if we find it, then remove
        reservations.remove(get(id));
    }

    private void initializeReservationData() {
        LocalDate now = LocalDate.now();
        List<Hotel> hotels = hotelDao.list();

        reservations.add(new Reservation(getMaxIdPlusOne(),
                hotels.get(0).getId(),
                "John Smith",
                now,
                now.plusDays(3),
                2));
        reservations.add(new Reservation(getMaxIdPlusOne(),
                hotels.get(0).getId(),
                "Sam Turner",
                now,
                now.plusDays(5),
                4));
        reservations.add(new Reservation(getMaxIdPlusOne(),
                hotels.get(0).getId(),
                "Mark Johnson",
                now.plusDays(7),
                now.plusDays(10),
                2));
    }

    /**
     * finds the max id in the list of reservations and returns it
     *
     * @return int the max id
     */
    private int getMaxID() {
        int maxID = 0;
        for (Reservation r : reservations) {
            if (r.getId() > maxID) {
                maxID = r.getId();
            }
        }
        return maxID;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private int getMaxIdPlusOne() {
        return getMaxID() + 1;
    }

}
