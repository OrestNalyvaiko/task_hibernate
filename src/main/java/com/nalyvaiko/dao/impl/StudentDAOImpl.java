package com.nalyvaiko.dao.impl;

import com.nalyvaiko.dao.StudentDAO;
import com.nalyvaiko.model.Student;
import com.nalyvaiko.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO {

  @Override
  public Optional<Student> get(Integer id) {
    Transaction transaction = null;
    Student student = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      student = session.get(Student.class, id);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return Optional.ofNullable(student);
  }

  @Override
  public void add(Student entity) {
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
  public void delete(Student entity) {
    Transaction transaction = null;

    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      Student student = session.get(Student.class, entity.getId());
      session.delete(student);
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
  }

  @Override
  public void update(Student entity) {
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
  public List<Student> getAll() {
    Transaction transaction = null;
    List<Student> students = null;
    try (Session session = HibernateUtil.getSession()) {
      transaction = session.beginTransaction();
      students = session.createQuery("select distinct student " +
              "from Student student "
              + "join fetch student.arrears "
              + "join fetch student.group "
              + "join fetch student.city city "
              + "join fetch city.region "
              + "join fetch student.school "
          , Student.class)
          .getResultList();
      transaction.commit();
    } catch (HibernateException exception) {
      Optional.ofNullable(transaction).ifPresent(Transaction::rollback);
      exception.printStackTrace();
    }
    return students;
  }
}
