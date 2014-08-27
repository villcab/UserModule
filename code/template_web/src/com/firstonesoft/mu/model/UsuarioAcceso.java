package com.firstonesoft.mu.model;

import java.io.Serializable;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class UsuarioAcceso implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long usuarioAccesoId;
	private Integer accesoId;
	private Long usuarioId;

	public UsuarioAcceso() {
	}

	public Long getUsuarioAccesoId() {
		return this.usuarioAccesoId;
	}

	public void setUsuarioAccesoId(Long usuarioAccesoId) {
		this.usuarioAccesoId = usuarioAccesoId;
	}

	public Integer getAccesoId() {
		return accesoId;
	}

	public void setAccesoId(Integer accesoId) {
		this.accesoId = accesoId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}