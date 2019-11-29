package com.nalyvaiko.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "city_name", nullable = false)
  private String cityName;

  @ManyToOne
  @JoinColumn(name = "region_id")
  private Region region;

  public City() {
  }

  public City(String cityName, Region region) {
    this.cityName = cityName;
    this.region = region;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof City)) {
      return false;
    }
    City city = (City) o;
    return getId().equals(city.getId()) &&
        getCityName().equals(city.getCityName()) &&
        getRegion().equals(city.getRegion());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCityName(), getRegion());
  }
}
