package com.codegym.on_tap.service;

import com.codegym.on_tap.model.query.Demo;
import com.codegym.on_tap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Demo> getDemo();
    void save(Product product);
    Product findById(Long id);
    void delete(Long id);
    Long countProduct();
}
