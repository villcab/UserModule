package com.firstonesoft.mu.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import com.firstonesoft.mu.model.Perfil;

public class PerfilDao {

    @PersistenceContext
    private transient EntityManager manager;

    @Resource
    private transient UserTransaction tx;
    
    public void save(Perfil data) throws Exception {
	tx.begin();
	manager.persist(data);
	tx.commit();
    }
    
    public void update(Perfil data) throws Exception {
	tx.begin();
	manager.merge(data);
	tx.commit();
    }
    
    @SuppressWarnings("unchecked")
    public Perfil getPerfil(Long id) {
	String hql = "FROM Perfil p WHERE p.perfilId = :id AND p.estado = true";
	Query q = manager.createQuery(hql);
	q.setParameter("id", id);
	List<Perfil> list = q.getResultList();
	return list.isEmpty() ? null : list.get(0);
    }
    
    @SuppressWarnings("unchecked")
    public List<Perfil> getPerfiles() {
	String hql = "FROM Perfil p WHERE p.estado = true ORDER BY p.nombre";
	Query q = manager.createQuery(hql);
	return q.getResultList();
    }
    
}
