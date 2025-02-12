package com.se.mapper;

import com.se.dto.CourseDTO;
import com.se.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {


  public CourseDTO convertToDTO(Course newCourse) {
    if (newCourse == null) {
      return null;
    } else {
      return new CourseDTO(newCourse.getStart_date(), newCourse.getEnd_date());
    }
  }


}
