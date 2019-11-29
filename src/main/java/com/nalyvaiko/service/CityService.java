package com.nalyvaiko.service;

import com.nalyvaiko.dao.CityDAO;
import com.nalyvaiko.model.City;
import java.util.List;
import java.util.Optional;

public class CityService {

  private CityDAO cityDAO;

  public CityService(CityDAO cityDAO) {
    this.cityDAO = cityDAO;
  }

  public Optional<City> getCity(Integer id) {
    return cityDAO.get(id);
  }

  public void addCity(City entity) {
    cityDAO.add(entity);
  }

  public void deleteCity(City entity) {
    cityDAO.delete(entity);
  }

  public void updateCity(City entity) {
    cityDAO.update(entity);
  }

  public List<City> getAllCities() {
    return cityDAO.getAll();
  }
}
