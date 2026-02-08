package com.guvi.spring_boot_intro;

import com.guvi.spring_boot_intro.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// entry point
@SpringBootApplication
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntroApplication.class, args);
	}

//    @Bean
//    CommandLineRunner insertStudent(StudentService studentService) {
//        return (args -> {
//            // created a student
//        });
//    }
}