package com.firstonesoft.mu.model;

import java.io.Serializable;
import java.util.Date;

import com.firstonesoft.utils.Entity;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Bitacora extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date fecha;
	private String accion;
	private String direccionIp;
	private String formulario;
	private String usuario;

	public Bitacora() {
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDireccionIp() {
		return this.direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public String getFormulario() {
		return this.formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}