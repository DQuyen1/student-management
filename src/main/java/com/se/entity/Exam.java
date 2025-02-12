package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "exams")
public class Exam {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "exam_id")
  int id;

  @Column(name = "exam_date")
  Date date;



  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  Course course;

  @OneToOne
  @JoinColumn(name = "classroom_id", referencedColumnName = "classroom_id")
  Classroom classroom;





  @Column(name = "status")
  boolean status;

  @Column(name = "create_at")
  Date create_at;

  public Exam() {
  }

  public Exam(int id, Date date, Course course, Classroom classroom, boolean status, Date create_at) {
    this.id = id;
    this.date = date;
    this.course = course;
    this.classroom = classroom;
    this.status = status;
    this.create_at = create_at;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Date getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Date create_at) {
    this.create_at = create_at;
  }
}
