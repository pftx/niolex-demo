package org.apache.niolex.spring.cloud.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * Hello world! This is the eureka server.
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaServer.class, args);
        System.out.println("EurekaServer started!");
        System.out.println(Resources.toString(EurekaServer.class.getResource("/logo.txt"), Charsets.UTF_8));
    }

}
