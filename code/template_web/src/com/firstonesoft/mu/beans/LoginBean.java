package com.firstonesoft.mu.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.firstonesoft.utils.FacesUtil;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(LoginBean.class); 

    private String username;
    private String password;

    @PostConstruct
    private void init() {
	try {
	    
	    
	} catch (Exception e) {
	    log.error("Error al cargar la vista", e);
	}
    }

    public void acceder() {
	log.info("Validando usuario");
	
	FacesUtil.setParametro("home", "/UserModule/view/index.jsf");
    }

    /**
     * GETTER AND SETTER
     */
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}
