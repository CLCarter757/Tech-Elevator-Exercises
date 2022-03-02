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
     * GET http://localhost:8080/hotels?city=Pittsburgh&state=PA
     * GET http://localhost:8080/hotels?state=PA
     * GET http://localhost:8080/hotels
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterAllHotels(@RequestParam(required = false) String city,
                                       @RequestParam(required = false) String state) {

        List<Hotel> allHotels = hotelDao.list();

        // 4. I get neither city or state
        if(city == null && state == null) {
            return allHotels;
        }

        List<Hotel> filteredHotels = new ArrayList<>();

        for(Hotel hotel : allHotels) {
            // if this hotel is in the city and state they gave us
            boolean cityMatches = city == null || hotel.getAddress().getCity().equalsIgnoreCase(city);
            boolean stateMatches = state == null || hotel.getAddress().getState().equalsIgnoreCase(state);

            if(cityMatches && stateMatches) {
                filteredHotels.add(hotel);
            }
        }

        return filteredHotels;




        /*



        // 1. I get both city and state
        if(city != null && state != null) {
            List<Hotel> filteredHotels = new ArrayList<>();

            for(Hotel hotel : allHotels) {
                // if this hotel is in the city and state they gave us
                if(hotel.getAddress().getCity().equalsIgnoreCase(city)
                    && hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filteredHotels.add(hotel);
                }
            }

            return filteredHotels;
        }

        // 2. I get just city
        if(city != null && state == null) {
            List<Hotel> filteredHotels = new ArrayList<>();

            for(Hotel hotel : allHotels) {
                // if this hotel is in the city and state they gave us
                if(hotel.getAddress().getCity().equalsIgnoreCase(city)) {
                    filteredHotels.add(hotel);
                }
            }

            return filteredHotels;
        }


        // 3. I get just state
        if(state != null && city == null) {
            List<Hotel> filteredHotels = new ArrayList<>();

            for(Hotel hotel : allHotels) {
                // if this hotel is in the city and state they gave us
                if(hotel.getAddress().getState().equalsIgnoreCase(state)) {
                    filteredHotels.add(hotel);
                }
            }

            return filteredHotels;
        }





        return hotelDao.list();


         */
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
     * Returns all reservations
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
//    @GetMapping("/reservations") short-hand method
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Return reservation by id
     *
     * @param id The id of the reservation
     * @return A reservation
     */
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
        return reservationDao.get(id);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    // @PostMapping("/reservations") short-hand
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationDao.create(reservation, reservation.getHotelID());
    }


}
