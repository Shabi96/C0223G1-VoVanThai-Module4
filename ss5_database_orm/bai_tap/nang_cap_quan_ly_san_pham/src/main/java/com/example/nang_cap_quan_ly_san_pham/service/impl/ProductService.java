package com.example.nang_cap_quan_ly_san_pham.service.impl;

import com.example.nang_cap_quan_ly_san_pham.model.Product;
import com.example.nang_cap_quan_ly_san_pham.repository.IProductRepository;
import com.example.nang_cap_quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.addNewProduct(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public boolean findIdProduct(Integer id) {
        return productRepository.findIdProduct(id);
    }
}
