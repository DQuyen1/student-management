package com.se.mapper;

import com.se.dto.GradeDTO;
import com.se.entity.Grade;
import org.springframework.stereotype.Component;


@Component
public class GradeMapper {

  public GradeDTO convertToDTO(Grade newGrade) {

    if(newGrade == null) {
      return null;
    } else {
      return new GradeDTO(newGrade.getPoints(), newGrade.getCreate_at());
    }
  }


}
