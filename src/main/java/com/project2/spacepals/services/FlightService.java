package com.project2.spacepals.services;

import com.project2.spacepals.entities.Capacity;
import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.entities.FlightStatus;
import com.project2.spacepals.entities.User;
import com.project2.spacepals.repositories.FlightRepository;
import com.project2.spacepals.web.dtos.DtoFlight;
import com.project2.spacepals.web.dtos.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightService (FlightRepository flightRepo){
        super();
        this.flightRepository = flightRepo;
    }

    @Transactional
    public Flight register(DtoFlight dtoFlight){
//        flightdto.getFlight().setStatus(FlightStatus.OPEN);
//        return flightRepository.realSave(flightdto);
        Flight flight = new Flight();
        flight.setAvailableSeats(200);
        flight.setStatus(FlightStatus.OPEN);
        flight.setCost(dtoFlight.getCost());
        flight.setDuration(3000);
        return flightRepository.saveFlight(flight, dtoFlight);
    }

    @Transactional(readOnly = true)
    public List<Flight> allFlights(){
        return flightRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Flight getFlightById(int id){
        return flightRepository.findById(id);
    }

    @Transactional
    public Flight addFlightPassengers(int id){
        return flightRepository.addPassengers(id);
    }

    @Transactional(readOnly = true)
    public List<User> getPassengers(int flightId){
        return flightRepository.getAllPassengers(flightId);
    }

}
