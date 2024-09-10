package com.example.barshop.service.impl;

import com.example.barshop.model.Order;
import com.example.barshop.model.Product;
import com.example.barshop.model.dto.OrderDto;
import com.example.barshop.repository.OrderRepository;
import com.example.barshop.repository.ProductRepository;
import com.example.barshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrder(OrderDto orderDto) {
        // Validate productId
        Long productId = orderDto.getProductId();
        if (productId == null) {
            throw new IllegalArgumentException("Product ID must not be null");
        }

        // Find the product
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found for id: " + productId));


        // Generate a unique three-digit positive order_number
        Long orderNumber = generateUniqueOrderNumber();

        // Create and save the order
        Order order = new Order(
                // Generate a better ID or handle ID generation more robustly
                orderNumber, // Consider using a better ID generation strategy
                LocalDateTime.now(),
                orderDto.getPreferences(),
                product
        );
        return orderRepository.save(order);
    }
    // Method to generate a three-digit positive order number
    private Long generateUniqueOrderNumber() {
        // Example implementation to generate a unique three-digit positive order_number
        // You can replace this with your specific logic or use a sequence generator
        Random random = new Random();
        long orderNumber;
        do {
            orderNumber = random.nextInt(900) + 100; // Generates a number between 100 and 999
        } while (orderRepository.existsByOrderNumber(orderNumber)); // Ensure uniqueness by checking if it already exists in the database

        return orderNumber;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}