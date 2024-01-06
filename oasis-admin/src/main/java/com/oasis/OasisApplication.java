package com.oasis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.oasis.**.mapper")
@SpringBootApplication
public class OasisApplication {
    public static void main(String[] args) {
        SpringApplication.run(OasisApplication.class, args);
    }
}
