package com.se.mapper;

import com.se.dto.TimetableDTO;
import com.se.entity.Timetable;
import org.springframework.stereotype.Component;

@Component
public class TimetableMapper {

  public TimetableDTO convertToDTO(Timetable newTimetable) {

    if(newTimetable == null) {
      return null;
    } else {
      return new TimetableDTO(newTimetable.getDate(), newTimetable.isStatus());
    }

  }


}
