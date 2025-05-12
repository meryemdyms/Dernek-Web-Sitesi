package org.example.dernekwebsitesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"org.example"})
@SpringBootApplication
public class DernekWebSitesiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DernekWebSitesiApplication.class, args);
    }

}
