package com.kaminski.fix.protocol.producer.configuration;

import com.kaminski.fix.protocol.producer.handler.FixMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;

@Configuration
@RequiredArgsConstructor
public class FixConfiguration {

    private final FixMessageHandler messageHandler;

    @Bean
    public SessionSettings sessionSettings() throws ConfigError {
        return new SessionSettings("fixsession_initiator.conf");
    }

    @Bean
    public MessageStoreFactory messageStoreFactory() throws ConfigError {
        return new FileStoreFactory(sessionSettings());
    }

    @Bean
    public LogFactory logFactory() throws ConfigError {
        return new FileLogFactory(sessionSettings());
    }

    @Bean
    public MessageFactory messageFactory() {
        return new DefaultMessageFactory();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public SocketInitiator socketInitiator() throws ConfigError {
        return new SocketInitiator(messageHandler, messageStoreFactory(), sessionSettings(), logFactory(), messageFactory());
    }

}