package com.guvi.spring_boot_intro.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.guvi.spring_boot_intro.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStudentRepository implements StudentRepositoryV0 {

    // TODO: In-memory storage for the MVP.
    private final Map<String, Student> store = new HashMap<>();

    public InMemoryStudentRepository() {
        seed();
    }

    private void seed() {
        // adding a number of students to the store
        // new Student(generated a UUID, name, email, active or not)
        Student s1 = new Student(null, "malini", "ma@example.com", true);
        Student s2 = new Student(null, "ashik", "as@example.com", true);
        Student s3 = new Student(null, "thirumalini", "t-malini@example.com", false);
        Student s4 = new Student(null, "shalini", "sh@example.com", true);
        Student s5 = new Student(null, "thirumani", "th@example.com", true);
        Student s6 = new Student(null, "yirou", "yi@example.com", false);
        Student s7 = new Student(null, "armaan", "ar@example.com", true);
        Student s8 = new Student(null, "ashwin", "ash@example.com", true);

        save(s1);
        save(s2);
        save(s3);
        save(s4);
        save(s5);
        save(s6);
        save(s7);
        save(s8);
    }

    //

    @Override
    public void save(Student student) {
        // TODO: store the student
        store.put(student.getId(), student);
    }

    @Override
    public Optional<Student> findById(UUID id) {
        // TODO: return student if present
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Student> findAll() {
        // TODO: return all students
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Student> findByEmail(String email) {
        // Simple linear scan for in-memory storage
        return store.values().stream()
            .filter(s -> s.getEmail().equalsIgnoreCase(email))
            .findFirst();
    }

    @Override
    public void deleteById(UUID id) {
        // remove id from store
        store.remove(id);

    }


}
