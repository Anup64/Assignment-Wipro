package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private CartValidator cartValidator;

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        // Simulate items
        Order order = new Order();
        order.setOrderId(cartId);
        order.setItemIds(Arrays.asList("ITEM001", "ITEM002", "ITEMOUT"));

        for (String itemId : order.getItemIds()) {
            if (!inventoryService.isAvailable(itemId)) {
                return "Item out of stock";
            }
        }

        return "Checkout successful for " + cartId;
    }
}
