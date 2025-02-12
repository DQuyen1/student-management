package com.se.service;

import com.se.dto.UserDTO;
import com.se.entity.Subject;
import com.se.entity.User;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.UserMapper;
import com.se.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

  final private UserMapper userMapper;
  final private UserRepository repo;

  @Autowired
  public UserServiceImpl(UserRepository repo, UserMapper userMapper) {
    this.repo = repo;
    this.userMapper = userMapper;
  }


  @Override
  public List<UserDTO> getAll() {
    List<User> users = repo.findAll();

    return users.stream().map(userMapper::convertToDTO).collect(Collectors.toList());

  }

  @Override
  public UserDTO findById(int id) {
    User user = repo.findById(id).orElseThrow(() -> {
      return new ResourceNotFoundException("User not found");
    });;

    return userMapper.convertToDTO(user);

  }

  @Override
  public UserDTO createUser(User newUser) {
    User user  = repo.save(newUser);
    return userMapper.convertToDTO(user);
  }

  @Override
  public UserDTO updateUser(int userId, UserDTO userDTO) {
    User user = repo.findById(userId).orElseThrow(() -> {
      return new ResourceNotFoundException("this user is not exist");
    });

    user.setUsername(userDTO.getUsername());
    user.setEmail(userDTO.getEmail());
    user.setDob(userDTO.getDob());

    User updatedUser = repo.save(user);

    return userMapper.convertToDTO(updatedUser);
  }

  @Override
  public boolean deleteUser(int id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

}
