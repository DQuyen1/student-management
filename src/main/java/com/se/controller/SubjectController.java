package com.se.controller;


import com.se.dto.SubjectDTO;
import com.se.dto.UserDTO;
import com.se.entity.ResponseMessage;
import com.se.entity.Subject;
import com.se.service.SubjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/subjects")
public class SubjectController {

    SubjectServiceImpl subjectService;

    public SubjectController(SubjectServiceImpl subjectService) {
      this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<ResponseMessage> getAllSubject() {
      List<SubjectDTO> subjectsDTO = subjectService.getAllSubject();
      return new ResponseEntity<>(new ResponseMessage("get all subjects successfully", subjectsDTO, new Date()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseMessage> getSubject(@PathVariable int subjectId) {
        SubjectDTO subjectDTO = subjectService.getSubject(subjectId);
        return new ResponseEntity<>(new ResponseMessage("get subject successfully", subjectDTO, new Date()), HttpStatus.OK);
    }


  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseMessage> deleteSubject(@PathVariable int subjectId) {
    boolean isSubjectExist = subjectService.deleteSubject(subjectId);

    if(isSubjectExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete subject successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("Subject with ID: " + subjectId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }

    @PostMapping
    public ResponseEntity<ResponseMessage> createSubject(@Valid @RequestBody Subject newSubject) {
      SubjectDTO createdSubject = subjectService.createSubject(newSubject);
      return new ResponseEntity<>(new ResponseMessage("New subject creared successfully", createdSubject, new Date()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateSubject(@Valid @RequestBody SubjectDTO subjectDTO, @PathVariable int id) {

      SubjectDTO updateSubject = subjectService.updateSubject(id, subjectDTO);

      return new ResponseEntity<>(new ResponseMessage("Update subject successfully", updateSubject, new Date()), HttpStatus.ACCEPTED);
    }




}
