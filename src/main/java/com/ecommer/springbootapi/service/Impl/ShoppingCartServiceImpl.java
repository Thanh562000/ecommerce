package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.response.CartItemResponse;
import com.ecommer.springbootapi.entities.User;
import com.ecommer.springbootapi.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public CartItemResponse findByCustomer(User customer) {
        return null;
    }

    @Override
    public CartItemResponse addCartItem(User customer, Long productId, Integer quantity) {
        return null;
    }

    @Override
    public CartItemResponse updateItemQuantity(User customer, Long productId, Integer quantity) {
        return null;
    }

    @Override
    public void deleteItemProduct(User customer, Long productId) {

    }
}
