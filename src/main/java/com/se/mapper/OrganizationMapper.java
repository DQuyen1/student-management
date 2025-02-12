package com.se.mapper;

import com.se.dto.OrganizationDTO;
import com.se.entity.Organization;
import org.springframework.stereotype.Component;


@Component
public class OrganizationMapper {


  public OrganizationDTO convertToDTO(Organization data) {

    if (data == null ){
      return null;
    } else {
      return new OrganizationDTO(data.getAddress(), data.getName());
    }

  }

}
