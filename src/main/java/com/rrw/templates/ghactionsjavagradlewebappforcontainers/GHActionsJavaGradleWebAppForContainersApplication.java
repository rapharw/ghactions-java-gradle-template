package com.rrw.templates.ghactionsjavagradlewebappforcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GHActionsJavaGradleWebAppForContainersApplication {

	public static void main(String[] args) {
		SpringApplication.run(GHActionsJavaGradleWebAppForContainersApplication.class, args);
	}

}
