package com.se.service;

import com.se.dto.SubjectDTO;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.SubjectMapper;
import com.se.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService{

  final private SubjectRepository repo;
  final private SubjectMapper mapper;

  public SubjectServiceImpl(SubjectRepository repo, SubjectMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @Override
  public List<SubjectDTO> getAllSubject() {
    List<Subject> subjects = repo.findAll();
    return  subjects.stream().map(mapper::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public SubjectDTO getSubject(int subjectId) {
    Subject subject = repo.findById(subjectId).orElseThrow(() -> {
      return new ResourceNotFoundException("This subject is not exist");
    });
    return mapper.convertToDTO(subject);
  }


  @Override
  public SubjectDTO createSubject(Subject newSubject) {
    Subject subject = repo.save(newSubject);
    return mapper.convertToDTO(subject);
  }



  @Override
  public SubjectDTO updateSubject(int subjectId, SubjectDTO subjectDTO) {
    Subject subject = repo.findById(subjectId).orElseThrow(() -> {
      return new ResourceNotFoundException("this subject is not exist");
    });

    subject.setSubject_name(subjectDTO.getName());
    subject.setDescription(subjectDTO.getDescription());

    Subject updatedSubject = repo.save(subject);

    return mapper.convertToDTO(updatedSubject);
  }

  @Override
  public boolean deleteSubject(int subjectId) {
    if(repo.existsById(subjectId)) {
      repo.deleteById(subjectId);
      return true;
    } else {
      return false;
    }
  }
}
