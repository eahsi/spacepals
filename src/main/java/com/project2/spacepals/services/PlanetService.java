package com.project2.spacepals.services;

import com.project2.spacepals.entities.Planet;
import com.project2.spacepals.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository repo){
        super();
        this.planetRepository = repo;
    }

    @Transactional(readOnly = true)
    public List<Planet> getAllPlanets(){
        return planetRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Planet getPlanetById(int id){
        return planetRepository.findById(id);
    }

    @Transactional
    public Planet registerPlanet(Planet newObj){
        return planetRepository.save(newObj);
    }
}
