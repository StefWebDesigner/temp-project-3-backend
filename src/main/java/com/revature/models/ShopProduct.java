package com.revature.models;

import lombok.Data;

import javax.persistence.*;

@Entity
public class ShopProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="fk_shop_id")
    private int fkShopId;

    private int quantity;
    private double price;
    private double discount;
}
