package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "timetables")
public class Timetable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "timetable_id")
  int id;

  @Column(name = "date")
  Date date;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  Course course;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  User user;

  @Column(name = "status")
  boolean status;

  @Column(name = "create_at")
  Date create_at;

  public Timetable() {
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
