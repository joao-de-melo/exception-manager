package uk.fttek.exception.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class WebStarter {
    public static void main(String[] args) {
        SpringApplication.run(WebStarter.class);
    }
}
