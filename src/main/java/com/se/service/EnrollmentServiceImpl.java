package com.se.service;

import com.se.dto.EnrollmentDTO;
import com.se.entity.Course;
import com.se.entity.Enrollment;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.EnrollmentMapper;
import com.se.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EnrollmentServiceImpl implements EnrollmentService{


  EnrollmentRepository repo;
  EnrollmentMapper mapper;

  public EnrollmentServiceImpl(EnrollmentRepository repo, EnrollmentMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @Override
  public List<EnrollmentDTO> getAllEnrollment() {
    List<Enrollment> enrollments = repo.findAll();
    return enrollments.stream().map(mapper::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public EnrollmentDTO getEnrollment(int enrollId) {
    Enrollment enrollment = repo.findById(enrollId).orElseThrow(() -> new ResourceNotFoundException("The enrollment in not exist"));
    return mapper.convertToDTO(enrollment);
  }

  @Override
  public EnrollmentDTO createEnrollment(Enrollment newEnrollment) {
    return mapper.convertToDTO(repo.save(newEnrollment));
  }

  @Override
  public EnrollmentDTO updateEnrollment(int enrollId, EnrollmentDTO enrollmentDTO) {
    Enrollment enrollment = repo.findById(enrollId).orElseThrow(() -> {
      return new ResourceNotFoundException("this enrollment is not exist");
    });

    enrollment.setStudent_id(enrollmentDTO.getStudent_id());
    enrollment.setEnroll_at(enrollmentDTO.getEnroll_at());

    Enrollment updatedEnrollment = repo.save(enrollment);

    return mapper.convertToDTO(updatedEnrollment);
  }

  @Override
  public boolean deleteEnrollment(int enrollId) {
    if(repo.existsById(enrollId)) {
      repo.deleteById(enrollId);
      return true;
    } else {
      return false;
    }
  }
}
