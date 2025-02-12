package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "organizations")
public class Organization {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "organization_id")
  int id;

  @Column(name = "address")
  String address;

  @Column(name = "name")
  String name;

  @OneToOne(mappedBy = "organization", cascade = CascadeType.ALL)
  Classroom classroom;

  public Organization() {
  }

  public Organization(int id, String address,String name ,Classroom classroom) {
    this.id = id;
    this.address = address;
    this.name = name;
    this.classroom = classroom;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Classroom getClassroom() {
    return classroom;
  }

  public void setClassroom(Classroom classroom) {
    this.classroom = classroom;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
