package ua.com.service;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import ua.com.model.Address;
import ua.com.dao.AddressDAO;
import ua.com.model.User;
import ua.com.util.SessionConnector;

import java.util.List;

public class AddressService extends SessionConnector implements AddressDAO {

  @Override
  public Address insert(Address obj) {
    openTransaction();
    Long id = (Long) getSession().save(obj);
    obj.setId(id);
    closeTransaction();
    return obj;
  }

  @Override
  public Address update(Address obj) {
    openTransaction();
    getSession().update(obj);
    closeTransaction();
    return obj;
  }

  @Override
  public void remove(Address obj) {
    openTransaction();
    getSession().delete(obj);
    closeTransaction();
  }

  @Override
  public List<Address> selectAll() {
    openTransaction();
    List<Address> addresses = getSession().createCriteria(Address.class).list();
    closeTransaction();
    return addresses;
  }

  @Override
  public Address selectById(long id) {
    openTransaction();
    Address address = (Address) getSession().createCriteria(Address.class).add(Restrictions.eq("id", id)).uniqueResult();
    closeTransaction();
    return address;
  }

  public List<User> getUsersByAddress(Address address){
    openTransaction();
    Query query = openSession().createQuery("select u from User u JOIN u.address a where a.id = :addressId");
    query.setParameter("addressId", address.getId());
    List<User> users = (List<User>) query.list();
    closeTransaction();
    return users;
  }
}
