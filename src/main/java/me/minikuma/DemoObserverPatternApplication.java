package me.minikuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoObserverPatternApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoObserverPatternApplication.class, args);
        SpringApplication app = new SpringApplication(DemoObserverPatternApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
