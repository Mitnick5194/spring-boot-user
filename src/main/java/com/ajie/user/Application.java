package com.ajie.user;

import org.spring.framework.UniqueNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sun.applet.Main;

@SpringBootApplication
@ComponentScan(value={"com.ajie.user.*"},nameGenerator = UniqueNameGenerator.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
