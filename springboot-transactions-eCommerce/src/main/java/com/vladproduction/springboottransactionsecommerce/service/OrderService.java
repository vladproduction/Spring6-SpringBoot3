package com.vladproduction.springboottransactionsecommerce.service;

import com.vladproduction.springboottransactionsecommerce.dto.OrderRequest;
import com.vladproduction.springboottransactionsecommerce.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

}
