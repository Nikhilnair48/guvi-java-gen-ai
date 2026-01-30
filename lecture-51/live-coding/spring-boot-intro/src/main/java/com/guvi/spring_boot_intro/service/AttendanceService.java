package com.guvi.spring_boot_intro.service;

import java.time.LocalDate;
import java.util.UUID;

import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.notify.Notifier;
import com.guvi.spring_boot_intro.repo.StudentRepositoryV0;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final StudentRepositoryV0 repo;
    private final Notifier notifier;

    public AttendanceService(StudentRepositoryV0 repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    public void markPresent(UUID studentId, LocalDate date) {
        // 1) Find student via repo.findById(studentId)
        // 2) If not found, throw IllegalArgumentException("Student not found: " + studentId)
        // 3) If found, notifier.send(student.getEmail(), attendanceMessage)

        Student student = repo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + studentId));

        notifier.send(student.getEmail(), "Marked present on " + date);
    }
}
