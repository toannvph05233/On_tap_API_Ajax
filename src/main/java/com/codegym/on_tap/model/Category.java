package com.codegym.on_tap.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Category {
    @Id
    private Long id;
    private String name;
}
