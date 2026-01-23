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
public class InMemoryStudentRepository implements StudentRepository {

    // TODO: In-memory storage for the MVP.
    private final Map<UUID, Student> store = new HashMap<>();

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

}
