package com.ecommerce.service;

import org.springframework.stereotype.Component;

@Component
public class CartValidatorImpl implements CartValidator {

    @Override
    public boolean validateCart(String cartId) {
        // Simulate: all cart IDs starting with "CART" are valid
        return cartId != null && cartId.startsWith("CART");
    }
}
