package com.guvi.spring_boot_intro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// import com.guvi.spring_boot_intro.exception.DuplicateEmailException;
// import com.guvi.spring_boot_intro.exception.StudentNotFoundException;
import com.guvi.spring_boot_intro.exception.DuplicateEmailException;
import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.notify.Notifier;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // TODO:
    // 1) Notice: we are NOT doing `new InMemoryStudentRepository()` inside the service.
    // 2) This is constructor injection in plain Java.
    private final StudentRepository repo;
    private final Notifier notifier;

    public StudentService(StudentRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    // write some code to validate the bean registration

    public UUID registerStudent(String name, String email) {
        // TODO:
        // 1) Create UUID
        // 2) Create Student
        // 3) repo.save(student)
        // 4) notifier.send(email, welcomeMessage)
        // 5) return UUID

        // Throw an exception if the email is a duplicate
        repo.findByEmail(email)
            .ifPresent(existing -> { throw new DuplicateEmailException(email); });

        UUID id = UUID.randomUUID();
        Student student = new Student(id, name, email);

        repo.save(student);
        notifier.send(email, "Welcome " + name + "! Your id is " + id);

        return id;
    }

    public Optional<Student> getStudentById(UUID id) {
        return repo.findById(id);
            //.orElseThrow(() -> new Exception("Student not found"));
    }

    public Optional<Student> createStudent(String name, String email) {
        UUID id = registerStudent(name, email);
        // Student was just saved; this should be present unless storage failed.
        return repo.findById(id);
            //.orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<Student> listStudents() {
        // TODO: return repo.findAll()
        return repo.findAll();
    }
}
