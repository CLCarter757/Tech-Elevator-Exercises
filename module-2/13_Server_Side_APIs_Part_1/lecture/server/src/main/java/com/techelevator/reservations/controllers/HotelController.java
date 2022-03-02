package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     *
     * GET http://localhost:8080/hotels
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
//    public List<Hotel> list() {
//        return hotelDao.list();
//    }
    public List<Hotel> filterAllHotels(@RequestParam(required = false) String city,
                                       @RequestParam(required = false) String state) {
        List<Hotel> allHotels = hotelDao.list();
        List<Hotel> filteredHotels = new ArrayList<>();

        if(city==null && state==null) {
            return allHotels;
        }
        if (city != null && state != null) {
            for(Hotel hotel : allHotels) {
                if(hotel.getAddress().getCity().equals(city)
                    && hotel.getAddress().getState().equals(state)) {
                    filteredHotels.add(hotel);
                }
            }
            return filteredHotels;
        }
        if (city != null && state==null) {
            for(Hotel hotel : allHotels) {
                if(hotel.getAddress().getCity().equals(city)) {
                    filteredHotels.add(hotel);
                }
            }
            return filteredHotels;
        }
        if (city == null && state != null) {
            for(Hotel hotel : allHotels) {
                if(hotel.getAddress().getState().equals(state)) {
                    filteredHotels.add(hotel);
                }
            }
            return filteredHotels;
        }
        return allHotels;
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    /**
     * List all reservations
     * @return
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations () {
        return reservationDao.findAll();
    }

    /**
     * Return reservation by id
     */
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
        return reservationDao.get(id);
    }

    /**
     * Create a new reservation
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    //@PostMapping("/reservations") shorthand
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationDao.create(reservation, reservation.getHotelID());
    }




}
