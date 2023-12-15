package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

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
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(required = false) String state, @RequestParam(required = false) String city) {
        return hotelDao.getHotelsByStateAndCity(state, city);
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.getHotelById(id);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservation(){
        return reservationDao.getReservations();
    }
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable int id){
        return reservationDao.getReservationById(id);
    }
    @RequestMapping(path = "/hotels/{hotelId}/reservations")
    public List<Reservation> getReservationsByHotelId(@PathVariable int hotelId){
        return reservationDao.getReservationsByHotel(hotelId);
    }
    //up to use what to give back, we do decide to give a reservation back (below)
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation (@RequestBody Reservation reservation){
        return reservationDao.createReservation(reservation);
    }
}
