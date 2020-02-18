package com.project2.spacepals.web.controllers;

import com.project2.spacepals.entities.User;
import com.project2.spacepals.exceptions.AuthenticationException;
import com.project2.spacepals.exceptions.AuthorizationException;
import com.project2.spacepals.services.UserService;
import com.project2.spacepals.web.dtos.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
    @RequestMapping("/users")
    public class UserController {

        private UserService userService;

        @Autowired
        public UserController(UserService service) {
            super();
            this.userService = service;
        }

       // @Secured(allowedRoles = {"Admin", "Dev"})
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public List<User> getAllUsers(HttpServletRequest req) {
            return userService.getAllUsers();
        }

        @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public User registerNewUser(@RequestBody User newUser) {
            return userService.register(newUser);
        }


        @ExceptionHandler
        @ResponseStatus(HttpStatus.FORBIDDEN)
        public ErrorResponse handleAuthorizationException(AuthorizationException e) {
            ErrorResponse err = new ErrorResponse();
            err.setMessage(e.getMessage());
            err.setTimestamp(System.currentTimeMillis());
            err.setStatus(403);
            return err;
        }

        @ExceptionHandler
        @ResponseStatus(HttpStatus.UNAUTHORIZED)
        public ErrorResponse handleAuthenticationException(AuthenticationException e) {
            ErrorResponse err = new ErrorResponse();
            err.setMessage(e.getMessage());
            err.setTimestamp(System.currentTimeMillis());
            err.setStatus(401);
            return err;

        }
    }
