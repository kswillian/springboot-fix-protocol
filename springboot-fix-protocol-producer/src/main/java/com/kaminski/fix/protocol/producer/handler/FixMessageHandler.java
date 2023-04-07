package com.kaminski.fix.protocol.producer.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quickfix.*;

@Slf4j
@Component
public class FixMessageHandler implements Application {

    @Override
    public void onCreate(SessionID sessionID) {
        log.info("onCreate {}", sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("onLogon {}", sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.info("onLogout {}", sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        log.info("toAdmin");
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        log.info("fromAdmin {}", message);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        log.info("toApp");
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        log.info("fromApp");
    }

}