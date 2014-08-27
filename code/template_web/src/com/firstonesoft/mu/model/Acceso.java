package com.firstonesoft.mu.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Acceso implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer accesoId;
	private String nombre;
	private Integer secuencia;
	private String url;
	private Integer moduloId;

	private List<PerfilAcceso> perfilAccesos;
	private List<UsuarioAcceso> usuarioAccesos;

	public Acceso() {
	}

	public Integer getAccesoId() {
		return this.accesoId;
	}

	public void setAccesoId(Integer accesoId) {
		this.accesoId = accesoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getModuloId() {
		return moduloId;
	}

	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
	}

	public List<PerfilAcceso> getPerfilAccesos() {
		return this.perfilAccesos;
	}

	public void setPerfilAccesos(List<PerfilAcceso> perfilAccesos) {
		this.perfilAccesos = perfilAccesos;
	}

	public List<UsuarioAcceso> getUsuarioAccesos() {
		return this.usuarioAccesos;
	}

	public void setUsuarioAccesos(List<UsuarioAcceso> usuarioAccesos) {
		this.usuarioAccesos = usuarioAccesos;
	}

}