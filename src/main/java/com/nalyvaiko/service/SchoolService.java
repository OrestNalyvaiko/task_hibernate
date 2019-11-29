package com.nalyvaiko.service;

import com.nalyvaiko.dao.SchoolDAO;
import com.nalyvaiko.model.School;
import java.util.List;
import java.util.Optional;

public class SchoolService {

  private SchoolDAO schoolDAO;

  public SchoolService(SchoolDAO schoolDAO) {
    this.schoolDAO = schoolDAO;
  }

  public Optional<School> getSchool(Integer id) {
    return schoolDAO.get(id);
  }

  public void addSchool(School entity) {
    schoolDAO.add(entity);
  }

  public void deleteSchool(School entity) {
    schoolDAO.delete(entity);
  }

  public void updateSchool(School entity) {
    schoolDAO.update(entity);
  }

  public List<School> getAllSchools() {
    return schoolDAO.getAll();
  }
}
