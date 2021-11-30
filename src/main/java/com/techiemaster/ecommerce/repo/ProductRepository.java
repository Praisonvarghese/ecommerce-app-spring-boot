package com.techiemaster.ecommerce.repo;

import com.techiemaster.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Supplier;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


    @Query("SELECT u FROM Product u WHERE u.category = ?1")
    List<Product> findByCategory(String category);
}
