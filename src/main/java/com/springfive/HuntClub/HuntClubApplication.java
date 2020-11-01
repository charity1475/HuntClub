package com.springfive.HuntClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class HuntClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuntClubApplication.class, args);
	}

}
