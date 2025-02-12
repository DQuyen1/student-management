package com.se.service;

import com.se.dto.GradeDTO;
import com.se.entity.Course;
import com.se.entity.Grade;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.GradeMapper;
import com.se.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements GradeService{

  GradeRepository repo;
  GradeMapper mapper;

  public GradeServiceImpl(GradeRepository repo, GradeMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @Override
  public List<GradeDTO> getAllGrade() {
    List<Grade> grades = repo.findAll();
    return grades.stream().map(mapper::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public GradeDTO getGrade(int gradeId) {
    Grade grade = repo.findById(gradeId).orElseThrow(() -> {
      return new ResourceNotFoundException("The grade in not exist");
    });
    return mapper.convertToDTO(grade);
  }

  @Override
  public GradeDTO createGrade(Grade newGrade) {
    GradeDTO gradeDTO = mapper.convertToDTO(repo.save(newGrade));
    return gradeDTO;
  }

  @Override
  public GradeDTO updateGrade(int gradeId, GradeDTO gradeDTO) {
    Grade grade = repo.findById(gradeId).orElseThrow(() -> {
      return new ResourceNotFoundException("this grade is not exist");
    });

    grade.setPoints(gradeDTO.getPoint());
    grade.setCreate_at(gradeDTO.getCreate_at());

    Grade updatedGrade = repo.save(grade);

    return mapper.convertToDTO(updatedGrade);
  }

  @Override
  public boolean deleteGrade(int gradeId) {
    if(repo.existsById(gradeId)) {
      repo.deleteById(gradeId);
      return true;
    } else {
      return false;
    }
  }
}
