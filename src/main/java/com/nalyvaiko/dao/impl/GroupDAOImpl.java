package com.nalyvaiko.dao.impl;

import com.nalyvaiko.dao.GroupDAO;
import com.nalyvaiko.model.Group;
import com.nalyvaiko.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupDAOImpl implements GroupDAO {

  @Override
  public Optional<Group> get(Integer id) {
    Transaction transaction = null;
    Group group = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      group = session.get(Group.class, id);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return Optional.ofNullable(group);
  }

  @Override
  public void add(Group entity) {
    Transaction transaction = null;

    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      session.save(entity);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void delete(Group entity) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      Group group = session.get(Group.class, entity.getId());
      session.delete(group);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void update(Group entity) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      session.merge(entity);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public List<Group> getAll() {
    Transaction transaction = null;
    List<Group> groups = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      groups = session.createQuery("select group " +
          "from Group group ", Group.class)
          .getResultList();
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return groups;
  }
}
