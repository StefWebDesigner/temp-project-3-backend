package com.revature.controllers;

import com.revature.models.Invoice;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserProfileController {

  private UserServiceImpl userService;
  
  @Autowired
  public UserProfileController(UserServiceImpl userService) {
	  this.userService = userService;
  }
  

  
//  @GetMapping("/getProfile/{id}")
//  public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
//    Optional<User> user = userService.getUserById(Integer.parseInt(id));
//    return user.isPresent()
//      ? new ResponseEntity<User>(user.get(), HttpStatus.OK)
//      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//  }
  
  @GetMapping("/getProfile")
  public ResponseEntity<User> getUserByToken(Authentication auth) {
	  int id = userService.getUserByUsername(auth.getName()).getId();
    Optional<User> user = userService.getUserById(id);
    return user.isPresent()
      ? new ResponseEntity<User>(user.get(), HttpStatus.OK)
      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  
  
  


}
