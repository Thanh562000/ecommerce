package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.response.CartItemResponse;
import com.ecommer.springbootapi.entities.User;

public interface ShoppingCartService {
    CartItemResponse findByCustomer(User customer);

    CartItemResponse addCartItem(User customer, Long productId, Integer quantity);

    CartItemResponse updateItemQuantity(User customer, Long productId, Integer quantity);

    void deleteItemProduct(User customer, Long productId);
}
