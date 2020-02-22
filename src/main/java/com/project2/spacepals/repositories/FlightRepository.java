package com.project2.spacepals.repositories;

import com.project2.spacepals.AppConfig;
import com.project2.spacepals.entities.Aircraft;
import com.project2.spacepals.entities.Company;
import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.entities.Planet;
import com.project2.spacepals.entities.*;
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
        System.out.println("\n\n\n\n\n\nHELP\n\n\n\n\n\n\n");
        PlanetRepository pr = new PlanetRepository(sessionFactory);
        //Planet dept = pr.findById(flightdto.);

        //placeholder
            flightdto.getFlight().setDeparture(pr.findByName(flightdto.getDeptName()));
            flightdto.getFlight().setDestination(pr.findByName(flightdto.getDestName()));
            flightdto.getFlight().setDuration(
                    flightdto.getFlight().getDeparture().getDistanceFromEarth() -
                            flightdto.getFlight().getDestination().getDistanceFromEarth());
        //placeholder end



        Aircraft aircraft;
//        if(flightdto.getShipId() == 0) {
//            Company company = AppConfig.currentUser.getCompanies().stream().findFirst().get();
//            aircraft = company.getAircrafts().stream().findFirst().get();
//        } else  {
            AircraftRepository ar = new AircraftRepository(sessionFactory);
            aircraft = ar.findById(flightdto.getShipId());
//        }

        Date date = new Date();
        flightdto.getFlight().setFlightDate(date);
        flightdto.getFlight().setAvailableSeats(aircraft.getCapacity().getCapacity());
        flightdto.getFlight().setAircraft(aircraft);
        System.out.println("\n\n\n\n\n\n" + flightdto.getFlight() + "\n\n\n\n\n\n\n");
        session.save(flightdto.getFlight());
        return flightdto.getFlight();
    }

    public Flight addPassengers(int id){

            Session session = sessionFactory.getCurrentSession();
            Flight flight = findById(id);
            flight.addPassenger(AppConfig.currentUser);
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);

            session.update(flight);

            return flight;
    }

    // method to get passengers from a flight.
    public List<User> getAllPassengers(int flightId){
        Session session = sessionFactory.getCurrentSession();
        Flight flight = findById(flightId);
        return flight.getPassengers();
    }
}
