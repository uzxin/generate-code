package com.example.generatecode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.example.**.dao"})
public class GenerateCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateCodeApplication.class, args);
    }

}
