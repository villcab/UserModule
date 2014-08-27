package com.firstonesoft.mu.model;

import java.io.Serializable;
import java.util.List;

import com.firstonesoft.utils.Entity;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Perfil extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long perfilId;
	private String descripcion;
	private Boolean estado;
	private String nombre;

	private List<PerfilAcceso> perfilAccesos;
	private List<Usuario> usuarios;

	public Perfil() {
		estado = true;
	}

	public Long getPerfilId() {
		return this.perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PerfilAcceso> getPerfilAccesos() {
		return this.perfilAccesos;
	}

	public void setPerfilAccesos(List<PerfilAcceso> perfilAccesos) {
		this.perfilAccesos = perfilAccesos;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}