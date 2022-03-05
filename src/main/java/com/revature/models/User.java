package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
@Table(name = "Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String location;

    @NotNull
    private long registrationDate;

    // Returns items in both cart and wishlist
    // Filter by CartItem's saved field to separate the lists
    @OneToMany
    @JoinColumn(name = "cart_item_id")
    @JsonIgnore
    private List<CartItem> itemList;

//
//    @OneToMany(mappedBy = "Users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "invoice_id")
//    @JsonIgnore
//    private List<Invoice> invoiceList;
//
//
//
//
//    public User(int id, String username, String password, String firstName, String lastName, String email, String phone, String location, long registrationDate, List<CartItem> cartItems) {
//        this.invoiceList = new ArrayList<Invoice>();
//        this.itemList = cartItems;
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phone = phone;
//        this.location = location;
//        this.registrationDate = registrationDate;
//
//    }
}
