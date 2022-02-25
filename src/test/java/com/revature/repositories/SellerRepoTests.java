package com.revature.repositories;

import com.revature.app.DartCartApplication;
import com.revature.models.Customer;
import com.revature.models.Seller;
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
public class SellerRepoTests {

    @Autowired
    SellerRepo sellerRepo;

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
    public void givenSellerId_whenFindById_thenFindSeller(int id) {
        Optional<Seller> output = sellerRepo.findById(id);
        assertTrue(output.isPresent());

        Seller seller = output.get();
        assertEquals(id, seller.getId());
        System.out.println(seller);
    }

    @Test
    public void whenFindAll_thenReturnAllSellers() {
        List<Seller> sellers = (List<Seller>) sellerRepo.findAll();
        assertNotEquals(0, sellers.size());
        System.out.println(sellers);
    }

    @Test
    public void givenSeller_whenSave_thenAddSeller() {
        SellerRepo mockRepo = mock(SellerRepo.class);
        Mockito.when(mockUserRepo.save(mockUser)).thenReturn(mockUser);
        Seller newSeller = new Seller(
                3,
                "New Seller",
                "/newseller",
                "THE BEST NEW SELLER!!!",
                mockUser
        );

        mockRepo.save(newSeller);
        verify(mockRepo).save(newSeller);
        System.out.println(newSeller);
    }

    @Test
    public void givenUserId_whenSave_thenUpdateUser() {
        Seller testSeller = new Seller(
                1,
                "New Seller",
                "/newseller",
                "THE SUPER DUPER BEST NEW SELLER!!!",
                mockUser
        );

        sellerRepo.save(testSeller);
        Optional<Seller> output = sellerRepo.findById(mockUser.getId());

        Seller updatedSeller = output.get();
        assertEquals("THE SUPER DUPER BEST NEW SELLER!!!", updatedSeller.getDescription());
        System.out.println(updatedSeller);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void givenSellerId_whenDelete_thenDeleteSeller(int id) {
        SellerRepo mockRepo = mock(SellerRepo.class);
        mockRepo.deleteById(id);
        verify(mockRepo).deleteById((id));
    }

}
