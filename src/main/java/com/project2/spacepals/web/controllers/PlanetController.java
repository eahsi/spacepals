package com.project2.spacepals.web.controllers;


import com.project2.spacepals.entities.Planet;
import com.project2.spacepals.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService service){
        super();
        this.planetService = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Planet> getALLPlanets(HttpServletRequest req){
        return planetService.getAllPlanets();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Planet getPlanetbyId(@PathVariable int id){
        return planetService.getPlanetById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Planet registerPlanet(@RequestBody Planet planet){
        return planetService.registerPlanet(planet);
    }

    @GetMapping(value="/byname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Planet getPlanetbyName(@PathVariable String name) { return planetService.getByName(name);}
}
