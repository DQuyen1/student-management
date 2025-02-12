package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.dto.EnrollmentDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

  List<EnrollmentDTO> getAllEnrollment();

  EnrollmentDTO getEnrollment(int enrollId);

  EnrollmentDTO createEnrollment(Enrollment newEnrollment);

  EnrollmentDTO updateEnrollment(int enrollId, EnrollmentDTO enrollmentDTO);

  boolean deleteEnrollment(int enrollId);
}
