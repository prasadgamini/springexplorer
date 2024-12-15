package edu.srirama.learn.springexplorer.service;

import edu.srirama.learn.springexplorer.entity.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import edu.srirama.learn.springexplorer.repo.StudentRepo;

@Slf4j
@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepo studentRepo;

    public void saveStudent(Student student) {
        studentRepo.save(student);
        log.info("Student save successful");
    }
}
