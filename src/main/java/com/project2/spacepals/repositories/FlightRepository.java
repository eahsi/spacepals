package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FlightRepository implements CrudRepositories<Flight> {
    private SessionFactory sessionFactory;


    @Override
    public List<Flight> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public Flight findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public Flight save(Flight newObj) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public boolean update(Flight updatedObj) {
        Session session = sessionFactory.getCurrentSession();
        return false;
    }

    @Override
    public boolean deleteById(Flight deletedObj) {
        Session session = sessionFactory.getCurrentSession();
        return false;
    }
}
