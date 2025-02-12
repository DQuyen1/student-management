package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.dto.CourseDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Classroom;
import com.se.entity.Course;

import java.util.List;

public interface CourseService {


  List<CourseDTO> getAllCourse();

  CourseDTO getCourse(int courseId);

  CourseDTO createCourse(Course newCourse);

  CourseDTO updateCourse(int courseId, CourseDTO courseDTO);

  boolean deleteCourse(int courseId);
}
