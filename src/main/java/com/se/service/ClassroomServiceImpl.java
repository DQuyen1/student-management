package com.se.service;

import com.se.dto.ClassroomDTO;
import com.se.entity.Classroom;
import com.se.entity.Subject;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.ClassroomMapper;
import com.se.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService{


  ClassroomRepository repo;
  ClassroomMapper mapper;


  public ClassroomServiceImpl(ClassroomRepository repo, ClassroomMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }


  @Override
  public List<ClassroomDTO> getAllClassroom() {
    List<Classroom> classrooms = repo.findAll();
    return classrooms.stream().map(mapper::converToDTO).collect(Collectors.toList());
  }

  @Override
  public ClassroomDTO getClassroom(int classroomId) {

    Classroom classroom = repo.findById(classroomId).orElseThrow(() -> {
      return new ResourceNotFoundException("The classroom in not exist");
    });

    ClassroomDTO classroomDTO = mapper.converToDTO(classroom);

    return classroomDTO;
  }

  @Override
  public ClassroomDTO createClassroom(Classroom newClassroom) {
    Classroom classroom = repo.save(newClassroom);
    return mapper.converToDTO(classroom);
  }

  @Override
  public boolean deleteClassroom(int classroomId) {
    if(repo.existsById(classroomId)) {
      repo.deleteById(classroomId);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public ClassroomDTO updateClassroom(int classroomId, ClassroomDTO classroomDTO) {
    Classroom classroom = repo.findById(classroomId).orElseThrow(() -> {
      return new ResourceNotFoundException("this classroom is not exist");
    });

    classroom.setRoom_number(classroomDTO.getRoomNumber());
    classroom.setCapacity(classroomDTO.getCapacity());
    classroom.setAvailable(classroom.isAvailable());

    Classroom updatedClassroom = repo.save(classroom);

    return mapper.converToDTO(updatedClassroom);
  }

}

