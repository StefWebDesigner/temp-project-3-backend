package com.revature.dartcart.controllers;

import com.revature.dartcart.services.AuthService;
import com.revature.dartcart.services.UserService;
import com.revature.dartcart.ultilities.JwtTokenUtil;
import com.revature.models.UserLogin;
import com.revature.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserRepo userRepo;


    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping("login")
    public String login(@RequestBody UserLogin request) {
//        try {
//            Authentication authenticate = authenticationManager
//                    .authenticate(
//                            new UsernamePasswordAuthenticationToken(
//                                    request.getUsername(), request.getPassword()
//                            )
//                    );
//
//            User user = (User) authenticate.getPrincipal();
//            return ResponseEntity.ok()
//                    .header(
//                            HttpHeaders.AUTHORIZATION,
//                            jwtTokenUtil.generateAccessToken(user)
//                    )
//                    .body(user);
//        } catch (BadCredentialsException ex) {
//
//            System.out.println("username:"+request.getUsername());
//            System.out.println("password:"+request.getPassword());
//
//            System.out.println("in database:"+userService.getAll());
//
//
//
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
        System.out.println("username:"+request.getUsername());
        System.out.println("password:"+request.getPassword());
        System.out.println("in database:"+userRepo.findAll());
//        System.out.println("hahahahaha");
        return "hahahahaha";
    }
}
