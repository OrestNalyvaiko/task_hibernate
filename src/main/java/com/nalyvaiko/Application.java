package com.nalyvaiko;

import com.nalyvaiko.dao.impl.*;
import com.nalyvaiko.model.*;
import com.nalyvaiko.service.*;
import com.nalyvaiko.util.PrintUtil;
import java.sql.Date;
import java.util.*;

public class Application {

  private RegionService regionService;
  private CityService cityService;
  private SchoolService schoolService;
  private StudentService studentService;
  private GroupService groupService;
  private ArrearService arrearService;

  public Application() {
    regionService = new RegionService(new RegionDAOImpl());
    cityService = new CityService(new CityDAOImpl());
    schoolService = new SchoolService(new SchoolDAOImpl());
    studentService = new StudentService(new StudentDAOImpl());
    groupService = new GroupService(new GroupDAOImpl());
    arrearService = new ArrearService(new ArrearDAOImpl());
    setupData();

    studentService.getAllStudents().forEach(PrintUtil::printStudentData);
    studentService.getStudent(1).ifPresent(student -> {
      student.setSurname("Regus");
      studentService.updateStudent(student);
    });
    studentService.getAllStudents().forEach(PrintUtil::printStudentData);
    studentService.getStudent(1).ifPresent(studentService::deleteStudent);

    studentService.getAllStudents().forEach(PrintUtil::printStudentData);
    arrearService.getAllArrears().forEach(PrintUtil::printArrearData);
    cityService.getAllCities().forEach(PrintUtil::printCityData);
    groupService.getAllGroups().forEach(PrintUtil::printGroupData);
    regionService.getAllRegions().forEach(PrintUtil::printRegionData);
    schoolService.getAllSchools().forEach(PrintUtil::printSchoolData);

  }

  public static void main(String[] args) {
    new Application();
  }

  private void setupData() {
    Region region = new Region("Kyiv region", "123");
    regionService.addRegion(region);
    City city = new City("Kyiv", region);
    cityService.addCity(city);
    Group group = new Group("KI", "12", (short) 2015);
    groupService.addGroup(group);
    School school = new School("5", "Laryca", "Mykolaivna", "Stasevych",
        "+380675532459", city);
    schoolService.addSchool(school);
    Arrear arrear = new Arrear();
    arrear.setSubjectName("Physics");

    List<Arrear> arrears = new ArrayList<>();
    arrears.add(arrear);

    arrear = new Arrear();
    arrear.setSubjectName("Math");
    arrears.add(arrear);

    arrear = new Arrear();
    arrear.setSubjectName("TI");
    arrears.add(arrear);

    Student firstStudent = new Student();
    firstStudent.setName("Ostap");
    firstStudent.setMiddleName("Andriyvych");
    firstStudent.setSurname("Senic");
    firstStudent.setCity(city);
    firstStudent.setDateBirth(Date.valueOf("1999-12-10"));
    firstStudent.setReceiptsDate(Date.valueOf("2016-09-01"));
    firstStudent.setGroup(group);
    firstStudent.setStudentTicket("222222");
    firstStudent.setSchool(school);
    firstStudent.setArrears(arrears);

    Student secondStudent = new Student();
    secondStudent.setName("Maksym");
    secondStudent.setMiddleName("Olegovych");
    secondStudent.setSurname("Mykytka");
    secondStudent.setCity(city);
    secondStudent.setDateBirth(Date.valueOf("1998-10-10"));
    secondStudent.setReceiptsDate(Date.valueOf("2015-09-01"));
    secondStudent.setGroup(group);
    secondStudent.setStudentTicket("123456");
    secondStudent.setSchool(school);
    secondStudent.setArrears(arrears);

    studentService.addStudent(firstStudent);
    studentService.addStudent(secondStudent);
  }
}
