package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductList();

    void addNewProduct(Product product);

    Product getProductById(Integer id);

    void updateProduct(Product product, Integer id);

    void deleteProduct(Integer id);

    List<Product> searchByName(String name);
}
