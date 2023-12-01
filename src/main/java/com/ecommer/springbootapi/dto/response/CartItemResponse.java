package com.ecommer.springbootapi.dto.response;

import com.ecommer.springbootapi.dto.request.CartItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private List<CartItemDto> content;
    private double totalCost;
}
