package com.se.controller;

import com.se.dto.SubjectDTO;
import com.se.dto.UserDTO;
import com.se.entity.ResponseMessage;
import com.se.entity.User;
import com.se.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;



@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

  UserServiceImpl userService;

  //if only has 1 constructor this annotation autowired is optional
  @Autowired
  public UserController(UserServiceImpl userService) {

    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<ResponseMessage> getAllUser() {
    return new ResponseEntity<>(new ResponseMessage("Users retrieved successfully", userService.getAll(), new Date()), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseMessage> getUser(@PathVariable int id) {
    UserDTO userDTO = userService.findById(id);
    return new ResponseEntity<>(new ResponseMessage("User retrieved successfully",  userDTO, new Date()), HttpStatus.OK);
  }


  @PostMapping("/insert")
  public ResponseEntity<ResponseMessage> createUser(@Valid @RequestBody User user) {

    return new ResponseEntity<>(new ResponseMessage("created new user successfully", userService.createUser(user) ,new Date()), HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseMessage> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable int id) {

    UserDTO updatedUser = userService.updateUser(id, userDTO);

    return new ResponseEntity<>(new ResponseMessage("Update user successfully", updatedUser, new Date()), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseMessage> deleteUser(@PathVariable int id) {

    boolean isDeleted = userService.deleteUser(id);

    if (isDeleted) {
      return new ResponseEntity<>(
        new ResponseMessage("User with id #" + id
          + " deleted successfully", null, new Date()),
        HttpStatus.OK
      );
    } else {
      return new ResponseEntity<>(
        new ResponseMessage("User not found", null, new Date()),
        HttpStatus.NOT_FOUND
      );
    }
  }




}
