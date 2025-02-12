package com.se.service;

import com.se.dto.TimetableDTO;
import com.se.entity.Subject;
import com.se.entity.Timetable;
import com.se.exception.ResourceNotFoundException;
import com.se.mapper.TimetableMapper;
import com.se.repository.TimetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TimetableServiceImpl implements TimetableService{


  TimetableRepository repo;
  TimetableMapper mapper;

  public TimetableServiceImpl(TimetableRepository repo, TimetableMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  @Override
  public List<TimetableDTO> getAllTimetable() {
    List<Timetable> timetables = repo.findAll();
    return timetables.stream().map(mapper::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public TimetableDTO getTimetable(int timetableId) {
    Timetable timetable = repo.findById(timetableId).orElseThrow(() -> {
      return new ResourceNotFoundException("The tiemtable in not exist");
    });
    return mapper.convertToDTO(timetable);
  }

  @Override
  public TimetableDTO createTimetable(Timetable newTimetable) {
    return mapper.convertToDTO(repo.save(newTimetable));
  }

  @Override
  public TimetableDTO updateTimetable(int timetableId, TimetableDTO timetableDTO) {
    Timetable timetable = repo.findById(timetableId).orElseThrow(() -> {
      return new ResourceNotFoundException("this timetable is not exist");
    });

    timetable.setDate(timetableDTO.getDate());
    timetable.setStatus(timetableDTO.isStatus());

    Timetable updatedTimetable = repo.save(timetable);

    return mapper.convertToDTO(updatedTimetable);
  }

  @Override
  public boolean deleteTimetable(int timetableId) {
    if(repo.existsById(timetableId)) {
      repo.deleteById(timetableId);
      return true;
    } else {
      return false;
    }
  }
}
