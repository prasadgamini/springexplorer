package edu.srirama.learn.springexplorer.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="STUDENT")
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="STUDENT_AGE")
    private int studentAge;
}
