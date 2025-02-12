package com.se.controller;


import com.se.dto.ClassroomDTO;
import com.se.entity.Classroom;
import com.se.entity.ResponseMessage;
import com.se.service.ClassroomServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/classrooms")
public class ClassroomController {

  ClassroomServiceImpl service;

    public ClassroomController(ClassroomServiceImpl service) {
      this.service = service;
    }


  @GetMapping
  public ResponseEntity<ResponseMessage> getAllClassroom() {
    List<ClassroomDTO> classroomsDTO = service.getAllClassroom();
    return new ResponseEntity<>(new ResponseMessage("get all classrooms successfully", classroomsDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getClassroom(@PathVariable int classroomId) {
    ClassroomDTO classroomDTO = service.getClassroom(classroomId);
    return new ResponseEntity<>(new ResponseMessage("get classroom successfully", classroomDTO, new Date()), HttpStatus.OK);
  }


  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteClassroom(@PathVariable int classroomId) {
    boolean isClassroomExist = service.deleteClassroom(classroomId);
    if(isClassroomExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete classroomId successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("classroom with ID: " + classroomId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }

    @PostMapping
    public ResponseEntity<ResponseMessage> createClassroom(Classroom newClassroom) {
        ClassroomDTO classroomDTO = service.createClassroom(newClassroom);
        return new ResponseEntity<>(new ResponseMessage("Create classroom successfully", classroomDTO, new Date()), HttpStatus.CREATED);
    }


  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateSubject(@Valid @RequestBody ClassroomDTO classroomDTO, @PathVariable int id) {
    ClassroomDTO updatedClassroom = service.updateClassroom(id, classroomDTO);
    return new ResponseEntity<>(new ResponseMessage("Update subject successfully", updatedClassroom, new Date()), HttpStatus.ACCEPTED);
  }

}
