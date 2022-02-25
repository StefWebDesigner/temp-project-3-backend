package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Table(name="shop_product")
public class ShopProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_product_id", updatable = false)
    private int id;

//    @ManyToOne
//    @JoinColumn(name="shop_id")
//    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private int product;

    private int quantity;

    private double price;

    private double discount;
}