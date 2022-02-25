package com.revature.dartcart.filters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class TestJwtFilter {
	
	// inject jwt token util class and user repo before
	// jwtTokenUtil,  getUsername
	// CHECKS: token valid, username, is authenticated
	// assertTrue( SecurityContextHolder.getContext().getAuthentication().isAuthenticated() );
	
	@Mock private JwtTokenFilter jtf;
	@MockBean private static Class JwtTokenUtil;
	@MockBean private static Class UserRepo;
	@Autowired private MockMvc mvc;
	// @Autowired MockHttpServletRequest request;
	
	
	@BeforeAll
	static void testSetup(@Autowired ApplicationContext app) throws ClassNotFoundException, NoSuchMethodException {
		//Authentication a = SecurityContextHolder.getContext().getAuthentication();
	}
	
	@Test
	void tokenInvalid() throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
		//MockServletContext servletContext = new MockServletContext();
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		MockFilterChain mockChain = new MockFilterChain();
		//jtf.doFilterInternal.invoke(request, response, mockChain) ;
		request.addHeader(HttpHeaders.AUTHORIZATION, "invalid");
		jtf.doFilterInternal(request, response, mockChain);
		//Mockito.doThrow();
		//assertThrows(  );
	}
	
	
	@Test
	public void testIsAuthenticated(){
		assertFalse( SecurityContextHolder.getContext().getAuthentication().isAuthenticated() );
	}
	
	@AfterEach
	public void clearSecurityContext() {
		SecurityContextHolder.clearContext();
	}
	
}
