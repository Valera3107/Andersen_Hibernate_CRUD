package ua.com.dao;

import java.util.*;

public interface CommonDAO<T> {
  T insert(T obj);
  T update(T obj);
  void remove(T obj);
  List<T> selectAll();
  T selectById(long id);
}
