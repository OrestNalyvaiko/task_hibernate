package com.nalyvaiko.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "region")
public class Region {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "region_name", nullable = false)
  private String regionName;

  @Column(name = "region_code", nullable = false)
  private String regionCode;

  public Region() {
  }

  public Region(String regionName, String regionCode) {
    this.regionName = regionName;
    this.regionCode = regionCode;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Region)) {
      return false;
    }
    Region region = (Region) o;
    return getId().equals(region.getId()) &&
        getRegionName().equals(region.getRegionName()) &&
        getRegionCode().equals(region.getRegionCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getRegionName(), getRegionCode());
  }
}
