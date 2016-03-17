package org.fiveware.test.model.dao;

import java.io.Serializable;
import java.util.List;

import org.fiveware.test.entidades.Pessoa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class GenericDao<T> {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }

   
    
    public List<T> listarTodos() {
		
		List<T> listaPessoa = getSession().createCriteria(Pessoa.class).list();
		return listaPessoa;
	}
    
   
    
}