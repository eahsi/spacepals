package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepository implements CrudRepositories<Flight> {

    private SessionFactory sessionFactory;

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
}
