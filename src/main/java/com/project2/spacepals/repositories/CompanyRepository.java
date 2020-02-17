package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CompanyRepository implements CrudRepositories<Company> {
    private SessionFactory sessionFactory;



    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from company",Company.class).getResultList();
    }

    @Override
    public Company findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class,id);
    }

    @Override
    public Company save(Company newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Company updatedObj) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update from Company c where c.id = :id")
                .setParameter("id",updatedObj.getId());
        return false;
    }

    @Override
    public boolean deleteById(Company deletedObj) {
        Session session = sessionFactory.getCurrentSession();
       session.createQuery("delete from Company c where c.id =:id", Company.class)
               .setParameter("id",deletedObj.getId());
        return false;
    }
}
