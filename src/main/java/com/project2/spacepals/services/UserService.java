package com.project2.spacepals.services;

import com.project2.spacepals.entities.Users;
import com.project2.spacepals.exceptions.AuthenticationException;
import com.project2.spacepals.exceptions.BadRequestException;
import com.project2.spacepals.repositories.CrudRepositories;
import com.project2.spacepals.repositories.UserRepository;
import com.project2.spacepals.web.dtos.Credentials;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class UserService  {
    private UserRepository userRepo;
    @Autowired
    public UserService(UserRepository repo){
        super();
        this.userRepo=repo;
    }

    @Transactional(readOnly = true)
    public List<Users> getAllUser(){
        return userRepo.findAll();
    }
    @Transactional(readOnly = true)
    public Users authenticate(Credentials creds){
        if(creds == null || creds.getEmail() == null || creds.getPassword() == null ||
        creds.getEmail().equals("") || creds.getPassword().equals(""))
        {throw new BadRequestException("Invalid credentials object provided!");
        }
        Users retrievedUser = userRepo.findUserByCredentials(creds);
        if(retrievedUser == null){
            throw new AuthenticationException();
        }
        return retrievedUser;
    }
}
