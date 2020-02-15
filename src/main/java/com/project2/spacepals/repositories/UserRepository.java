package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Users;
import com.project2.spacepals.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CrudRepositories<Users> {
    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory factory){
        super();
        this.sessionFactory = factory;
    }

    public Users findUserByCredentials(Credentials creds){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Users u where u.email = :em and u.password = :pw", Users.class)
                .setParameter("em", creds.getEmail())
                .setParameter("pw", creds.getPassword())
                .getSingleResult();
    }


    @Override
    public List<Users> findAll() {
        List<Users> users = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        users = session.createQuery("from Users", Users.class).getResultList();

        return users;
    }

    @Override
    public Users findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Users.class, id);

    }

    @Override
    public Users save(Users newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(Users updatedObj) {
        boolean updateSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update from Users u where u.id = :id and u.role = :newrole", Users.class)
                .setParameter("id", updatedObj.getId()).setParameter("newrole",updatedObj.getRole());
        return updateSuccessful;
    }

    @Override
    public boolean deleteById(Users deletedObj) {
        boolean deleteSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Users u where u.id = :id", Users.class)
                .setParameter("id",deletedObj.getId());
        return deleteSuccessful;
    }
}
