package com.se.controller;


import com.se.dto.ExamDTO;
import com.se.dto.SubjectDTO;
import com.se.dto.TimetableDTO;
import com.se.entity.ResponseMessage;
import com.se.entity.Timetable;
import com.se.service.TimetableServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/timetables")
public class TimetableController {

  TimetableServiceImpl service;

  public TimetableController(TimetableServiceImpl service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage> getAllTimetable() {
    List<TimetableDTO> timetablesDTO = service.getAllTimetable();
    return new ResponseEntity<>(new ResponseMessage("get all timetables successfully", timetablesDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getTimetable(@PathVariable int timetableId) {
    TimetableDTO timetableDTO = service.getTimetable(timetableId);
    return new ResponseEntity<>(new ResponseMessage("get timetable successfully", timetableDTO, new Date()), HttpStatus.OK);
  }


  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteTimetable(@PathVariable int timetableId) {
    boolean isTimetableExist = service.deleteTimetable(timetableId);
    if(isTimetableExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete timetable successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("timetable with ID: " + timetableId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<ResponseMessage> createTimetable(Timetable newTimetable) {

    TimetableDTO timetableDTO = service.createTimetable(newTimetable);

    return new ResponseEntity<>(new ResponseMessage("create timetable successfully", timetableDTO, new Date()), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateTimetable(@Valid @RequestBody TimetableDTO timetableDTO, @PathVariable int id) {

    TimetableDTO updateTimetable = service.updateTimetable(id, timetableDTO);

    return new ResponseEntity<>(new ResponseMessage("Update timetable successfully", updateTimetable, new Date()), HttpStatus.ACCEPTED);
  }

}
