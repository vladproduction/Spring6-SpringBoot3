package com.vladproduction.springboottransactionsecommerce.repository;

import com.vladproduction.springboottransactionsecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
