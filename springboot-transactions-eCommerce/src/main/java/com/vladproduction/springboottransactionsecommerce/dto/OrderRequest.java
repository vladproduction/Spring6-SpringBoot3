package com.vladproduction.springboottransactionsecommerce.dto;

import com.vladproduction.springboottransactionsecommerce.entity.Order;
import com.vladproduction.springboottransactionsecommerce.entity.Payment;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;

}
