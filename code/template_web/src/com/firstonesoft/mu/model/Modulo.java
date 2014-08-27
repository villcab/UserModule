package com.firstonesoft.mu.model;

import java.io.Serializable;
import java.util.List;

import com.firstonesoft.utils.Entity;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Modulo extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer moduloId;
	private String nombre;
	private Integer secuencia;

	private List<Acceso> accesos;

	public Modulo() {
	}

	public Integer getModuloId() {
		return this.moduloId;
	}

	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
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

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

}