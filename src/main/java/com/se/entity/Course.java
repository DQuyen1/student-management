package com.se.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "course_id")
  int id;

  @Column(name = "start_date")
  Date start_date;

  @Column(name = "end_date")
  Date end_date;

  @Column(name = "lecturer_id")
  int lecturer_id;

  @Column(name = "create_at")
  Date create_at;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
  Subject subject;


  @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
  Grade grade;

  @OneToOne(mappedBy = "course")
  Timetable timetable;

  @OneToOne(mappedBy = "course")
  Enrollment enrollment;

  @OneToOne(mappedBy = "course")
  Exam exam;

  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;


  public Course() {
  }



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }

  public int getLecturer_id() {
    return lecturer_id;
  }

  public void setLecturer_id(int lecturer_id) {
    this.lecturer_id = lecturer_id;
  }


  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Date getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Date create_at) {
    this.create_at = create_at;
  }
}
