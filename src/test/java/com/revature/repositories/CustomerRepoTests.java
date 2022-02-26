package com.revature.repositories;

import com.revature.app.DartCartApplication;
import com.revature.models.Customer;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = DartCartApplication.class)
public class CustomerRepoTests {

    @Autowired
    CustomerRepo customerRepo;

    @MockBean
    private UserRepo mockUserRepo;

    final private User mockUser = new User(
            1,
            "test1",
            "password",
            "Test",
            "User",
            "test1@dartcart.net",
            "123-456-7890",
            123563672L
    );

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void givenCustomerId_whenFindById_thenFindCustomer(int id) {
        Optional<Customer> output = customerRepo.findById(id);
        assertTrue(output.isPresent());

        Customer customer = output.get();
        assertEquals(id, customer.getId());
        System.out.println(customer);
    }

    @Test
    public void whenFindAll_thenReturnAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepo.findAll();
        assertNotEquals(0, customers.size());
        System.out.println(customers);
    }

    @Test
    public void givenCustomer_whenSave_thenAddUser() {
        CustomerRepo mockRepo = mock(CustomerRepo.class);
        Mockito.when(mockUserRepo.save(mockUser)).thenReturn(mockUser);
        Customer newCustomer = new Customer(
                3,
                "999 Example Blvd, Anytown, VA 23462",
                mockUser
        );

        mockRepo.save(newCustomer);
        verify(mockRepo).save(newCustomer);
        System.out.println(newCustomer);
    }

    @Test
    public void givenCustomerId_whenSave_thenUpdateCustomer() {
        Customer testCustomer = new Customer(
                1,
                "410 Super Blvd, Anytown, VA 23462",
                mockUser
        );

        customerRepo.save(testCustomer);
        Optional<Customer> output = customerRepo.findById(mockUser.getId());

        Customer updatedUser = output.get();
        assertEquals("410 Super Blvd, Anytown, VA 23462", updatedUser.getLocation());
        System.out.println(updatedUser);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void givenCustomerId_whenDelete_thenDeleteCustomer(int id) {
        CustomerRepo mockRepo = mock(CustomerRepo.class);
        mockRepo.deleteById(id);
        verify(mockRepo).deleteById((id));
    }

}
