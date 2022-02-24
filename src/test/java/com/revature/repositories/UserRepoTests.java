package com.revature.repositories;

import com.revature.dartcart.DartCartApplication;
import com.revature.models.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DartCartApplication.class)
public class UserRepoTests {

    @Autowired
    UserRepo userRepo;

    @BeforeAll
    static void setUp() {
        User testUser = new User(1,
                "HughMann_theMan",
                "01cb92dfff4091c2bee0f343b2af049fb39b45c08a1e5132b834e12e037d919d",
                "Hugh",
                "Mann",
                "hughmann@gmail.com",
                "555-410-3296",
                1645725493993L);
        User testUser2 = new User(2,
                "Sammykins",
                "281ddb3297dab5cf529ab3cd41fb8d0140627ae0e9f99e55758c39d767ec687b",
                "Samantha",
                "Mann",
                "sammann@gmail.com",
                "555-138-8423",
                1645733144060L);
        User testUser3 = new User(3,
                "JerManny",
                "181a4295cc10b1f23a0aa947053255685e82b8eb07abdfce11cf0da341ac4f06",
                "Jer",
                "Mann",
                "jermanny@gmail.com",
                "555-021-4837",
                1645733144563L);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void givenUserId_whenFindById_thenFindUser(int id) {
        Optional<User> output = userRepo.findById(id);
        assertTrue(output.isPresent());

        User user = output.get();
        assertEquals(id, user.getId());
    }

    // GetAll
    // Add
    // Update
    // Delete

}
