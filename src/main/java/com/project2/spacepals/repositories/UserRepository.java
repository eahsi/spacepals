package com.project2.spacepals.repositories;

import com.project2.spacepals.AppConfig;
import com.project2.spacepals.entities.Company;
import com.project2.spacepals.entities.Role;
import com.project2.spacepals.entities.User;
import com.project2.spacepals.web.dtos.Credentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository implements CrudRepositories<User> {

    private SessionFactory sessionFactory;

    public User findUserByCredentials(Credentials creds) {

        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from User au where au.email = :un and au.password = :pw", User.class)
                .setParameter("un", creds.getEmail())
                .setParameter("pw", creds.getPassword())
                .getSingleResult();

    }

    @Autowired
    public UserRepository(SessionFactory factory) {
        super();
        this.sessionFactory = factory;
    }

    @Override
    public List<User> findAll() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();

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
        return false;
    }

    @Override
    public boolean deleteById(User deletedObj) {
        return false;
    }


    // this method will be tested later.
    public Company addCompany(Company comp){

        Session session = sessionFactory.getCurrentSession();
        //User currentUser= session.get(User.class, 3);
        User currentUser = AppConfig.currentUser;
        //comp.setManager(currentUser);

        // now save the company in the company table first
        CompanyRepository compRepo = new CompanyRepository(sessionFactory);
        compRepo.save(comp);

        currentUser.addCompany(comp);
        currentUser.setRole(Role.FLIGHT_MANAGER);
        session.update(currentUser);
        return comp;
    }


}
