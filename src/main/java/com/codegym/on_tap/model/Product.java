package com.codegym.on_tap.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;
    private double price;
    @ManyToOne
    private Category category;
}
