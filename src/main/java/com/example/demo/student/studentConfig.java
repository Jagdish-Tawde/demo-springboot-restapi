package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args -> {
            Student maria1 = new Student("jad","aj@jj", LocalDate.of(1996, Month.JULY,2));
            Student maria2 = new Student("alex","al@jj", LocalDate.of(2008, Month.JANUARY,23));
            repository.saveAll(List.of(maria1,maria2));
        };

    }
}
