package com.solvd.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @EqualsAndHashCode.Include
    private String name;
    private BigDecimal price;
    private Short rating;
    private String Description;
    private List<String> availableColors;
}
