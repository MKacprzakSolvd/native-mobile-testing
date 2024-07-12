package com.solvd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;
    private Short rating;
    private String Description;
    private List<String> availableColors;
}
