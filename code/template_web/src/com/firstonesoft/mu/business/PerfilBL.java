package com.firstonesoft.mu.business;

import java.util.List;

import javax.inject.Inject;

import com.firstonesoft.mu.dao.PerfilDao;
import com.firstonesoft.mu.model.Perfil;

public class PerfilBL {
    
    @Inject
    private PerfilDao perfilDao;

    public void save(Perfil data) throws Exception {
	perfilDao.save(data);
    }
    
    public void update(Perfil data) throws Exception {
	perfilDao.update(data);
    }
    
    public void delete (Perfil data) throws Exception {
	data.setEstado(false);
	perfilDao.update(data);
    }
    
    public Perfil getPerfil(Long id) {
	return perfilDao.getPerfil(id);
    }
    
    public List<Perfil> getPerfiles() {
	return perfilDao.getPerfiles();
    }
    
}
