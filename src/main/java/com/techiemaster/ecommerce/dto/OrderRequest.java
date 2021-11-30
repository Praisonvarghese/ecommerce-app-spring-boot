package com.techiemaster.ecommerce.dto;

import com.techiemaster.ecommerce.model.CartProducts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String userid;
    private int total;
    private List<CartProducts> products;
}
