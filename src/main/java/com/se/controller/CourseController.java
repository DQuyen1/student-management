package com.se.controller;


import com.se.dto.ClassroomDTO;
import com.se.dto.CourseDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Course;
import com.se.entity.ResponseMessage;
import com.se.service.CourseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/courses")
public class CourseController {

  CourseServiceImpl service;

  public CourseController(CourseServiceImpl service) {
    this.service = service;
  }


  @GetMapping
  public ResponseEntity<ResponseMessage> getAllCourse() {
    List<CourseDTO> coursesDTO = service.getAllCourse();
    return new ResponseEntity<>(new ResponseMessage("get all courses successfully", coursesDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getCourse(@PathVariable int courseId) {
    CourseDTO courseDTO = service.getCourse(courseId);
    return new ResponseEntity<>(new ResponseMessage("get course successfully", courseDTO, new Date()), HttpStatus.OK);
  }


  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteCourse(@PathVariable int courseId) {
    boolean isCourseExist = service.deleteCourse(courseId);
    if(isCourseExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete course successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("course with ID: " + courseId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping
  public ResponseEntity<ResponseMessage> createCourse(Course newCourse) {
    CourseDTO courseDTO = service.createCourse(newCourse);
    return new ResponseEntity<>(new ResponseMessage("create course successfully", courseDTO, new Date()), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateCourse(@Valid @RequestBody CourseDTO courseDTO, @PathVariable int id) {

    CourseDTO updatedCourse = service.updateCourse(id, courseDTO);

    return new ResponseEntity<>(new ResponseMessage("Update course successfully", updatedCourse, new Date()), HttpStatus.ACCEPTED);
  }


}
