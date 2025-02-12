package com.se.dto;

public class UserDTO{

    public String username;
    public String email;
    public String dob;


  public UserDTO() {
  }

  public UserDTO(String username, String dob, String email) {
    this.username = username;
    this.dob = dob;
    this.email = email;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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
