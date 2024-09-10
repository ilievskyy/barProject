package com.example.barshop.service;

import com.example.barshop.model.Category;
import com.example.barshop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Category category);
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product updateProduct(Long productId, Product product);
}
