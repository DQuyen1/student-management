package com.se.mapper;

import com.se.dto.SubjectDTO;
import com.se.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class SubjectMapper {

  public SubjectDTO convertToDTO(Subject subject) {

    if (subject == null) {
      return null;
    }
    return new SubjectDTO(subject.getSubject_name(), subject.getDescription());
  }

}
