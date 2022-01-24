package com.codegym.on_tap.service;

import com.codegym.on_tap.model.query.Demo;
import com.codegym.on_tap.model.Product;
import com.codegym.on_tap.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public List<Demo> getDemo() {
        return productRepo.getDemo();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Long countProduct() {
        return productRepo.countProduct();
    }
}
