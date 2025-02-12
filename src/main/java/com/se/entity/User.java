package com.se.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "\"users\"")
public class  User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  public int id;

  @Column(name = "username")
  @NotNull(message = "username can not be null")
  @NotBlank(message = "username can not be empty string")
  public String username;

  @Column(name = "password")
  public String password;

  @Column(name = "email")
  public String email;

  @Column(name = "dob")
  public String dob;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  Grade grade;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  Timetable timetable;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  Enrollment enrollment;


  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  List<Course> courses;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  List<Timetable> timetables;




  public User() {

  }



  public int getUser_id() {
    return id;
  }

  public void setUser_id(int user_id) {
    this.id = user_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }
}
