package com.revature.controllers;

import com.revature.models.UserLogin;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.utilities.JwtTokenUtil;
import com.revature.utilities.EmailServiceImpl;
import java.util.Locale;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
	/*
	 * @Autowired AuthenticationManager authenticationManager;
	 * 
	 * @Autowired JwtTokenUtil jwtTokenUtil;
	 * 
	 * @Autowired UserService userService;
	 * 
	 * @Autowired AuthService authService;
	 * 
	 */
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final UserService userService;
	private final AuthService authService;
	private final EmailServiceImpl emailServiceImp;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
			UserService userService, AuthService authService, EmailServiceImpl emailServiceImp) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userService = userService;
		this.authService = authService;
		this.emailServiceImp = emailServiceImp;
	}

	@PostMapping("/login")
	public ResponseEntity<com.revature.models.User> login(@RequestBody UserLogin request) {
		try {
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			User user = (User) authenticate.getPrincipal();
			com.revature.models.User retUser = userService
					.getUserByUsername(user.getUsername().toLowerCase(Locale.ROOT));
			retUser.setPassword(null);

			return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
					.body(retUser);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping("/resetpass")
	public String resetPassword(@RequestBody String username) {
		com.revature.models.User user = userService.getUserByUsername(username);
		emailServiceImp.sendSimpleMessage(user.getEmail(), "password reset email test", "didn't implement yet stay tuned :)");
		return "test";
	}
}
