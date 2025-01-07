package com.cabovianco.productapi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class Category {

    @Null
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

}
