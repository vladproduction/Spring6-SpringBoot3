package com.vladproduction.springbootsearchrestapi.service;

import com.vladproduction.springbootsearchrestapi.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProducts(String query);

    Product createProduct(Product product);

}
