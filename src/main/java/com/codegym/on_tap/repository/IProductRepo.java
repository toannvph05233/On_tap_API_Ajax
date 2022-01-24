package com.codegym.on_tap.repository;

import com.codegym.on_tap.model.query.Demo;
import com.codegym.on_tap.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product,Long> {

    @Query(nativeQuery = true, value = "select count(id) from product")
    Long countProduct();

    // tên,ảnh,tên loại product
    @Query(nativeQuery = true, value = "select product.name as namep, img, category.name as namec from product join category on product.category_id = category.id")
    List<Demo> getDemo();

}
