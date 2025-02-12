package com.se.dto;

public class ClassroomDTO {

  public String roomNumber;
  public int capacity;
  public boolean available;


  public ClassroomDTO() {
  }

  public ClassroomDTO(String roomNumber, int capacity, boolean available) {
    this.roomNumber = roomNumber;
    this.capacity = capacity;
    this.available = available;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
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
}
