package com.se.service;


import com.se.dto.ExamDTO;
import com.se.dto.OrganizationDTO;
import com.se.entity.Course;
import com.se.entity.Organization;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.OrganizationMapper;
import com.se.repository.OrganizationRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  OrganizationRepository repo;
  OrganizationMapper mapper;


    public OrganizationServiceImpl(OrganizationRepository repo, OrganizationMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

  @Override
  public List<OrganizationDTO> getAllOrganization() {
    List<Organization> organizations = repo.findAll();
    return organizations.stream().map(mapper::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public OrganizationDTO getOrganization(int organizationId) {
    Organization organization = repo.findById(organizationId).orElseThrow(() -> {
      return new ResourceNotFoundException("The organization in not exist");
    });
    return mapper.convertToDTO(organization);
  }

  @Override
  public OrganizationDTO createOrganization(Organization newOrganization) {
      Organization data = repo.save(newOrganization);
      return mapper.convertToDTO(data);
  }

  @Override
  public OrganizationDTO updateOrganization(int organizationId, OrganizationDTO organizationDTO) {
    Organization organization = repo.findById(organizationId).orElseThrow(() -> {
      return new ResourceNotFoundException("this organization is not exist");
    });

    organization.setAddress(organizationDTO.getName());
    organization.setName(organizationDTO.getAddress());

    Organization updatedOrganization = repo.save(organization);

    return mapper.convertToDTO(updatedOrganization);
  }

  @Override
  public boolean deleteOrganization(int organizationId) {
    if(repo.existsById(organizationId)) {
      repo.deleteById(organizationId);
      return true;
    } else {
      return false;
    }
  }
}
