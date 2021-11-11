package com.ddci;

import com.ddci.repository.ResultDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class DdciApplication {
    public static void main(String[] args) {
        SpringApplication.run(DdciApplication.class, args);

    }

}
