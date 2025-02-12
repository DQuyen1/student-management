package com.se.dto;

import java.util.Date;

public class GradeDTO {

  public int point;
  public Date create_at;


  public GradeDTO() {
  }

  public GradeDTO(int point, Date create_at) {
    this.point = point;
    this.create_at = create_at;

  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public Date getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Date create_at) {
    this.create_at = create_at;
  }


}
