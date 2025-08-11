package com.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public boolean isAvailable(String itemId) {
        // Simulate: all items except "ITEMOUT" are available
        return !"ITEMOUT".equals(itemId);
    }
}
