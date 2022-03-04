package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductResponse
{
    private int shopProductId;
    private int productId;
    private List<Category> category;
    private String name;
    private int price;
    private String location;
    private int discount;
    private int quantity;
    private String description;
    private String sellerDescription;
}
