package com.example.shoppinglistexam.model.view;

import java.math.BigDecimal;

public class ProductViewModel {

    private String name;
    private BigDecimal price;
    private Long id;

    public ProductViewModel() {
    }

    public String getName() {
        return name;
    }

    public ProductViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}
