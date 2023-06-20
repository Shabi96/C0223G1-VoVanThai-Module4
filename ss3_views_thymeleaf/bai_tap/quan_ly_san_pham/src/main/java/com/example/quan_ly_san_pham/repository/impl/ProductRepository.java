package com.example.quan_ly_san_pham.repository.impl;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {

    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "TV", 100, "LG"));
        productList.add(new Product(2, "FRIDGE", 150, "SAMSUNG"));
        productList.add(new Product(3, "WASHING MACHINE", 80, "PANASONIC"));
        productList.add(new Product(4, "AIR CONDITIONING", 150, "CAPER"));
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public void addNewProduct(Product product) {
        product.setId(productList.size() + 1);
        product.setName(product.getName().toUpperCase(Locale.ROOT));
        productList.add(product);
    }

    @Override
    public Product getProductById(Integer id) {
        for (Product p : productList) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product, Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        productList.remove(getProductById(id));
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productListSearch = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(name.toUpperCase(Locale.ROOT))) {
                productListSearch.add(p);
            }
        }
        if (productListSearch.size() == 0) {
            return productList;
        } else {
            return productListSearch;
        }
    }
}
