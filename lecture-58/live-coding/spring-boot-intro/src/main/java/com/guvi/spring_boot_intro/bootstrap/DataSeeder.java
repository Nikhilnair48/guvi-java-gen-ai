package com.guvi.spring_boot_intro.bootstrap;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.model.Course;
import com.guvi.spring_boot_intro.model.Enrollment;
import com.guvi.spring_boot_intro.model.User;

import com.guvi.spring_boot_intro.repo.StudentRepository;
import com.guvi.spring_boot_intro.repo.CourseRepository;
import com.guvi.spring_boot_intro.repo.EnrollmentRepository;
import com.guvi.spring_boot_intro.repo.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollmentRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(
        StudentRepository studentRepo,
        CourseRepository courseRepo,
        EnrollmentRepository enrollmentRepo,
        UserRepository userRepo,
        PasswordEncoder passwordEncoder
    ) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.enrollmentRepo = enrollmentRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        // Prevent duplicate seeding
        if (studentRepo.count() > 0 || userRepo.count() > 0) {
            System.out.println("Data already exists. Skipping seeding.");
            return;
        }

        System.out.println("Seeding database...");

        seedStudents();
        seedUsers();
        List<Course> courses = seedCourses();
        seedEnrollments(courses);

        System.out.println("Seeding completed.");
    }

    // --------------------------------------------------
    // STUDENTS
    // --------------------------------------------------
    private void seedStudents() {

        List<Student> students = List.of(
            new Student(null, "Malini", "ma@example.com", true),
            new Student(null, "Ashik", "as@example.com", true),
            new Student(null, "Thirumalini", "t-malini@example.com", false),
            new Student(null, "Shalini", "sh@example.com", true),
            new Student(null, "Thirumani", "th@example.com", true),
            new Student(null, "Yirou", "yi@example.com", false),
            new Student(null, "Armaan", "ar@example.com", true),
            new Student(null, "Ashwin", "ash@example.com", true)
        );

        studentRepo.saveAll(students);
        System.out.println("Students seeded");
    }

    // --------------------------------------------------
    // USERS (AUTH)
    // --------------------------------------------------
    private void seedUsers() {

        User studentUser = new User(
            null,
            "Student A",
            "student@example.com",
            passwordEncoder.encode("password123"),
            List.of("STUDENT"),
            true
        );

        User adminUser = new User(
            null,
            "Student B",
            "admin@example.com",
            passwordEncoder.encode("admin123"),
            List.of("ADMIN"),
            true
        );

        userRepo.saveAll(List.of(studentUser, adminUser));

        System.out.println("Users seeded");
        System.out.println("Student login -> student@example.com / password123");
        System.out.println("Admin login   -> admin@example.com / admin123");
    }

    // --------------------------------------------------
    // COURSES
    // --------------------------------------------------
    private List<Course> seedCourses() {

        List<Course> courses = List.of(
            new Course(null, "SPRING", "Spring Boot Fundamentals", true),
            new Course(null, "MONGO", "MongoDB for Developers", true),
            new Course(null, "SECURITY", "Spring Security Basics", true)
        );

        List<Course> saved = courseRepo.saveAll(courses);
        System.out.println("Courses seeded");

        return saved;
    }

    // --------------------------------------------------
    // ENROLLMENTS
    // --------------------------------------------------
    private void seedEnrollments(List<Course> courses) {

        List<Student> students = studentRepo.findAll();

        Enrollment e1 = new Enrollment(
            null,
            students.get(0).getId(),
            courses.get(0).getId(),
            Instant.now(),
            "ACTIVE"
        );

        Enrollment e2 = new Enrollment(
            null,
            students.get(1).getId(),
            courses.get(1).getId(),
            Instant.now(),
            "ACTIVE"
        );

        Enrollment e3 = new Enrollment(
            null,
            students.get(2).getId(),
            courses.get(2).getId(),
            Instant.now(),
            "ACTIVE"
        );

        enrollmentRepo.saveAll(List.of(e1, e2, e3));
        System.out.println("Enrollments seeded");
    }
}