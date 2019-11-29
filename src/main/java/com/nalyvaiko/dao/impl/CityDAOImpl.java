package com.nalyvaiko.dao.impl;

import com.nalyvaiko.dao.CityDAO;
import com.nalyvaiko.model.City;
import com.nalyvaiko.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CityDAOImpl implements CityDAO {

  @Override
  public Optional<City> get(Integer id) {
    Transaction transaction = null;
    City city = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      city = session.get(City.class, id);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return Optional.ofNullable(city);
  }

  @Override
  public void add(City entity) {
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
  public void delete(City entity) {
    Transaction transaction = null;

    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      City city = session.get(City.class, entity.getId());
      session.delete(city);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void update(City entity) {
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
  public List<City> getAll() {
    Transaction transaction = null;
    List<City> cities = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      cities = session.createQuery("select city " +
          "from City city " +
          "join fetch city.region ", City.class)
          .getResultList();
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return cities;
  }
}
