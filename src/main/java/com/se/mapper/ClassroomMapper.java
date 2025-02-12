package com.se.mapper;

import com.se.dto.ClassroomDTO;
import com.se.entity.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomMapper {

  public ClassroomDTO converToDTO(Classroom newClassroom) {

    if(newClassroom == null) {
      return null;
    } else {
      return new ClassroomDTO(newClassroom.getRoom_number(), newClassroom.getCapacity(), newClassroom.isAvailable());

    }


  }



}


