package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "enrollments")
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "enrollment_id")
  int id;

  @Column(name = "student_id")
  int student_id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  Course course;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  User user;

  @Column(name = "enroll_at")
  Date enroll_at;


  public Enrollment() {
  }



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
