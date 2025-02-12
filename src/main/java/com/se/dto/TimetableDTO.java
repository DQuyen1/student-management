package com.se.dto;

import java.util.Date;

public class TimetableDTO {

  public Date date;
  public boolean status;


  public TimetableDTO() {
  }

  public TimetableDTO(Date date, boolean status) {
    this.date = date;
    this.status = status;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
