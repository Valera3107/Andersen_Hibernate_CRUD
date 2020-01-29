package ua.com.service;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import ua.com.model.Address;
import ua.com.model.Passport;
import ua.com.model.Skill;
import ua.com.model.User;
import ua.com.dao.UserDAO;
import ua.com.util.SessionConnector;

import java.util.List;

public class UserService extends SessionConnector implements UserDAO {

  @Override
  public User insert(User obj) {
    openTransaction();
    Long id = (Long) getSession().save(obj);
    obj.setId(id);
    closeTransaction();
    return obj;
  }

  @Override
  public User update(User obj) {
    openTransaction();
    getSession().update(obj);
    closeTransaction();
    return obj;
  }

  @Override
  public void remove(User obj) {
    openTransaction();
    getSession().delete(obj);
    closeTransaction();
  }

  @Override
  public List<User> selectAll() {
    openTransaction();
    List<User> list = getSession().createCriteria(User.class).list();
    closeTransaction();
    return list;
  }

  @Override
  public User selectById(long id) {
    openTransaction();
    User user = (User) getSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
    closeTransaction();
    return user;
  }

  public boolean addSkill(Skill skill, User user) {
    openTransaction();
    getUserSkills(user).add(skill);
    getSession().update(user);
    closeTransaction();
    return true;
  }

  public List<Skill> getUserSkills(User user) {
    openTransaction();
    Query query = getSession().createQuery("select s from Skill s JOIN s.users u where u.id = :userId ");
    query.setParameter("userId", user.getId());
    List<Skill> skills = (List<Skill>) query.list();
    closeTransaction();
    return skills;
  }

  public void removeSkill(User user, Skill skill) {
    openTransaction();
    user.getSkills().remove(skill);
    openSession().update(user);
    closeTransaction();
  }

  public boolean addPassport(Passport passport, User user) {
    user.setPassport(passport);
    openTransaction();
    openSession().update(user);
    closeTransaction();
    return true;
  }

  public Passport getPassport(User user) {
    openTransaction();
    Passport passport = user.getPassport();
    closeTransaction();
    return passport;
  }

  public void deletePassport(User user) {
    openTransaction();
    if (user.getPassport() != null) {
      user.setPassport(null);
      openSession().update(user);
    }
    closeTransaction();
  }

  public void addAddress(User user, Address address){
    user.setAddress(address);
    openTransaction();
    openSession().update(user);
    closeTransaction();
  }

  public void deleteAddress(User user, Address address){
    openTransaction();
    if(user.getAddress()!=null){
      user.setAddress(null);
      openSession().update(user);
    }
    closeTransaction();
  }
}
