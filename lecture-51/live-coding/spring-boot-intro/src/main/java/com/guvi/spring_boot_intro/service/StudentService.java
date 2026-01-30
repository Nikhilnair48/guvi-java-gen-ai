package com.guvi.spring_boot_intro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// import com.guvi.spring_boot_intro.exception.DuplicateEmailException;
// import com.guvi.spring_boot_intro.exception.StudentNotFoundException;
import com.guvi.spring_boot_intro.dto.StudentPageResponse;
import com.guvi.spring_boot_intro.exception.DuplicateEmailException;
import com.guvi.spring_boot_intro.exception.StudentNotFoundException;
import com.guvi.spring_boot_intro.model.Student;
import com.guvi.spring_boot_intro.notify.Notifier;
import com.guvi.spring_boot_intro.repo.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // 1) Notice: we are NOT doing `new InMemoryStudentRepository()` inside the service.
    // 2) This is constructor injection.
    private final StudentRepository repo;
    private final Notifier notifier;

    public StudentService(StudentRepository repo, Notifier notifier) {
        this.repo = repo;
        this.notifier = notifier;
    }

    // write some code to validate the bean registration

    public Student createStudent(String name, String email) {
        repo.findByEmailIgnoreCase(email)
            .ifPresent(existing -> {
                throw new DuplicateEmailException(email);
            });

        Student student = new Student(null, name, email, true);
        repo.save(student);

        notifier.send(email, "Welcome " + name + "! Your id is " + student.getId());

        return student;
    }

//    public Student getStudentById(UUID id) {
//        return
//            repo.findById(id)   // findById returns Optional<Student>
//                .orElseThrow(() -> new StudentNotFoundException(id));
//    }
//
//    // new method to update a student
//    // student a = s@example.com
//    // student b = t@example.com -> update email to s@example.com
//    public Student updateStudent(UUID id, String email, String name) {
//        // Find the existing student
//        Optional<Student> existing = Optional.ofNullable(repo.findById(id))
//            .orElseThrow(() -> new StudentNotFoundException(id));
//
//        // Email uniqueness check -- if we update the email, will it remain unique?
//        Student student = existing.get();
//        // String newEmail = student.getEmail();
//        Optional<Student> potentialDuplicate = repo.findByEmail(email);
//        // if potentialDuplicate is not nullable, we need to throw an exception
//        // why? because we would break the constraint: Email uniqueness check
//
//        // Update existing student
//        student.setEmail(email);
//        student.setName(name);
//
//        // Save updated student
//        repo.save(student);
//
//        return student;
//    }
//
//    public void deleteStudent(UUID id) {
////        if(id == null) {
////            throw new Exception("asd");
////        }
//        // find the student from the store by id
//        // if the ID doesn't exist, we can throw an exception
//        //            () -> {
//        //                throw new StudentNotFoundException(id);
//        //            }
//        Optional<Student> student = Optional.ofNullable(repo.findById(id)).orElseThrow(
//            () -> new StudentNotFoundException(id)
//        );
//
//        // store: deleteById
//        repo.deleteById(student.get().getId());
//    }
//
//    public StudentPageResponse searchStudents(String name, String email, Boolean active,
//                                        String sortBy, String sortDir,
//                                        Integer page, Integer size) {
//        // validation
//        // page == null
//        int pageNumber = page == null ? 0 : page;
//        int pageSize = size == null ? 5 : size;
//
//        String effectiveSortBy = normalize(sortBy);
//        if(effectiveSortBy == null || effectiveSortBy.isBlank()) {
//            effectiveSortBy = "name";
//        }
//
//        String effectiveSortDir = normalize(sortDir);
//        if(effectiveSortDir == null || effectiveSortDir.isBlank()) {
//            // asc or desc
//            effectiveSortDir = "asc";
//        }
//
//        // 1) Get all students
//        List<Student> all = repo.findAll();
//
//        // 2) Apply filters
//        List<Student> filtered = new ArrayList<>();
//        for(Student student: all) {
//            // student.getName() has name filter (also a query parameter)
//            // name="ma" -> 8 -> "Shalini" & "Malini" ->
//            // email=""
//            //
//            if(!matchesContains(name, student.getName())) {
//                continue;
//            }
//            if(!matchesContains(email, student.getEmail())) {
//                continue;
//            }
//            if(active != null && student.isActive() != active) {
//                continue;
//            }
//            filtered.add(student);
//        }
//
//        // 3) Sort
//        Comparator<Student> comparator = buildSortComparator(effectiveSortBy, effectiveSortDir);
//        Collections.sort(filtered, comparator);
//
//        // 4) Paginate
//
//        // return the page
//        // items, page, size of the page, total # of students
//        // list of 5 students, 0, 5, 8
//        return new StudentPageResponse(filtered, pageNumber, pageSize, filtered.size());
//
//    }
//
//    /**
//     * Build a comparator based on allowed sort fields (name) + direction (asc/desc)
//     * If the client sends unsupported values, we can throw an exception
//     * @param effectiveSortBy
//     * @param effectiveSortDir
//     * @return
//     */
//    private Comparator<Student> buildSortComparator(String effectiveSortBy, String effectiveSortDir) {
//        // effectiveSortBy -> support name and email, else throw an Exception
//        if(!effectiveSortBy.equals("name") && !effectiveSortBy.equals("email")) {
//            throw new IllegalArgumentException("Invalid sortBy. Allowed: name, email");
//        }
//        // effectiveSortDir -> support asc and desc, else throw an Exception
//        // effectiveSortDir="random" -> "random" does not equal "asc" AND "random" does not equal "desc"
//        // effectiveSortDir="asc" -> "asc" does not equal "asc" OR "asc" does not equal "desc"
//        if(!effectiveSortDir.equals("asc") && !effectiveSortDir.equals("desc")) {
//            throw new IllegalArgumentException("Invalid sortDir. Allowed: asc, desc");
//        }
//
//        // implements Comparable in your Student class -> override compareTo
//        // new Comparator<Student>() { override compare }
//        Comparator<Student> comparator= new Comparator<Student>() {
//
//            @Override
//            public int compare(Student a, Student b) {
//                // sort: on one of name OR email
//                // Malini -> m@example.com, Yirou -> y@example.com
//                String studentASortValue = effectiveSortBy.equals("name") ? a.getName() : a.getEmail();
//                String studentBSortValue = effectiveSortBy.equals("name") ? b.getName() : b.getEmail();
//                /**
//                 *  // asc: A-Z, desc: Z-A
//                 *  // 2, 3, 4 ->
//                 *  // asc
//                 *  // 3, 2 -> 3 > 2 -> 3 - 2 -> 1
//                 *  // 4, 2 -> 4 > 2 -> 4 - 2 -> 2
//                 *
//                 *  // 4,3,2
//                 *  // desc
//                 *  // 4,2 -> 2 -> -2
//                 *  // 3,4 -> 3 - 4 -> -1 -> 1
//                 *
//                 *  // a, b -> negative (a < b), zero (a == b), positive (a > b)
//                 *  // By default: we sort in asc order
//                 */
//                int result = studentASortValue.compareToIgnoreCase(studentBSortValue);
//                // 5 -> -5
//                if(effectiveSortDir.equals("desc")) {
//                    result = -result;
//                }
//
//                return result;
//            }
//        };
//
//        return comparator;
//    }
//
//    // Input: "     " -> Output: ""
//    private String normalize(String value) {
//        if (value == null) return null;
//        // "sortBy=name"
//        return value.trim().toLowerCase();
//    }
//
//    /**
//     * Return true if:
//     *  - the filter is empty or blank (means: do not filter)
//     *  - the field (name, email) contains the filter value (normalized check)
//     *  filterValue is the filter passed via query params. Ex: "ma"
//     *  modelValue is the name/email of the student. Ex: "Malini"
//     */
//    private boolean matchesContains(String filterValue, String modelValue) {
//        String filter = normalize(filterValue);
//        if(filter == null || filter.isBlank()) {
//            return true;
//        }
//        // filterValue = "riya", modelValue = "riya"
//        String model = normalize(modelValue);
//        if(model != null && model.contains(filter)) {
//            return true;
//        }
//        return false;
//    }

}
