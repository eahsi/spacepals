package com.project2.spacepals.repositories;

import com.project2.spacepals.entities.Aircraft;
import com.project2.spacepals.entities.Company;
import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.web.dtos.AircraftDto;
import com.project2.spacepals.web.dtos.ShipDto;
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
    public Aircraft save(Aircraft newobj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newobj);
        return newobj;
    }

    public void saveToCompany(AircraftDto aircraftDto, Aircraft aircraft) {
        Session session = sessionFactory.getCurrentSession();
        CompanyRepository cr = new CompanyRepository(sessionFactory);
        Company company = cr.findById(aircraftDto.getCompanyId());
        company.addAircraft(aircraft);
        session.update(company);
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
