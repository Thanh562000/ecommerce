package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.dto.response.CartItemResponse;
import com.ecommer.springbootapi.entities.User;
import com.ecommer.springbootapi.service.CommonService;
import com.ecommer.springbootapi.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cart")
public class ShoppingCartController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("findByCustomer")
    public CartItemResponse findCustomerId(User customer) {
        return shoppingCartService.findByCustomer(customer);
    }



}
