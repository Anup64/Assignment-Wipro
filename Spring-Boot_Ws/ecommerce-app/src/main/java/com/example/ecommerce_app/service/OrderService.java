package com.example.ecommerce_app.service;

import com.example.ecommerce_app.model.Order;
import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    void deleteOrder(Long id);
}
