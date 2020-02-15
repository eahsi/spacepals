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
        return null;
    }

    @Override
    public Company findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public Company save(Company newObj) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public boolean update(Company updatedObj) {
        Session session = sessionFactory.getCurrentSession();
        return false;
    }

    @Override
    public boolean deleteById(Company deletedObj) {
        Session session = sessionFactory.getCurrentSession();
        return false;
    }
}
