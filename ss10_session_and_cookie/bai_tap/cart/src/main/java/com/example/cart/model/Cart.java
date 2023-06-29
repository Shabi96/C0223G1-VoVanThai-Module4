package com.example.cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    private boolean checkItemInCart(Product product) {
        for (Product p : productMap.keySet()) {
            if (p.getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            productMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            productMap.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void quantityPlus(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        Integer newQuantity = itemEntry.getValue() + 1;
        productMap.replace(itemEntry.getKey(),newQuantity);
    }

    public void quantityMinus(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry.getValue() == 1) {
            productMap.remove(itemEntry.getKey());
        }
        Integer newQuantity = itemEntry.getValue() - 1;
        productMap.replace(itemEntry.getKey(),newQuantity);
    }

    public void deleteProduct(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        productMap.remove(itemEntry.getKey());
    }

    public Float getPriceProductInCart(Product product) {
        float price;
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        price = (float)itemEntry.getValue() * itemEntry.getKey().getPrice().floatValue();
        return price;
    }

    public void payment() {
        productMap.clear();
    }
}
