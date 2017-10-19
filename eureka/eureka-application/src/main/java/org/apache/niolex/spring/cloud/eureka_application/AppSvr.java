package org.apache.niolex.spring.cloud.eureka_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication
public class AppSvr {

    public static void main(String[] args) {
        SpringApplication.run(AppSvr.class, args);
        System.out.println("Application Server Started!");
    }

}
