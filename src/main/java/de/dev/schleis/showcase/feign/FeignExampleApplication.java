package de.dev.schleis.showcase.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
public class FeignExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignExampleApplication.class, args);
	}
}
