package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.*;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
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
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterAllHotels(@RequestParam(required = false) String city,
                                       @RequestParam(required = false) String state) {

        List<Hotel> allHotels = hotelDao.list();

        // 4. I get neither city nor state
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
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) throws HotelNotFoundException {
        return hotelDao.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId The id of the hotel
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId, Principal principal) throws HotelNotFoundException {
        return reservationDao.findByHotel(hotelId, principal.getName());
    }
}
