package com.techiemaster.ecommerce.dto;

import com.techiemaster.ecommerce.model.CartProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String order_id;
    private boolean success;
    private String message;
    private List<CartProducts> products;
}
