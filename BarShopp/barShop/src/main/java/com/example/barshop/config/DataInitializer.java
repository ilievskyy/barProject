package com.example.barshop.config;

import com.example.barshop.model.Category;
import com.example.barshop.model.Product;
import com.example.barshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final ProductRepository productRepository;

    @Autowired
    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void initializeData() {
        productRepository.save(new Product("Espresso", Category.COFFEE, "Strong coffee", 2.5));
        productRepository.save(new Product("Latte", Category.COFFEE, "Milk coffee", 3.0));
        productRepository.save(new Product("Coca-Cola", Category.DRINK, "Soft drink", 1.5));
        productRepository.save(new Product("Whiskey", Category.ALCOHOLIC, "Strong alcoholic drink", 5.0));
    }
}