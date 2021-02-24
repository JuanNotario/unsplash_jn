package com.webservice_unsplash.webservice_unsplash_jn;

import com.controller.UnsplashController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class WebserviceUnsplashJnApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceUnsplashJnApplication.class, args);
	}

}
