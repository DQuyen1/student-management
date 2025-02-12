package com.se.mapper;

import com.se.dto.EnrollmentDTO;
import com.se.entity.Enrollment;
import org.springframework.stereotype.Component;


@Component
public class EnrollmentMapper {

    public EnrollmentDTO convertToDTO (Enrollment newEnrollment) {
        if(newEnrollment == null) {
          return  null;
        } else {
          return new EnrollmentDTO(newEnrollment.getStudent_id(), newEnrollment.getEnroll_at());
        }
    }

}
