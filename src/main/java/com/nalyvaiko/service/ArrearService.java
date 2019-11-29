package com.nalyvaiko.service;

import com.nalyvaiko.dao.ArrearDAO;
import com.nalyvaiko.model.Arrear;
import java.util.List;
import java.util.Optional;

public class ArrearService {

  private ArrearDAO arrearDAO;

  public ArrearService(ArrearDAO arrearDAO) {
    this.arrearDAO = arrearDAO;
  }

  public Optional<Arrear> getArrear(Integer id) {
    return arrearDAO.get(id);
  }

  public void addArrear(Arrear entity) {
    arrearDAO.add(entity);
  }

  public void deleteArrear(Arrear entity) {
    arrearDAO.delete(entity);
  }

  public void updateArrear(Arrear entity) {
    arrearDAO.update(entity);
  }

  public List<Arrear> getAllArrears() {
    return arrearDAO.getAll();
  }
}
