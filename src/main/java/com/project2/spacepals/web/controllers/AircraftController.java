package com.project2.spacepals.web.controllers;

import com.project2.spacepals.entities.Aircraft;
import com.project2.spacepals.services.AircraftService;
import com.project2.spacepals.web.dtos.AircraftDto;
import com.project2.spacepals.web.dtos.ShipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    private AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService service){
        super();
        this.aircraftService = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Aircraft> getAircrafts(HttpServletRequest req){
        return aircraftService.getAllAircrafts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft getAircraftById(@PathVariable int id){
        return aircraftService.getAircraftById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft registerAircraft(@RequestBody AircraftDto aircraftDto){

        return aircraftService.saveAircraft(aircraftDto);
    }

}
