package com.nalyvaiko.dao.impl;

import com.nalyvaiko.dao.SchoolDAO;
import com.nalyvaiko.model.School;
import com.nalyvaiko.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SchoolDAOImpl implements SchoolDAO {

  @Override
  public Optional<School> get(Integer id) {
    Transaction transaction = null;
    School school = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      school = session.get(School.class, id);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return Optional.ofNullable(school);
  }

  @Override
  public void add(School entity) {
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
  public void delete(School entity) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      School school = session.get(School.class, entity.getId());
      session.delete(school);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void update(School entity) {
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
  public List<School> getAll() {
    Transaction transaction = null;
    List<School> schools = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      schools = session.createQuery("select school " +
          "from School school " +
          "join fetch school.city city " +
          "join fetch city.region ", School.class)
          .getResultList();
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return schools;
  }
}
