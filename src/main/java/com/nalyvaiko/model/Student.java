package com.nalyvaiko.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "middle_name", nullable = false)
  private String middleName;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "rating")
  private BigDecimal rating;

  @Column(name = "date_of_birth", nullable = false)
  private Date dateBirth;

  @Column(name = "date_of_receipts", nullable = false)
  private Date receiptsDate;

  @Column(name = "student_ticket", nullable = false)
  private String studentTicket;

  @Column(name = "email")
  private String email;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  @ManyToOne
  @JoinColumn(name = "school_id")
  private School school;

  @ManyToMany(fetch = FetchType.EAGER)
  @Cascade(value = {CascadeType.DETACH, CascadeType.PERSIST,
      CascadeType.REFRESH, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
  @JoinTable(
      name = "student_arrear",
      joinColumns = {@JoinColumn(name = "student_id")},
      inverseJoinColumns = {@JoinColumn(name = "arrear_id")}
  )
  private List<Arrear> arrears;

  public Student() {

  }

  public Student(String name, String middleName, String surname,
      BigDecimal rating, Date dateBirth, Date receiptsDate,
      String studentTicket, String email, City city,
      Group group, School school,
      List<Arrear> arrears) {
    this.name = name;
    this.middleName = middleName;
    this.surname = surname;
    this.rating = rating;
    this.dateBirth = dateBirth;
    this.receiptsDate = receiptsDate;
    this.studentTicket = studentTicket;
    this.email = email;
    this.city = city;
    this.group = group;
    this.school = school;
    this.arrears = arrears;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public BigDecimal getRating() {
    return rating;
  }

  public void setRating(BigDecimal rating) {
    this.rating = rating;
  }

  public Date getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(Date dateBirth) {
    this.dateBirth = dateBirth;
  }

  public Date getReceiptsDate() {
    return receiptsDate;
  }

  public void setReceiptsDate(Date receiptsDate) {
    this.receiptsDate = receiptsDate;
  }

  public String getStudentTicket() {
    return studentTicket;
  }

  public void setStudentTicket(String studentTicket) {
    this.studentTicket = studentTicket;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }

  public List<Arrear> getArrears() {
    return arrears;
  }

  public void setArrears(List<Arrear> arrears) {
    this.arrears = arrears;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return getId().equals(student.getId()) &&
        getName().equals(student.getName()) &&
        getMiddleName().equals(student.getMiddleName()) &&
        getSurname().equals(student.getSurname()) &&
        getRating().equals(student.getRating()) &&
        getDateBirth().equals(student.getDateBirth()) &&
        getReceiptsDate().equals(student.getReceiptsDate()) &&
        getStudentTicket().equals(student.getStudentTicket()) &&
        getEmail().equals(student.getEmail()) &&
        getCity().equals(student.getCity()) &&
        getGroup().equals(student.getGroup()) &&
        getSchool().equals(student.getSchool()) &&
        getArrears().equals(student.getArrears());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getName(), getMiddleName(), getSurname(), getRating(),
            getDateBirth(), getReceiptsDate(), getStudentTicket(), getEmail(),
            getCity(), getGroup(), getSchool(), getArrears());
  }
}
