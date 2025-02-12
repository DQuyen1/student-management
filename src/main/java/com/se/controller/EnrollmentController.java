package com.se.controller;


import com.se.dto.CourseDTO;
import com.se.dto.EnrollmentDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Enrollment;
import com.se.entity.ResponseMessage;
import com.se.service.EnrollmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/enrollments")
public class EnrollmentController {


  EnrollmentServiceImpl service;

  public EnrollmentController(EnrollmentServiceImpl service) {
    this.service = service;
  }


  @GetMapping
  public ResponseEntity<ResponseMessage> getAllEnroll() {
    List<EnrollmentDTO> enrollsDTO = service.getAllEnrollment();
    return new ResponseEntity<>(new ResponseMessage("get all enrolls successfully", enrollsDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getEnroll(@PathVariable int enrollId) {
    EnrollmentDTO enrollmentDTO = service.getEnrollment(enrollId);
    return new ResponseEntity<>(new ResponseMessage("get enroll successfully", enrollmentDTO, new Date()), HttpStatus.OK);
  }


  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteEnroll(@PathVariable int enrollId) {
    boolean isEnrollExist = service.deleteEnrollment(enrollId);
    if(isEnrollExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete enroll successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("Enroll with ID: " + enrollId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping
  public ResponseEntity<ResponseMessage> createEnrollment(Enrollment newEnrollment) {
    EnrollmentDTO enrollmentDTO = service.createEnrollment(newEnrollment);

    return new ResponseEntity<>(new ResponseMessage("create enrollment successfully", enrollmentDTO, new Date()), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateEnrollment(@Valid @RequestBody EnrollmentDTO enrollmentDTO, @PathVariable int id) {

    EnrollmentDTO updateEnrollment = service.updateEnrollment(id, enrollmentDTO);

    return new ResponseEntity<>(new ResponseMessage("Update enrollment successfully", updateEnrollment, new Date()), HttpStatus.ACCEPTED);
  }


}
