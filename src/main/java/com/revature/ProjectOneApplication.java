package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // Enable the use of the @Aspect annotation
public class ProjectOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectOneApplication.class, args);
    }

}
