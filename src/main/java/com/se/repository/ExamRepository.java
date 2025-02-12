package com.se.repository;

import com.se.entity.Classroom;
import com.se.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
