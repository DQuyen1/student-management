package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "subjects")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "subject_id")
  int id;

  @Column(name = "subject_name")
  String subject_name;

  @Column(name = "description")
  String description;

  @Column(name = "create_at")
  Date create_at;

  @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
  Course course;


  public Subject() {
  }

  public Subject(int id, String subject_name, String description, Date create_at, Course course) {
    this.id = id;
    this.subject_name = subject_name;
    this.description = description;
    this.create_at = create_at;
    this.course = course;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSubject_name() {
    return subject_name;
  }

  public void setSubject_name(String subject_name) {
    this.subject_name = subject_name;
  }

  public Date getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Date create_at) {
    this.create_at = create_at;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
