package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents a User entity in the database.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedEntityGraph(
        name = "graph.UserCartItems",
        attributeNodes = @NamedAttributeNode("itemList")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String location;

    private long registrationDate;

    // Returns items in both cart and wishlist
    // Filter by CartItem's saved field to separate the lists
    @OneToMany
    @JoinColumn(name = "cart_item_id")
    @JsonIgnore
    private List<CartItem> itemList;

}
