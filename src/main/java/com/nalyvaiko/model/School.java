package com.nalyvaiko.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "school")
public class School {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "school_name", nullable = false)
  private String schoolName;

  @Column(name = "director_name", nullable = false)
  private String directorName;

  @Column(name = "director_middle_name", nullable = false)
  private String directorMiddleName;

  @Column(name = "director_surname", nullable = false)
  private String directorSurname;

  @Column(name = "telephone", nullable = false)
  private String telephone;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private City city;

  public School() {
  }

  public School(String schoolName, String directorName,
      String directorMiddleName, String directorSurname,
      String telephone, City city) {
    this.schoolName = schoolName;
    this.directorName = directorName;
    this.directorMiddleName = directorMiddleName;
    this.directorSurname = directorSurname;
    this.telephone = telephone;
    this.city = city;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public String getDirectorName() {
    return directorName;
  }

  public void setDirectorName(String directorName) {
    this.directorName = directorName;
  }

  public String getDirectorMiddleName() {
    return directorMiddleName;
  }

  public void setDirectorMiddleName(String directorMiddleName) {
    this.directorMiddleName = directorMiddleName;
  }

  public String getDirectorSurname() {
    return directorSurname;
  }

  public void setDirectorSurname(String directorSurname) {
    this.directorSurname = directorSurname;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof School)) {
      return false;
    }
    School school = (School) o;
    return getId().equals(school.getId()) &&
        getSchoolName().equals(school.getSchoolName()) &&
        getDirectorName().equals(school.getDirectorName()) &&
        getDirectorMiddleName().equals(school.getDirectorMiddleName()) &&
        getDirectorSurname().equals(school.getDirectorSurname()) &&
        getTelephone().equals(school.getTelephone()) &&
        getCity().equals(school.getCity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getSchoolName(), getDirectorName(),
        getDirectorMiddleName(), getDirectorSurname(), getTelephone(),
        getCity());
  }
}
