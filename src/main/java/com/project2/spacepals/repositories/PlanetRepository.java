package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanetRepository implements CrudRepositories<Planet> {
    private SessionFactory sessionFactory;


    @Override
    public List<Planet> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Planets", Planet.class).getResultList();
    }

    @Override
    public Planet findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Planet.class, id);
    }

    @Override
    public Planet save(Planet newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Planet updatedObj) {
        boolean updateSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update from Planets p where p.id = :id", Planet.class)
                .setParameter("id", updatedObj.getId());
        return updateSuccessful; // to check this further
    }

    @Override
    public boolean deleteById(Planet deletedObj) {
        boolean updateSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update from Planets p where p.id = :id", Planet.class)
                .setParameter("id", deletedObj.getId());
        return updateSuccessful;
    }
}
