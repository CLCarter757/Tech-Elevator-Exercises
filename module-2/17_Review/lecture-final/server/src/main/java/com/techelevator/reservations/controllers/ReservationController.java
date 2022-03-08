package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.dao.RewardDao;
import com.techelevator.reservations.exception.AuthorizationException;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import com.techelevator.reservations.service.RewardCalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@PreAuthorize("isAuthenticated()")
public class ReservationController {
    private final HotelDao hotelDao;
    private final ReservationDao reservationDao;
    private final RewardDao rewardDao;
    private final RewardCalculationService rewardCalculationService;

    public ReservationController(HotelDao hotelDao,
                                 ReservationDao reservationDao,
                                 RewardDao rewardDao,
                                 RewardCalculationService rewardCalculationService) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
        this.rewardDao = rewardDao;
        this.rewardCalculationService = rewardCalculationService;
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @GetMapping("")
    public List<Reservation> listReservations(Principal principal) {
        return reservationDao.findAll(principal.getName());
    }

    /**
     * Get a reservation by its id
     *
     * @param id The id of the reservation
     * @return a single reservation
     */
    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable int id, Principal principal) throws ReservationNotFoundException {
        return reservationDao.get(id, principal.getName());
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation The reservation to create
     * @return Reservation that was created.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Transactional
    public Reservation addReservation(@Valid @RequestBody Reservation reservation, Principal principal)
            throws HotelNotFoundException, ReservationNotFoundException {

        reservation.setUsername(principal.getName());

        Reservation createdReservation = reservationDao.create(reservation, reservation.getHotelId());

        Hotel hotel = hotelDao.get(reservation.getHotelId());
        long numberOfNights = ChronoUnit.DAYS.between(createdReservation.getCheckinDate(), createdReservation.getCheckoutDate());
        double totalCost = hotel.getCostPerNight() * numberOfNights;

        int rewardPoints = rewardCalculationService.calculateReward(totalCost);
        rewardDao.createOrUpdate(rewardPoints, principal.getName());

        return createdReservation;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id, Principal principal)
            throws AuthorizationException, ReservationNotFoundException {

        Reservation reservationToDelete = reservationDao.get(id, principal.getName());

        if(!reservationToDelete.canUserUpdateOrDelete(principal)) {
            throw new AuthorizationException();
        }

        reservationDao.delete(id);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@Valid @RequestBody Reservation reservation, @PathVariable int id, Principal principal)
            throws AuthorizationException, ReservationNotFoundException {

        Reservation reservationToUpdate = reservationDao.get(id, principal.getName());

        if(!reservationToUpdate.canUserUpdateOrDelete(principal)) {
            throw new AuthorizationException();
        }

        reservation.setId(id);
        reservation.setUsername(principal.getName());
        return reservationDao.update(reservation, id);
    }
}
