package com.revature.dartcart.authentication;



import com.revature.dartcart.services.AuthService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationTest {


    String userName = "Username";
    String falseUser = "fakeUser";

    @MockBean
    AuthService as;


    @BeforeAll
    static void setUp() {

    }

    @Test
    void valid_GetUsernameByUsername() {
        AuthService as = new AuthService();
        assertNotNull(as.loadUserByUsername(userName));
    }

    @Test
    void invalid_GetUsernameByUsername() {
        AuthService as = new AuthService();
        assertNull(as.loadUserByUsername(falseUser));
    }

}
