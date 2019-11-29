package com.nalyvaiko.service;

import com.nalyvaiko.dao.GroupDAO;
import com.nalyvaiko.model.Group;
import java.util.List;
import java.util.Optional;

public class GroupService {

  private GroupDAO groupDAO;

  public GroupService(GroupDAO groupDAO) {
    this.groupDAO = groupDAO;
  }

  public Optional<Group> getGroup(Integer id) {
    return groupDAO.get(id);
  }

  public void addGroup(Group entity) {
    groupDAO.add(entity);
  }

  public void deleteGroup(Group entity) {
    groupDAO.delete(entity);
  }

  public void updateGroup(Group entity) {
    groupDAO.update(entity);
  }

  public List<Group> getAllGroups() {
    return groupDAO.getAll();
  }
}
