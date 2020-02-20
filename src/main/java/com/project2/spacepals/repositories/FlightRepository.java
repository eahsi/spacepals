package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Aircraft;
import com.project2.spacepals.entities.Company;
import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.entities.Planet;
import com.project2.spacepals.web.dtos.FlightDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class FlightRepository implements CrudRepositories<Flight> {

    private SessionFactory sessionFactory;

    @Autowired
    public FlightRepository(SessionFactory session){
        super();
        this.sessionFactory = session;
    }

    @Override
    public List<Flight> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Flight", Flight.class).getResultList();
    }

    @Override
    public Flight findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Flight.class, id);
    }

    @Override
    public Flight save(Flight newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Flight updatedObj) {
        //boolean updateSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
       session.createQuery("update from Flight f where f.id = :id and f.available_seats = :seats",Flight.class)
                .setParameter("id", updatedObj.getId()).setParameter("seats",updatedObj.getAvailableSeats());
       return true;
    }

    @Override
    public boolean deleteById(Flight deletedObj) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Flight f where f.id = :id",Flight.class)
                .setParameter("id",deletedObj.getId());
        return true;
    }

    public Flight realSave(FlightDto flightdto) {
        Session session = sessionFactory.getCurrentSession();
//        CompanyRepository cr = new CompanyRepository(sessionFactory);
//        Company company = cr.findById(flightdto.getCompanyId());
        PlanetRepository pr = new PlanetRepository(sessionFactory);
//        Planet dept = pr.findById(flightdto.);

        //placeholder
            flightdto.getFlight().setDeparture(pr.findById(0));
            flightdto.getFlight().setDestination(pr.findById(1));
            flightdto.getFlight().setDuration(
                    flightdto.getFlight().getDeparture().getDistanceFromEarth() -
                            flightdto.getFlight().getDestination().getDistanceFromEarth());
        //placeholder end
        Date date = new Date();
        flightdto.getFlight().setFlightDate(date);
        AircraftRepository ar = new AircraftRepository(sessionFactory);
        Aircraft aircraft = ar.findById(flightdto.getShipId());
        //aircraft.addFlight(flightdto.getFlight());
        flightdto.getFlight().setAircraft(aircraft);
        session.save(flightdto.getFlight());
        return flightdto.getFlight();
    }
}
