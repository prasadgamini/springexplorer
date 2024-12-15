package edu.srirama.learn.springexplorer.controller;

import edu.srirama.learn.springexplorer.entity.Student;
import edu.srirama.learn.springexplorer.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        log.info("Student:{}", student);
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }
}
