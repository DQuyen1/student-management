package com.se.controller;


import com.se.dto.ExamDTO;
import com.se.dto.OrganizationDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Organization;
import com.se.entity.ResponseMessage;
import com.se.service.OrganizationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/organizations")
public class OrganizationController {

  OrganizationServiceImpl service;

    public OrganizationController(OrganizationServiceImpl service) {
      this.service = service;
    }


  @GetMapping
  public ResponseEntity<ResponseMessage> getAllOrganization() {
    List<OrganizationDTO> organizationsDTO = service.getAllOrganization();
    return new ResponseEntity<>(new ResponseMessage("get all organization successfully", organizationsDTO, new Date()), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> getExam(@PathVariable int organizationId) {
    OrganizationDTO organizationDTO = service.getOrganization(organizationId);
    return new ResponseEntity<>(new ResponseMessage("get organization successfully", organizationDTO, new Date()), HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseMessage> deleteOrganization(@PathVariable int organizationId) {
    boolean isOrganizationExist = service.deleteOrganization(organizationId);
    if(isOrganizationExist) {
      return new ResponseEntity<>(new ResponseMessage("Delete organization successfully", null, new Date()), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new ResponseMessage("organization with ID: " + organizationId + " is not exist", null, new Date()), HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
    public ResponseEntity<ResponseMessage> createOrganization(Organization newOrganization) {

      OrganizationDTO organization = service.createOrganization(newOrganization);

      return new ResponseEntity<>(new ResponseMessage("Create organization successfully", organization, new Date()), HttpStatus.CREATED);

    }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateOrganization(@Valid @RequestBody OrganizationDTO organizationDTO, @PathVariable int id) {

    OrganizationDTO updateOrganization = service.updateOrganization(id, organizationDTO);

    return new ResponseEntity<>(new ResponseMessage("Update organization successfully", updateOrganization, new Date()), HttpStatus.ACCEPTED);
  }

}
