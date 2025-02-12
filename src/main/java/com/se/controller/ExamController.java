package com.se.controller;


import com.se.dto.ClassroomDTO;
import com.se.dto.CourseDTO;
import com.se.dto.ExamDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Classroom;
import com.se.entity.Exam;
import com.se.entity.ResponseMessage;
import com.se.service.ClassroomServiceImpl;
import com.se.service.ExamServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/exams")
public class ExamController {

  ExamServiceImpl service;

    public ExamController(ExamServiceImpl service) {
      this.service = service;
    }


  @GetMapping
  public ResponseEntity<ResponseMessage> getAllExam() {
    List<ExamDTO> examsDTO = service.getAllExam();
    return new ResponseEntity<>(new ResponseMessage("get all exams successfully", examsDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getExam(@PathVariable int examId) {
    ExamDTO examDTO = service.getExam(examId);
    return new ResponseEntity<>(new ResponseMessage("get exam successfully", examDTO, new Date()), HttpStatus.OK);
  }


  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteExam(@PathVariable int examId) {
    boolean isExamExist = service.deleteExam(examId);
    if(isExamExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete exam successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("exam with ID: " + examId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }

    @PostMapping
    public ResponseEntity<ResponseMessage> createExam(Exam newExam) {

        ExamDTO examDTO = service.createExam(newExam);
        return new ResponseEntity<>(new ResponseMessage("Create classroom successfully", examDTO, new Date()), HttpStatus.CREATED);
    }


  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateExam(@Valid @RequestBody ExamDTO examDTO, @PathVariable int id) {

    ExamDTO updateExam = service.updateExam(id, examDTO);

    return new ResponseEntity<>(new ResponseMessage("Update exam successfully", updateExam, new Date()), HttpStatus.ACCEPTED);
  }
}
