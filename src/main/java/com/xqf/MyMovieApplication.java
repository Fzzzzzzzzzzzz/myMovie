package com.xqf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xqf.mapper")
public class MyMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMovieApplication.class, args);
    }

}
