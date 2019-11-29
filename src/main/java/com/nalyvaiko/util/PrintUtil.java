package com.nalyvaiko.util;

import com.nalyvaiko.model.*;

public class PrintUtil {


  public static void printStudentData(Student student) {
    System.out.println("Student id: " + student.getId());
    System.out.println("  Name: " + student.getName());
    System.out.println("  Middle name: " + student.getMiddleName());
    System.out.println("  Surname: " + student.getSurname());
    System.out.println("  Rating: " + student.getRating());
    System.out.println("  Date of birth: " + student.getDateBirth());
    System.out.println("  Date of receipts: " + student.getReceiptsDate());
    System.out.println("  Student ticket: " + student.getStudentTicket());
    System.out.println("  Email: " + student.getEmail());
    printCityData(student.getCity());
    printGroupData(student.getGroup());
    student.getArrears().forEach(PrintUtil::printArrearData);
    printSchoolData(student.getSchool());
    System.out.println("----------------------------------");
  }

  public static void printCityData(City city) {
    System.out.println("City id: " + city.getId());
    System.out.println("  City name: " + city.getCityName());
    printRegionData(city.getRegion());
  }

  public static void printRegionData(Region region) {
    System.out.println("Region id: " + region.getId());
    System.out.println("  Region name: " + region.getRegionName());
    System.out.println("  Region code: " + region.getRegionCode());
  }

  public static void printArrearData(Arrear arrear) {
    System.out.println("Arrear id: " + arrear.getId());
    System.out.println("  Subject name: " + arrear.getSubjectName());
  }

  public static void printGroupData(Group group) {
    System.out.println("Group id: " + group.getId());
    System.out.println("  Group name: " + group.getGroupName());
    System.out.println("  Group number: " + group.getGroupNumber());
    System.out.println("  Year of receipts: " + group.getReceiptsYear());
  }

  public static void printSchoolData(School school) {
    System.out.println("School id: " + school.getId());
    System.out.println("  School name: " + school.getSchoolName());
    System.out.println("  School director name: " + school.getDirectorName());
    System.out.println(
        "  School director middle name: " + school.getDirectorMiddleName());
    System.out
        .println("  School director surname: " + school.getDirectorSurname());
    System.out.println("  School telephone: " + school.getTelephone());
    printCityData(school.getCity());
  }
}
