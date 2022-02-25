package com.revature.dartcart.filters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
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


public class TestJwtFilter {
	
	// inject jwt token util class and user repo before
	// jwtTokenUtil,  getUsername
	// CHECKS: token valid, username, is authenticated
	// assertTrue( SecurityContextHolder.getContext().getAuthentication().isAuthenticated() );

	// class that needs to be implemented
	private static final String CLASSNAME = "com.revature.dartcart.filters.JwtTokenFilter";
	// method name
	private static final String FILTER = "doFilterInternal";
	private static final String VALIDATE = "validate";
	// object of the class
	private static Object tokenFilter;
	private static Object tokenUtil;
	// the doFilter method we are testing
	private static Method doFilterInternal;
	private static Method validate;
	
	@MockBean private static Class JwtTokenUtil;
	@MockBean private static Class UserRepo;
	@Autowired private MockMvc mvc;
	// @Autowired MockHttpServletRequest request;
	
	
	@BeforeAll
	static void testSetup(@Autowired ApplicationContext app) throws ClassNotFoundException, NoSuchMethodException {
		//Authentication a = SecurityContextHolder.getContext().getAuthentication();
		
		tokenFilter = app.getBean( Class.forName(CLASSNAME) );
		tokenFilter = tokenFilter.getClass().getConstructor(JwtTokenUtil, UserRepo);
		doFilterInternal = tokenFilter.getClass().getMethod(FILTER, HttpServletRequest.class, HttpServletResponse.class, FilterChain.class);
		
		tokenUtil = app.getBean( Class.forName("JwtTokenUtil") );
		validate = tokenUtil.getClass().getMethod(VALIDATE, String.class);
	}
	
	@Test
	void tokenInvalid() throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
		
		//MockServletContext servletContext = new MockServletContext();
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		MockFilterChain mockChain = new MockFilterChain();
		doFilterInternal.invoke(request, response, mockChain) ;
		
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
