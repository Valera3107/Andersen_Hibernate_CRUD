package ua.com.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionConnector {
  private Session session;
  private Transaction transaction;

  public Transaction getTransaction() {
    return transaction;
  }

  public Session getSession() {
    return session;
  }

  public Session openSession() {
    return HibernateUtil.getSessionFactory().openSession();
  }

  public void closeSession() {
    session.close();
  }

  public Session openTransaction() {
    session = openSession();
    transaction = session.beginTransaction();
    return session;
  }

  public void closeTransaction(){
    transaction.commit();
    closeSession();
  }
}
