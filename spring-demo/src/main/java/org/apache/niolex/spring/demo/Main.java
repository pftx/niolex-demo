package org.apache.niolex.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Hello world!
 *
 */
// We use application.yml, which is loaded by spring boot by default.
// @PropertySource(value = { "classpath:config.properties" })
@SpringBootApplication
public class Main {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * The way to load yaml manually.
     * 
     * @Bean
     *       public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
     *       PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
     *       YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
     *       yaml.setResources(new ClassPathResource("config.yaml"));
     *       configurer.setProperties(yaml.getObject());
     *       return configurer;
     *       }
     */

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(Main.class, args);
    }

}
