package ua.com.service;

import org.hibernate.criterion.Restrictions;
import ua.com.model.Passport;
import ua.com.dao.PassportDAO;
import ua.com.util.SessionConnector;

import java.util.List;

public class PassportService extends SessionConnector implements PassportDAO {

  @Override
  public Passport insert(Passport obj) {
    openTransaction();
    Long id = (Long) getSession().save(obj);
    obj.setId(id);
    closeTransaction();
    return obj;
  }

  @Override
  public Passport update(Passport obj) {
    openTransaction();
    getSession().update(obj);
    closeTransaction();
    return obj;
  }

  @Override
  public void remove(Passport obj) {
    openTransaction();
    getSession().delete(obj);
    closeTransaction();
  }

  @Override
  public List<Passport> selectAll() {
    openTransaction();
    List<Passport> passports = getSession().createCriteria(Passport.class).list();
    closeTransaction();
    return passports;
  }

  @Override
  public Passport selectById(long id) {
    openTransaction();
    Passport passport = (Passport) getSession().createCriteria(Passport.class).add(Restrictions.eq("id", id)).uniqueResult();
    closeTransaction();
    return passport;
  }
}
