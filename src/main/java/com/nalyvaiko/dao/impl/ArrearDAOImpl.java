package com.nalyvaiko.dao.impl;

import com.nalyvaiko.dao.ArrearDAO;
import com.nalyvaiko.model.Arrear;
import com.nalyvaiko.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ArrearDAOImpl implements ArrearDAO {

  @Override
  public Optional<Arrear> get(Integer id) {
    Transaction transaction = null;
    Arrear arrear = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      arrear = session.get(Arrear.class, id);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return Optional.ofNullable(arrear);
  }

  @Override
  public void add(Arrear entity) {
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
  public void delete(Arrear entity) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      Arrear arrear = session.get(Arrear.class, entity.getId());
      session.delete(arrear);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void update(Arrear entity) {
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
  public List<Arrear> getAll() {
    Transaction transaction = null;
    List<Arrear> arrears = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      arrears = session.createQuery("select arrear " +
          "from Arrear arrear ", Arrear.class)
          .getResultList();
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return arrears;
  }
}
