package com.project2.spacepals.services;

import com.project2.spacepals.entities.Role;
import com.project2.spacepals.entities.User;
import com.project2.spacepals.exceptions.AuthenticationException;
import com.project2.spacepals.exceptions.BadRequestException;
import com.project2.spacepals.repositories.UserRepository;
import com.project2.spacepals.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService  {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo){
        super();
        this.userRepo=repo;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers(){

        return userRepo.findAll();
    }

    @Transactional(readOnly = true)
    public User authenticate(Credentials creds){
        if(creds == null || creds.getEmail() == null || creds.getPassword() == null ||
        creds.getEmail().equals("") || creds.getPassword().equals(""))
        {throw new BadRequestException("Invalid credentials object provided!");
        }
        User retrievedUser = userRepo.findUserByCredentials(creds);
        if(retrievedUser == null){
            throw new AuthenticationException();
        }
        return retrievedUser;
    }

    @Transactional
    public User register(User newUser) {

        // validation would go here...

        newUser.setRole(Role.BASIC_USER);
        return userRepo.save(newUser);

    }
}
