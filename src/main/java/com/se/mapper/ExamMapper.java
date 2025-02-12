package com.se.mapper;

import com.se.dto.ClassroomDTO;
import com.se.dto.ExamDTO;
import com.se.entity.Classroom;
import com.se.entity.Exam;
import org.springframework.stereotype.Component;


@Component
public class ExamMapper {

  public ExamDTO converToDTO(Exam newExam) {

    if(newExam == null) {
      return null;
    } else {
      return new ExamDTO(newExam.getDate(), newExam.isStatus());

    }

  }

}


