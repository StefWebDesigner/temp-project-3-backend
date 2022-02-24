package com.revature.models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="fk_shop_product_id")
    private int fkShopProductId;

    private String name;
    private String description;
}
