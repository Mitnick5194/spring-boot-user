package com.ajie.user.configuration;

import com.ajie.chilli.server.Server;
import com.ajie.chilli.server.simple.SimpleServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Server getSimpleServer(){
        return new SimpleServer();
    }
}
