package com.resource.share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class ShareApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShareApplication.class, args);
	}
}
