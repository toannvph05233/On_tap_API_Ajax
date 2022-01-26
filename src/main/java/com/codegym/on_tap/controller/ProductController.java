package com.codegym.on_tap.controller;

import com.codegym.on_tap.model.query.Demo;
import com.codegym.on_tap.model.Product;
import com.codegym.on_tap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @Value("${uploadPart}")
    String uploadPart;

    @GetMapping
    public ResponseEntity<List<Product>> products() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countProduct() {
        return new ResponseEntity<>(productService.countProduct(), HttpStatus.OK);
    }

    @GetMapping("/demo")
    public ResponseEntity<List<Demo>> demo() {
        return new ResponseEntity<>(productService.getDemo(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product, @RequestParam MultipartFile upImg) {
        String name = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File(uploadPart + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImg("/img/" + name);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
