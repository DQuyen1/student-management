package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.dto.CourseDTO;
import com.se.entity.Classroom;
import com.se.entity.Course;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.CourseMapper;
import com.se.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService{


  CourseRepository repo;
  CourseMapper mapper;



  public CourseServiceImpl(CourseRepository repo, CourseMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @Override
  public List<CourseDTO> getAllCourse() {
    List<Course> courses = repo.findAll();
    return courses.stream().map(mapper::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public CourseDTO getCourse(int courseId) {
    Course course = repo.findById(courseId).orElseThrow(() -> {
      return new ResourceNotFoundException("The course in not exist");
    });
    return mapper.convertToDTO(course);
  }

  @Override
  public CourseDTO createCourse(Course newCourse) {
    return mapper.convertToDTO(repo.save(newCourse));
  }

  @Override
  public CourseDTO updateCourse(int courseId, CourseDTO courseDTO) {
    Course course = repo.findById(courseId).orElseThrow(() -> {
      return new ResourceNotFoundException("this course is not exist");
    });

    course.setStart_date(courseDTO.getStart_date());
    course.setEnd_date(courseDTO.getEnd_date());

    Course updatedCourse = repo.save(course);

    return mapper.convertToDTO(updatedCourse);
  }

  @Override
  public boolean deleteCourse(int courseId) {
    if(repo.existsById(courseId)) {
      repo.deleteById(courseId);
      return true;
    } else {
      return false;
    }
  }
}
