package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "grades")
public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "grade_id")
  int id;

  @Column(name = "points")
  int points;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  User user;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  Course course;

  @Column(name = "create_at")
  Date create_at;


  public Grade() {}


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }



  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Date getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Date create_at) {
    this.create_at = create_at;
  }
}
