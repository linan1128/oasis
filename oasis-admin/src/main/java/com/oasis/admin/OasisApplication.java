package com.oasis.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OasisApplication {
    public static void main(String[] args) {
        SpringApplication.run(OasisApplication.class, args);
    }
}