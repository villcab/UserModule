package com.firstonesoft.mu.model;

import java.io.Serializable;
import java.util.List;

import com.firstonesoft.utils.Entity;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Usuario extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long usuarioId;
	private String ci;
	private String email;
	private Boolean estado;
	private String nombres;
	private String password;
	private String telefono;
	private String username;
	private Integer perfilId;

	private List<UsuarioAcceso> usuarioAccesos;

	public Usuario() {
		estado = true;
	}

	public Long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getCi() {
		return this.ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	public List<UsuarioAcceso> getUsuarioAccesos() {
		return this.usuarioAccesos;
	}

	public void setUsuarioAccesos(List<UsuarioAcceso> usuarioAccesos) {
		this.usuarioAccesos = usuarioAccesos;
	}

}