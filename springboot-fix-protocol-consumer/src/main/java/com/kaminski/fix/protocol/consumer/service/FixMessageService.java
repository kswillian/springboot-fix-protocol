package com.kaminski.fix.protocol.consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quickfix.Message;

@Slf4j
@Service
@RequiredArgsConstructor
public class FixMessageService {

    public void receiveOrder(Message message){
        log.info("Receive new messagem {}", message.toString());
    }

}