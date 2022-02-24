package com.revature.dartcart.utilities;

import com.revature.dartcart.DartCartApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JwtTokenUtilTest {

    // Class that needs to be implemented
    private static final String CLASSNAME = "com.revature.dartcart.utilities.JwtTokenUtil";
    // Method name of the validate function
    private static final String VALIDATE = "validate";
    // object of the class
    private static Object tokenUtility;
    // the validate function we are testing
    private static Method validate;

    /**
     * Tests the validation of JWTTokens
     */
    @BeforeAll
    void testingSetup() {
        try {
            tokenUtility = DartCartApplication.app.getBean(Class.forName(CLASSNAME));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class: " + CLASSNAME + " needs to be implemented", e);
        }

        // get the method from the object
        try {
            validate = tokenUtility.getClass().getMethod(VALIDATE);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Method: " + VALIDATE + " needs to be implemented", e);
        }
    }

    @Test
    void validate_sad_invalid() throws InvocationTargetException, IllegalAccessException {
        boolean retVal = (Boolean) validate.invoke(tokenUtility, "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0aW5ndXNlcnBsZWFzZWlnbm9yZSIsImlzcyI6InRlc3Rpbmdpc3N1ZXJwbGVhc2VpZ25vcmUiLCJpYXQiOjE2NDU3MjkwODgsImV4cCI6MTY0Mzc4NDIzNH0.gIl2FTdCBVdnLVAVxRUrJj3SWck34qP8wkRCFz-gHoxmou3ljSOyGQb7gnmyDRgFfCh0q7Sro948g0qBuO");
        assertTrue(retVal);
    }

    @Test
    void validate_sad_expired() throws InvocationTargetException, IllegalAccessException {
        boolean retVal = (Boolean) validate.invoke(tokenUtility, "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0aW5ndXNlcnBsZWFzZWlnbm9yZSIsImlzcyI6InRlc3Rpbmdpc3N1ZXJwbGVhc2VpZ25vcmUiLCJpYXQiOjE2NDU3MjkxNzIsImV4cCI6MTY0NTEyNDM3Mn0._f-QeO7KuMjCvXvUiGZlPeQDsMVvDtRvZfj-d0VMjyB-1wPauiWfmSVpMyclGUzazu9KMM238eyQYrZAVqnrkA");
        assertTrue(retVal);
    }

    @Test
    void validate_sad_malformed() throws InvocationTargetException, IllegalAccessException {
        boolean retVal = (Boolean) validate.invoke(tokenUtility, "tokem");
        assertTrue(retVal);
    }

    @Test
    void validate_sad_emptyString() throws InvocationTargetException, IllegalAccessException {
        boolean retVal = (Boolean) validate.invoke(tokenUtility, "");
        assertTrue(retVal);
    }

    // Assumes the Secret for the JWT Token:
    // aa2228b097e40541dfb229bacf40f00a81eac92a1b11412c4d678cb99feba0e96187db65b4b28eefd90097aa3b668790189dc1635823b7bb44cc5b4abdc61c37
    @Test
    void validate_happy() throws InvocationTargetException, IllegalAccessException {
        boolean retVal = (Boolean) validate.invoke(tokenUtility, "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0aW5ndXNlcnBsZWFzZWlnbm9yZSIsImlzcyI6InRlc3Rpbmdpc3N1ZXJwbGVhc2VpZ25vcmUiLCJpYXQiOjE2NDU3MjkwODgsImV4cCI6MTY0Mzc4NDIzNH0.gIl2FTdCBVdnLVAVxRUrJj3SWck34qP8wkRCFz-gHoxmou3ljSOyGQb7gnmyDRgFfCh0q7Sro948g0qBuOwcPw");
        assertTrue(retVal);
    }
}
