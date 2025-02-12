package com.se.service;

import com.se.dto.SubjectDTO;
import com.se.entity.Subject;

import java.util.List;

public interface SubjectService {

  List<SubjectDTO> getAllSubject();

  SubjectDTO getSubject(int subjectId);

  SubjectDTO createSubject(Subject newSubject);

  SubjectDTO updateSubject(int subjectId, SubjectDTO subjectDTO);

  boolean deleteSubject(int subjectId);

}
