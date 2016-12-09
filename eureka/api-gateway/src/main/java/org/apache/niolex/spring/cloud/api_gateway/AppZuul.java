package org.apache.niolex.spring.cloud.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@EnableZuulProxy
@SpringCloudApplication
public class AppZuul {

    public static void main(String[] args) {
        SpringApplication.run(AppZuul.class, args);
        System.out.println("Hello World!");
    }

}
