package com.lsk.freechat.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class FreechatBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreechatBackendApplication.class, args);
	}

}
