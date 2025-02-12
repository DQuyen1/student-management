package com.se.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "classrooms")
public class Classroom {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "classroom_id")
  int id;

  @Column(name = "room_number")
  String room_number;

  @Column(name = "capacity")
  int capacity;


  @Column(name = "available")
  boolean available;


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "organization_id", referencedColumnName = "organization_id")
  Organization organization;

  @OneToOne(mappedBy = "classroom")
  Exam exam;


  @Column(name = "create_at")
  Date create_at;

  public Classroom() {
  }

  public Classroom(int id, String room_number, int capacity, boolean available, Organization organization_id, Date create_at) {
    this.id = id;
    this.room_number = room_number;
    this.capacity = capacity;
    this.available = available;
    this.organization = organization_id;
    this.create_at = create_at;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRoom_number() {
    return room_number;
  }

  public void setRoom_number(String room_number) {
    this.room_number = room_number;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public Date getCreate_at() {
    return create_at;
  }

  public void setCreate_at(Date create_at) {
    this.create_at = create_at;
  }
}
