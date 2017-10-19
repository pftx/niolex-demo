package org.apache.niolex.spring.cloud.eureka_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class AppFeign {

    public static void main(String[] args) {
        SpringApplication.run(AppFeign.class, args);
        System.out.println("Hello World!");
    }

}
