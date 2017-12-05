package org.apache.niolex.spring.cloud.rest_hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class HateoasServer {

    public static void main(String[] args) {
        SpringApplication.run(HateoasServer.class, args);
        System.out.println("Hello World!");
    }

}
