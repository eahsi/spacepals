package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.User;
import com.project2.spacepals.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CrudRepositories<User> {
    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory factory){
        super();
        this.sessionFactory = factory;
    }

    public User findUserByCredentials(Credentials creds){
        Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from User u where u.email = :em and u.password = :pw", User.class)
                    .setParameter("em", creds.getEmail())
                    .setParameter("pw", creds.getPassword())
                    .getSingleResult();
        }


    @Override
    public List<User> findAll() {
        List<User> user = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
            user = session.createQuery("from User", User.class).getResultList();

        return user;
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
            return session.get(User.class, id);

    }

    @Override
    public User save(User newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(User updatedObj) {
        boolean updateSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
            session.createQuery("update from User u where u.id = :id and u.role = :newrole", User.class)
                    .setParameter("id", updatedObj.getId()).setParameter("newrole",updatedObj.getRole());
            return updateSuccessful;
    }

    @Override
    public boolean deleteById(User deletedObj) {
        boolean deleteSuccessful = false;
        Session session = sessionFactory.getCurrentSession();
            session.createQuery("delete from User u where u.id = :id", User.class)
                    .setParameter("id",deletedObj.getId());
        return deleteSuccessful;
    }
}
