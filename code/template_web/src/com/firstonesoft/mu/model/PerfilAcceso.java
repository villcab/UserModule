package com.firstonesoft.mu.model;

import java.io.Serializable;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class PerfilAcceso implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long perfilAccesoId;
	private Long accesoId;
	private Integer perfilId;

	public PerfilAcceso() {
	}

	public Long getPerfilAccesoId() {
		return this.perfilAccesoId;
	}

	public void setPerfilAccesoId(Long perfilAccesoId) {
		this.perfilAccesoId = perfilAccesoId;
	}

	public Long getAccesoId() {
		return accesoId;
	}

	public void setAccesoId(Long accesoId) {
		this.accesoId = accesoId;
	}

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

}