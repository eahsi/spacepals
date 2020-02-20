package com.project2.spacepals.services;

import com.project2.spacepals.entities.Aircraft;
import com.project2.spacepals.entities.Capacity;
import com.project2.spacepals.entities.RentalStatus;
import com.project2.spacepals.repositories.AircraftRepository;
import com.project2.spacepals.web.dtos.ShipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AircraftService {

    private AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService (AircraftRepository repo){
        super();
        this.aircraftRepository = repo;
    }

    @Transactional(readOnly = true)
    public List<Aircraft> getAllAircrafts(){
        return aircraftRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Aircraft getAircraftById(int id){
        return aircraftRepository.findById(id);
    }

    @Transactional
    public Aircraft saveAircraft(ShipDto shipdto){
        shipdto.getAircraft().setStatus(RentalStatus.AVALABLE);
        shipdto.getAircraft().setCapacity(Capacity.MEDIUM);
        shipdto.getAircraft().setRate(0);
        return aircraftRepository.saveToCompany(shipdto);
    }
}
