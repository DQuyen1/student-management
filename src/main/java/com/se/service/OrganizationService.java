package com.se.service;

import com.se.dto.ExamDTO;
import com.se.dto.OrganizationDTO;
import com.se.dto.SubjectDTO;
import com.se.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrganizationService {


  List<OrganizationDTO> getAllOrganization();

  OrganizationDTO getOrganization(int organizationId);

  OrganizationDTO createOrganization(Organization newOrganization);

  OrganizationDTO updateOrganization(int organizationId, OrganizationDTO organizationDTO);


  boolean deleteOrganization(int organizationId);


}
