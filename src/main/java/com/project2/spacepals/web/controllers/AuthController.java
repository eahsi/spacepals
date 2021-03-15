package com.project2.spacepals.web.controllers;

import com.project2.spacepals.AppConfig;
import com.project2.spacepals.entities.User;
import com.project2.spacepals.web.dtos.Principal;
import com.project2.spacepals.services.UserService;
import com.project2.spacepals.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService service) {
        super();
        this.userService = service;
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
            public User authenticate(@RequestBody Credentials creds, HttpServletResponse resp){
    //public Principal authenticate(@RequestBody Credentials creds, HttpServletResponse resp, HttpServletRequest req) {
        Principal payload = userService.authenticate(creds).extractPrincipal();
        //resp.setHeader(JwtConfig.HEADER, JwtGenerator.createJwt(payload));
        //HttpSession session = req.getSession(false);
       // User currentUser = session.setAttribute("user", userService.authenticate(creds));
      User u = userService.authenticate(creds);

      AppConfig.currentUser = u;
        //return payload;
        return u;
    }

}
