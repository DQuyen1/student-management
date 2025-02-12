package com.se.controller;

import com.se.dto.ExamDTO;
import com.se.dto.GradeDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Grade;
import com.se.entity.ResponseMessage;
import com.se.service.GradeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/grades")
public class GradeController {


  GradeServiceImpl service;

  public GradeController(GradeServiceImpl service) {
    this.service = service;
  }


  @GetMapping
  public ResponseEntity<ResponseMessage> getAllGrade() {
    List<GradeDTO> gradesDTO = service.getAllGrade();
    return new ResponseEntity<>(new ResponseMessage("get all grades successfully", gradesDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getGrade(@PathVariable int gradeId) {
    GradeDTO gradeDTO = service.getGrade(gradeId);
    return new ResponseEntity<>(new ResponseMessage("get grade successfully", gradeDTO, new Date()), HttpStatus.OK);
  }


  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteExam(@PathVariable int gradeId) {
    boolean isGradeExist = service.deleteGrade(gradeId);
    if(isGradeExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete grade successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("grade with ID: " + gradeId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping
  public ResponseEntity<ResponseMessage> createGrade(Grade newGrade) {

    GradeDTO gradeDTO = service.createGrade(newGrade);

    return new ResponseEntity<>(new ResponseMessage("create grade successfully", gradeDTO, new Date()), HttpStatus.CREATED);
  }


  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateGrade(@Valid @RequestBody GradeDTO gradeDTO, @PathVariable int id) {

    GradeDTO updateGrade = service.updateGrade(id, gradeDTO);

    return new ResponseEntity<>(new ResponseMessage("Update grade successfully", updateGrade, new Date()), HttpStatus.ACCEPTED);
  }

}
