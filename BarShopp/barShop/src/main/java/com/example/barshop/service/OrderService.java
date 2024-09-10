package com.example.barshop.service;

import com.example.barshop.model.Order;
import com.example.barshop.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order saveOrder(OrderDto orderDto);
    void deleteOrder(Long id);
}
