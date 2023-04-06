package com.kaminski.fix.protocol.consumer.handler;

import com.kaminski.fix.protocol.consumer.service.FixMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quickfix.*;

@Slf4j
@Component
@AllArgsConstructor
public class FixMessageHandler implements Application {

    private final FixMessageService messageService;
    @Override
    public void onCreate(SessionID sessionID) {
        log.info("onCreate");
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("onLogon");
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.info("onLogout");
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.info("toAdmin");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        log.info("fromAdmin");
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        log.info("toApp");
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        log.info("fromApp");
        messageService.receiveOrder(message);
    }

}