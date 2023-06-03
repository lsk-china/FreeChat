package com.lsk.freechat.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
@MapperScan(basePackages = {"com.lsk.freechat.backend.mapper"})
public class FreechatBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreechatBackendApplication.class, args);
	}

}
