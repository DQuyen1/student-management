package com.se.service;

import com.se.dto.ExamDTO;
import com.se.dto.SubjectDTO;
import com.se.dto.TimetableDTO;
import com.se.entity.Timetable;

import java.util.List;

public interface TimetableService {

  List<TimetableDTO> getAllTimetable();

  TimetableDTO getTimetable(int timetableId);

  TimetableDTO createTimetable(Timetable newTimetable);

  TimetableDTO updateTimetable(int timetableId, TimetableDTO timetableDTO);


  boolean deleteTimetable(int timetableId);

}
