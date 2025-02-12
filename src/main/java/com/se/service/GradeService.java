package com.se.service;

import com.se.dto.ExamDTO;
import com.se.dto.GradeDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Grade;

import java.util.List;

public interface GradeService {

  List<GradeDTO> getAllGrade();

  GradeDTO getGrade(int gradeId);

  GradeDTO createGrade(Grade newGrade);

  GradeDTO updateGrade(int gradeId, GradeDTO gradeDTO);

  boolean deleteGrade(int gradeId);

}
