package com.se.dto;

import java.util.Date;

public class EnrollmentDTO {

  public int student_id;

  public Date enroll_at;


  public EnrollmentDTO() {
  }

  public EnrollmentDTO(int student_id, Date enroll_at) {
    this.student_id = student_id;

    this.enroll_at = enroll_at;
  }

  public int getStudent_id() {
    return student_id;
  }

  public void setStudent_id(int student_id) {
    this.student_id = student_id;
  }



  public Date getEnroll_at() {
    return enroll_at;
  }

  public void setEnroll_at(Date enroll_at) {
    this.enroll_at = enroll_at;
  }
}
