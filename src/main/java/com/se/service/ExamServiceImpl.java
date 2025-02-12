package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.dto.ExamDTO;
import com.se.entity.Classroom;
import com.se.entity.Course;
import com.se.entity.Exam;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.ClassroomMapper;
import com.se.mapper.ExamMapper;
import com.se.repository.ClassroomRepository;
import com.se.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExamServiceImpl implements ExamService{


  ExamRepository repo;
  ExamMapper mapper;


  public ExamServiceImpl(ExamRepository repo, ExamMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }


  @Override
  public List<ExamDTO> getAllExam() {
    List<Exam> exams = repo.findAll();
    return exams.stream().map(mapper::converToDTO).collect(Collectors.toList());
  }

  @Override
  public ExamDTO getExam(int examId) {
    Exam exam = repo.findById(examId).orElseThrow(() -> {
      return new ResourceNotFoundException("The exam in not exist");
    });
    return mapper.converToDTO(exam);
  }

  @Override
  public ExamDTO createExam(Exam newExam) {
    Exam exam = repo.save(newExam);
    return mapper.converToDTO(exam);
  }

  @Override
  public ExamDTO updateExam(int examId, ExamDTO examDTO) {
    Exam exam = repo.findById(examId).orElseThrow(() -> {
      return new ResourceNotFoundException("this exam is not exist");
    });

    exam.setDate(examDTO.getDate());
    exam.setStatus(examDTO.isStatus());

    Exam updatedExam = repo.save(exam);

    return mapper.converToDTO(updatedExam);
  }

  @Override
  public boolean deleteExam(int examId) {
    if(repo.existsById(examId)) {
      repo.deleteById(examId);
      return true;
    } else {
      return false;
    }
  }
}
