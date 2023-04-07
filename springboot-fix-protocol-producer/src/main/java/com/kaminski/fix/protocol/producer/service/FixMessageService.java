package com.kaminski.fix.protocol.producer.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quickfix.*;
import quickfix.field.MsgType;
import quickfix.field.NoRelatedSym;
import quickfix.field.QuoteReqID;
import quickfix.field.Symbol;

@Slf4j
@Service
@RequiredArgsConstructor
public class FixMessageService {

    private final SocketInitiator initiator;

    public void sendOrder(){

        try {

            log.info("Send new message.");

            var quoteRequest = new Message();
            quoteRequest.getHeader().setString(MsgType.FIELD, MsgType.QUOTE_REQUEST);
            quoteRequest.setString(QuoteReqID.FIELD, "12345");
            quoteRequest.setInt(NoRelatedSym.FIELD, 2);

            Group relatedSymbolGroup = new Group(NoRelatedSym.FIELD, Symbol.FIELD);
            relatedSymbolGroup.setString(Symbol.FIELD, "USD");
            quoteRequest.addGroup(relatedSymbolGroup);

            relatedSymbolGroup.setString(Symbol.FIELD, "MSFT");
            quoteRequest.addGroup(relatedSymbolGroup);

            var sessionId = initiator.getSessions().get(0);
            Session.sendToTarget(quoteRequest, sessionId);

        } catch (SessionNotFound e) {
            throw new RuntimeException(e);
        }

    }
}
