package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="fk_shop_product_id")
    private int fkShopProductId;

    private String name;
    private String description;
}
