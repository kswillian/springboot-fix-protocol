package com.kaminski.fix.protocol.consumer.configuration;

import com.kaminski.fix.protocol.consumer.handler.FixMessageHandler;
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
        return new SessionSettings("fixsession_acceptor.conf");
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
    public SocketAcceptor socketInitiator() throws ConfigError {
        return new SocketAcceptor(messageHandler, messageStoreFactory(), sessionSettings(), logFactory(), messageFactory());
    }

}