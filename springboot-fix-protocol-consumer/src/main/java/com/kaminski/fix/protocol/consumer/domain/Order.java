package com.kaminski.fix.protocol.consumer.domain;

import lombok.Data;

@Data
public class Order {

    private String orderId;
    private String symbol;
    private int quantity;
    private double price;

}