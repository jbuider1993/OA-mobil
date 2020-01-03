package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@SpringBootApplication
@EnableAdminServer
public class AppMonitorApplication {
	public static void main(String[] args) {
        SpringApplication.run(AppMonitorApplication.class, args);
    }
}
