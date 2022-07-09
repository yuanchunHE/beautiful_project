package com.cqut.beautiful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqut.beautiful.dao")
public class BeautifulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeautifulApplication.class, args);
    }

}
