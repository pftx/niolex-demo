package org.apache.niolex.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@PropertySource(value = { "classpath:config.properties" })
public class Main {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "prod");
        SpringApplication.run(Main.class, args);
    }

}
