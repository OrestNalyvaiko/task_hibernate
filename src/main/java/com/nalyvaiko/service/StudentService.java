package com.nalyvaiko.service;

import com.nalyvaiko.dao.StudentDAO;
import com.nalyvaiko.model.Student;
import java.util.List;
import java.util.Optional;

public class StudentService {

  private StudentDAO studentDAO;

  public StudentService(StudentDAO studentDAO) {
    this.studentDAO = studentDAO;
  }

  public Optional<Student> getStudent(Integer id) {
    return studentDAO.get(id);
  }

  public void addStudent(Student entity) {
    studentDAO.add(entity);
  }

  public void deleteStudent(Student entity) {
    studentDAO.delete(entity);
  }

  public void updateStudent(Student entity) {
    studentDAO.update(entity);
  }

  public List<Student> getAllStudents() {
    return studentDAO.getAll();
  }
}
