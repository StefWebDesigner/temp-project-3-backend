package com.revature.repositories;

import com.revature.dartcart.DartCartApplication;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DartCartApplication.class)
public class UserRepoTests {

    @Autowired
    UserRepo userRepo;

    // @ParameterizedTest
    // @ValueSource(ints = {1, 2, 3})
    @Test
    public void givenUserId_whenFindById_thenFindUser() {
        User testUser = new User(1,
                "foasijdf",
                "jpoasijdf",
                "poaijsfdi",
                "japosidfj",
                "jpaosidfj",
                "jpoasidjf",
                1645725493993L);
        int id = 1;

        // Waiting to set up a SQL or H2 database.
        // Optional<User> output = userRepo.findById(id);
        // assertFalse(output.isPresent());

        // Testing that the test continues to run after the first passed assertion.
        assertEquals(id, testUser.getId());
        assertNotNull(testUser);
    }

    // GetAll
    // Add
    // Update
    // Delete

}
