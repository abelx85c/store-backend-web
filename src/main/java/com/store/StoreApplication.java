package com.store;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.store.controller"})
@MapperScan(basePackages= {"com.store.mapper"})
@ComponentScan("com.store.service")
//@ComponentScan("com.store.repository")
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
