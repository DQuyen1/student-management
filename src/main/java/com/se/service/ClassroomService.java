package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Classroom;

import java.util.List;

public interface ClassroomService {

  List<ClassroomDTO> getAllClassroom();

  ClassroomDTO getClassroom(int classroomId);

  ClassroomDTO createClassroom(Classroom newClassroom);

  boolean deleteClassroom(int classroomId);

  ClassroomDTO updateClassroom(int classroomId, ClassroomDTO classroomDTO);

}
