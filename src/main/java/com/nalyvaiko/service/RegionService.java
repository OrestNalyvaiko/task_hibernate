package com.nalyvaiko.service;

import com.nalyvaiko.dao.RegionDAO;
import com.nalyvaiko.model.Region;
import java.util.List;
import java.util.Optional;

public class RegionService {

  private RegionDAO regionDAO;

  public RegionService(RegionDAO regionDAO) {
    this.regionDAO = regionDAO;
  }

  public Optional<Region> getRegion(Integer id) {
    return regionDAO.get(id);
  }

  public void addRegion(Region entity) {
    regionDAO.add(entity);
  }

  public void deleteRegion(Region entity) {
    regionDAO.delete(entity);
  }

  public void updateRegion(Region entity) {
    regionDAO.update(entity);
  }

  public List<Region> getAllRegions() {
    return regionDAO.getAll();
  }
}
