package com.se.dto;

import java.util.Date;

public class SubjectDTO {

    public String name;
    public String description;


  public SubjectDTO() {
  }


  public SubjectDTO(String name, String description) {
    this.name = name;
    this.description = description;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
