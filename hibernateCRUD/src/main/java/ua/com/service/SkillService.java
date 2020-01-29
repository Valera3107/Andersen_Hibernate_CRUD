package ua.com.service;

import org.hibernate.criterion.Restrictions;
import ua.com.model.Skill;
import ua.com.dao.SkillDAO;
import ua.com.util.SessionConnector;

import java.util.List;

public class SkillService extends SessionConnector implements SkillDAO {

  @Override
  public Skill insert(Skill obj) {
    openTransaction();
    Long id = (Long) getSession().save(obj);
    obj.setId(id);
    closeTransaction();
    return obj;
  }

  @Override
  public Skill update(Skill obj) {
    openTransaction();
    getSession().update(obj);
    closeTransaction();
    return obj;
  }

  @Override
  public void remove(Skill obj) {
    openTransaction();
    getSession().delete(obj);
    closeTransaction();
  }

  @Override
  public List<Skill> selectAll() {
    openTransaction();
    List<Skill> skills = getSession().createCriteria(Skill.class).list();
    closeTransaction();
    return skills;
  }

  @Override
  public Skill selectById(long id) {
    openTransaction();
    Skill skill = (Skill) getSession().createCriteria(Skill.class).add(Restrictions.eq("id", id)).uniqueResult();
    closeTransaction();
    return skill;
  }
}
