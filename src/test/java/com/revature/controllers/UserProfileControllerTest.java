package com.revature.controllers;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.revature.driver.DartCartApplication;
import com.revature.models.User;
import com.revature.services.UserServiceImpl;

@SpringBootTest(classes = DartCartApplication.class)
public class UserProfileControllerTest {

	@MockBean
	private UserServiceImpl mockUserService;
	
	@Autowired
	private UserProfileController sut;
	
	@Test
	public void test_getUserByToken() {
		User authUser = new User(); authUser.setId(5);authUser.setUsername("username");
		Optional<User> opUser = Optional.of(authUser);
		
		Authentication auth = Mockito.mock(Authentication.class);
		Mockito.when(auth.getName()).thenReturn("username");
		
		Mockito.when(mockUserService.getUserByUsername("username")).thenReturn(authUser);
		Mockito.when(mockUserService.getUserById(5)).thenReturn(opUser);
		
		ResponseEntity res = sut.getUserByToken(auth);
		Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
		Assertions.assertEquals(authUser, res.getBody());
	}
	
	@Test
	public void test_updateProfile() {
		User oldUser = new User(); 
		oldUser.setId(5); oldUser.setUsername("username"); oldUser.setFirstName("firstname"); oldUser.setLastName("lastname"); 
		oldUser.setEmail("test@email.com"); oldUser.setPhone("123-456-7890"); oldUser.setLocation("1 street city, state 01234");
		
		User newUser = new User();
		newUser.setId(5); newUser.setUsername("updateusername"); newUser.setFirstName("updatefirstname"); newUser.setLastName("updatelastname"); 
		newUser.setEmail("updatetest@email.com"); newUser.setPhone("update123-456-7890"); newUser.setLocation("update1 street city, state 01234");
		
		Optional<User> opOldUser = Optional.of(oldUser);
		
		Authentication auth = Mockito.mock(Authentication.class);
		Mockito.when(auth.getName()).thenReturn("username");
		
		Mockito.when(mockUserService.getUserByUsername("username")).thenReturn(oldUser);
		Mockito.when(mockUserService.getUserById(5)).thenReturn(opOldUser);
		
		ResponseEntity res = sut.updateProfile(newUser, auth);
		Mockito.verify(mockUserService).updateUser(opOldUser.get());
		Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
		Assertions.assertEquals(oldUser, res.getBody());
	}
}
