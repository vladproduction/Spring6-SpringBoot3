package com.vladproduction.springboottransactionsecommerce.repository;

import com.vladproduction.springboottransactionsecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
