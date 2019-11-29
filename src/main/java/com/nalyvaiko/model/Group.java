package com.nalyvaiko.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "student_group")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "group_name", nullable = false)
  private String groupName;

  @Column(name = "group_number", nullable = false)
  private String groupNumber;

  @Column(name = "year_of_receipts", nullable = false)
  private Short receiptsYear;

  public Group() {
  }

  public Group(String groupName, String groupNumber, Short receiptsYear) {
    this.groupName = groupName;
    this.groupNumber = groupNumber;
    this.receiptsYear = receiptsYear;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupNumber() {
    return groupNumber;
  }

  public void setGroupNumber(String groupNumber) {
    this.groupNumber = groupNumber;
  }

  public Short getReceiptsYear() {
    return receiptsYear;
  }

  public void setReceiptsYear(Short receiptsYear) {
    this.receiptsYear = receiptsYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Group)) {
      return false;
    }
    Group group = (Group) o;
    return getId().equals(group.getId()) &&
        getGroupName().equals(group.getGroupName()) &&
        getGroupNumber().equals(group.getGroupNumber()) &&
        getReceiptsYear().equals(group.getReceiptsYear());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getGroupName(), getGroupNumber(), getReceiptsYear());
  }
}
