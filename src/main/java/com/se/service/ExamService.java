package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.dto.CourseDTO;
import com.se.dto.ExamDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Classroom;
import com.se.entity.Course;
import com.se.entity.Exam;

import java.util.List;

public interface ExamService {


  List<ExamDTO> getAllExam();

  ExamDTO getExam(int examId);

  ExamDTO createExam(Exam newExam);

  ExamDTO updateExam(int examId, ExamDTO examDTO);

  boolean deleteExam(int examId);

}
