package com.cabovianco.productapi.model;

import lombok.Data;

@Data
public class Product {

    private Integer id;
    private String name;
    private String category;
    private Double price;

}
