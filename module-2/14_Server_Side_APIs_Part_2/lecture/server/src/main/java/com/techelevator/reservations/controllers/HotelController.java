package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private final HotelDao hotelDao;
    private final ReservationDao reservationDao;

    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * Return a list of Hotels, filtered or not
     *
     * @return a list of hotels
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterAllHotels(@RequestParam(required = false) String city,
                                       @RequestParam(required = false) String state) {

        List<Hotel> allHotels = hotelDao.list();

        // 4. I get neither city or state
        if (city == null && state == null) {
            return allHotels;
        }

        List<Hotel> filteredHotels = new ArrayList<>();

        for (Hotel hotel : allHotels) {
            // if this hotel is in the city and state they gave us
            boolean cityMatches = city == null || hotel.getAddress().getCity().equalsIgnoreCase(city);
            boolean stateMatches = state == null || hotel.getAddress().getState().equalsIgnoreCase(state);

            if (cityMatches && stateMatches) {
                filteredHotels.add(hotel);
            }
        }

        return filteredHotels;
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) throws HotelNotFoundException {
        return hotelDao.get(id);
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id The id of the reservation
     * @return a single reservation
     */
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) throws ReservationNotFoundException {
        return reservationDao.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId The id of the hotel
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) throws HotelNotFoundException {
        return reservationDao.findByHotel(hotelId);
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation The reservation to create
     * @return Reservation that was created.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "reservations", method = RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation)
            throws HotelNotFoundException {
        return reservationDao.create(reservation, reservation.getHotelId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int id) throws ReservationNotFoundException {
        reservationDao.delete(id);
    }

    @RequestMapping(path = "reservation/{id}", method = RequestMethod.PUT)
    public Reservation updateReservation(@Valid @RequestBody Reservation reservation, @PathVariable int id) throws ReservationNotFoundException {
        return reservationDao.update(reservation, id);
    }

}
