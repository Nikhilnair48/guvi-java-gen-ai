package com.guvi.spring_boot_intro.bootstrap;

import java.util.List;

import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 new Student(null, "malini", "ma@example.com", true);
 new Student(null, "ashik", "as@example.com", true);
 new Student(null, "thirumalini", "t-malini@example.com", false);
 new Student(null, "shalini", "sh@example.com", true);
 new Student(null, "thirumani", "th@example.com", true);
 new Student(null, "yirou", "yi@example.com", false);
 new Student(null, "armaan", "ar@example.com", true);
 new Student(null, "ashwin", "ash@example.com", true);
 */
@Component
public class DataSeeder implements CommandLineRunner {
    private final StudentRepository repo;

    public DataSeeder(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        // insert only if the count (number of documents in the collection) == 0
        if(repo.count() > 0) {
            return;
        }
        // need a list of students to save
        List<Student> students = List.of(
            new Student(null, "malini", "ma@example.com", true),
            new Student(null, "ashik", "as@example.com", true),
            new Student(null, "thirumalini", "t-malini@example.com", false),
            new Student(null, "shalini", "sh@example.com", true),
            new Student(null, "thirumani", "th@example.com", true),
            new Student(null, "yirou", "yi@example.com", false),
            new Student(null, "armaan", "ar@example.com", true),
            new Student(null, "ashwin", "ash@example.com", true)
        );
        System.out.println("Saving students: " + students);


        // creating 3 courses -> save this

        // repo save all the students
        List<Student> insertedStudents = repo.saveAll(students);
        // insertedStudents.get(0).getId()
        // 1-1) randomly pick a student who's index is from 0-size of the list
        // 1-2) filter insertedStudents by that name, then get the Id
        // 2) randomly pick course Ids from courses (0 - size-1)
    }
}
/*
repo.saveAll -> saves the list of students; id = null, means the MongoDB should generate the ObjectIds
DTO - HTTP request/response
*/