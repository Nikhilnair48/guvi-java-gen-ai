package com.guvi.spring_boot_intro;

import java.time.LocalDate;
import java.util.UUID;

import com.guvi.spring_boot_intro.service.AttendanceService;
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
//        Runnable runnable = () -> {
//            // behavior
//        };
//        CommandLineRunner clR = (args) -> {
//
//        };
	}

    /**
     * CommandLineRunner - a Spring Boot hook that lets
     * your run some code after the application starts
     * @Bean -> registering a CommandLineRunner object
     */
    @Bean
    CommandLineRunner runOnStartup(StudentService studentService, AttendanceService attendanceService) {
        return args -> {
            UUID id = studentService.registerStudent("Ashik", "ashik@gmail.com");
            attendanceService.markPresent(id, LocalDate.now());

            System.out.println(studentService.listStudents());
        };
    }
}
// Controller -> receive HTTP requests
// Migration & Execution of our registration & markPresent

// method: connect to MySQL DB
    // do you want to put the username and password in your code?
// http://localhost:9090 -> in the browser -> server -> get some response