package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Aircraft;
import com.project2.spacepals.entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class AircraftRepository implements CrudRepositories<Aircraft> {

    private SessionFactory sessionFactory;

    @Autowired
    public AircraftRepository(SessionFactory factory){
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<Aircraft> findAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Aircraft", Aircraft.class).getResultList();
    }

    @Override
    public Aircraft findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Aircraft.class, id);
    }

    @Override
    public Aircraft save(Aircraft newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Aircraft updatedObj) {
//        Session session = sessionFactory.getCurrentSession();
//        session.createQuery("update from Flight f where f.id = :id and f.available_seats = :seats",Flight.class)
//                .setParameter("id", updatedObj.getId()).setParameter("seats",updatedObj.getAvailableSeats());
        return false;
    }

    @Override
    public boolean deleteById(Aircraft deletedObj) {
        return false;
    }
}
