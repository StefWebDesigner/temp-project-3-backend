package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    JwtTokenUtil util;

    // Return JWT for automatic login after registration
    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> newUser(@RequestBody User u) {
        try {
            User created = us.addUser(u);
            if (created.getId() != 0) {
                String token =util.generateAccessToken(created);
                return ResponseEntity.ok(token);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
