package com.nalyvaiko.dao.impl;

import com.nalyvaiko.dao.RegionDAO;
import com.nalyvaiko.model.Region;
import com.nalyvaiko.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegionDAOImpl implements RegionDAO {

  @Override
  public Optional<Region> get(Integer id) {
    Transaction transaction = null;
    Region region = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      region = session.get(Region.class, id);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return Optional.ofNullable(region);
  }

  @Override
  public void add(Region entity) {
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
  public void delete(Region entity) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      Region region = session.get(Region.class, entity.getId());
      session.delete(region);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void update(Region entity) {
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
  public List<Region> getAll() {
    Transaction transaction = null;
    List<Region> regions = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      regions = session.createQuery("select region " +
          "from Region region ", Region.class)
          .getResultList();
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return regions;
  }
}
