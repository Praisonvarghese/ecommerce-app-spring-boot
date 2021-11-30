package com.techiemaster.ecommerce.controller;

import com.techiemaster.ecommerce.dto.OrderRequest;
import com.techiemaster.ecommerce.dto.OrderResponse;
import com.techiemaster.ecommerce.model.CartProducts;
import com.techiemaster.ecommerce.model.OrderDetails;
import com.techiemaster.ecommerce.model.Product;
import com.techiemaster.ecommerce.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/new")
    public OrderResponse createNewOrder(@RequestBody OrderRequest orderRequest) {
        OrderDetails orderDetails = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderResponse orderResponse = new OrderResponse();

        List<CartProducts> cartProducts = orderRequest.getProducts();
        String orderId = String.valueOf(UUID.randomUUID());
        orderResponse.setOrder_id(orderId);
        orderResponse.setMessage("Order Placed Successfully");
        orderResponse.setSuccess(true);
        orderResponse.setProducts(cartProducts);

        for (CartProducts cartProduct : cartProducts) {
            orderDetails = new OrderDetails();
            Product product = ProductController.getProducts().stream()
                    .filter(a -> a.getId() == Integer.parseInt(cartProduct.getId()))
                    .collect(Collectors.toList()).get(0);
            orderDetails.setOrderId(orderId);
            orderDetails.setProductId(product.getId());
            orderDetails.setTittle(product.getName());
            orderDetails.setDescription(product.getDescription());
            orderDetails.setPrice(product.getPrice());
            orderDetails.setQuantityOrdered(Integer.parseInt(cartProduct.getNumInCart()));
            orderDetails.setImage(product.getImage());
            orderDetailsList.add(orderDetails);
        }
        orderRepository.saveAll(orderDetailsList);
        return orderResponse;
    }


    @GetMapping("/{id}")
    public List<OrderDetails> getProduct(@PathVariable("id") String id) {
        return orderRepository.findByOrderId(id);
    }

}
