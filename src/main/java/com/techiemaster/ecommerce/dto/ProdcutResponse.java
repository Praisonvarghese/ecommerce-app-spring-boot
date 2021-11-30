package com.techiemaster.ecommerce.dto;

import com.techiemaster.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdcutResponse {
    private int number;
    private List<Product> product;

}
