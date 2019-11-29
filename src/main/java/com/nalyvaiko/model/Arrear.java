package com.nalyvaiko.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "arrear")
public class Arrear {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "subject_name", nullable = false)
  private String subjectName;

  @ManyToMany(mappedBy = "arrears")
  private List<Student> students;

  public Arrear() {
  }

  public Arrear(String subjectName, List<Student> students) {
    this.subjectName = subjectName;
    this.students = students;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Arrear)) {
      return false;
    }
    Arrear arrear = (Arrear) o;
    return getId().equals(arrear.getId()) &&
        getSubjectName().equals(arrear.getSubjectName()) &&
        getStudents().equals(arrear.getStudents());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getSubjectName(), getStudents());
  }
}
