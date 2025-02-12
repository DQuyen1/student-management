package com.se.dto;

public class OrganizationDTO {

  public String address;
  public String name;


  public OrganizationDTO() {
  }


  public OrganizationDTO(String address, String name) {
    this.address = address;
    this.name = name;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
