package com.vladproduction.springboottransactionsecommerce.service.impl;

import com.vladproduction.springboottransactionsecommerce.dto.OrderRequest;
import com.vladproduction.springboottransactionsecommerce.dto.OrderResponse;
import com.vladproduction.springboottransactionsecommerce.entity.Order;
import com.vladproduction.springboottransactionsecommerce.entity.Payment;
import com.vladproduction.springboottransactionsecommerce.exception.PaymentException;
import com.vladproduction.springboottransactionsecommerce.repository.OrderRepository;
import com.vladproduction.springboottransactionsecommerce.repository.PaymentRepository;
import com.vladproduction.springboottransactionsecommerce.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTakingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type is not supported");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTakingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setStatus("SUCCESS");

        return orderResponse;
    }
}
