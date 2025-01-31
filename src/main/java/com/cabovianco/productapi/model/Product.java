package com.cabovianco.productapi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class Product {

    @Null
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be less than zero")
    private Double price;

}
