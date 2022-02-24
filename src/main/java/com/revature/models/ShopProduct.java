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
    private int id;

    @ManyToOne
    @JoinColumn(name="fk_shop_id")
    private int fkShopId;

    private int quantity;
    private double price;
    private double discount;
}
