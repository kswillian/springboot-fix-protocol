package com.kaminski.fix.protocol.producer.service;


import com.kaminski.fix.protocol.producer.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import quickfix.Session;
import quickfix.SessionNotFound;
import quickfix.SocketInitiator;
import quickfix.field.MsgType;
import quickfix.field.OrderQty;
import quickfix.field.Price;
import quickfix.field.Symbol;
import quickfix.fix40.NewOrderSingle;

@Slf4j
@Service
@RequiredArgsConstructor
public class FixMessageService {

    private final SocketInitiator initiator;

    public void sendOrder(Order order){

        try {

            log.info("Send new message.");

            var message = new NewOrderSingle();

            message.getHeader().setString(MsgType.FIELD, "D");
            message.setString(Symbol.FIELD, order.getSymbol());
            message.setInt(OrderQty.FIELD, order.getQuantity());
            message.setDouble(Price.FIELD, order.getPrice());

            var sessionId = initiator.getSessions().get(0);
            Session.sendToTarget(message, sessionId);

        } catch (SessionNotFound e) {
            throw new RuntimeException(e);
        }

    }
}
