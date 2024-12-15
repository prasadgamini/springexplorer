package edu.srirama.learn.springexplorer.repo;

import edu.srirama.learn.springexplorer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
