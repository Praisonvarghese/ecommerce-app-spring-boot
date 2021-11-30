package com.techiemaster.ecommerce.repo;

import com.techiemaster.ecommerce.model.OrderDetails;
import com.techiemaster.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Long> {

    @Query("SELECT u FROM OrderDetails u WHERE u.orderId = ?1")
    List<OrderDetails> findByOrderId(String id);

}
