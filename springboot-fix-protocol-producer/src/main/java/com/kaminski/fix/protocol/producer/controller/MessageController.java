package com.kaminski.fix.protocol.producer.controller;

import com.kaminski.fix.protocol.producer.service.FixMessageService;
import com.kaminski.fix.protocol.producer.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final FixMessageService messageSender;

    @PostMapping("/order")
    public void sendOrder(@RequestBody Order order){
        messageSender.sendOrder(order);
    }

}