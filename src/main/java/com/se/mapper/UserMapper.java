package com.se.mapper;

import com.se.dto.UserDTO;
import com.se.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO convertToDTO(User user) {
      if (user == null) {
        return null;
      }
      return new UserDTO(user.getUsername(), user.getEmail(), user.getDob());
    }



}
