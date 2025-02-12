package com.se.dto;

import java.util.Date;

public class ExamDTO {

  public Date date;
  public boolean status;

  public ExamDTO() {
  }


  public ExamDTO(Date date, boolean status) {
    this.date = date;
    this.status = status;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
