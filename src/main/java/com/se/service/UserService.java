package com.se.service;

import com.se.dto.SubjectDTO;
import com.se.dto.UserDTO;
import com.se.entity.User;

import java.util.List;

public interface UserService {

  List<UserDTO> getAll();

  UserDTO findById(int id);

  UserDTO createUser(User newUser);

  UserDTO updateUser(int userId, UserDTO userDTO);

  boolean deleteUser(int id);

}
