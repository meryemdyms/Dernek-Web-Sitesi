package org.example.dernekwebsitesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"org.example"})
@EnableJpaRepositories(basePackages = {"org.example"})
@ComponentScan(basePackages = {"org.example"})
@SpringBootApplication
public class DernekWebSitesiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DernekWebSitesiApplication.class, args);
    }

}
