package ua.lviv.iot.algo.part1.lab1.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.algo.part1.lab1.controller",
        "ua.lviv.iot.algo.part1.lab1.service"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
