package com.online.shopping.portal.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	void save(T entity);
	
    void update(T entity);
    
    void delete(T entity);
    
    T getById(int id);
    
    List<T> getAll();
}
