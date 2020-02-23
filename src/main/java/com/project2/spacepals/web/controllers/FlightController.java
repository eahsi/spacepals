package com.project2.spacepals.web.controllers;


import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.entities.User;
import com.project2.spacepals.services.FlightService;
import com.project2.spacepals.web.dtos.AddPassengerDtos;
import com.project2.spacepals.web.dtos.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController (FlightService service){
        super();
        this.flightService = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight registerFlight(@RequestBody FlightDto flightdto){
        return flightService.register(flightdto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> getFlights (HttpServletRequest req){
        return flightService.allFlights();
    }

   // @ResponseStatus(HttpStatus.OK)
    @GetMapping(value= "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Flight getFlightById(@PathVariable int id){
        return flightService.getFlightById(id);
    }


    // controller to book a flight
    @PutMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight addPassenger(@PathVariable int id){
        return flightService.addFlightPassengers(id);
    }

    // controller to get all passengers from a flight
    @GetMapping(value= "/passengers/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllPassengers(@PathVariable int id){
        return flightService.getPassengers(id);
    }
}
