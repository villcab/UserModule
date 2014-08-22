package com.firstonesoft.mu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_USUARIOID_GENERATOR", sequenceName="USUARIO_USUARIO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_USUARIOID_GENERATOR")
	@Column(name="usuario_id")
	private Long usuarioId;

	private String ci;

	private String email;

	private Boolean estado;

	private String nombres;

	private String password;

	private String telefono;

	private String username;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;

	//bi-directional many-to-one association to UsuarioAcceso
	@OneToMany(mappedBy="usuario")
	private List<UsuarioAcceso> usuarioAccesos;

	public Usuario() {
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

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<UsuarioAcceso> getUsuarioAccesos() {
		return this.usuarioAccesos;
	}

	public void setUsuarioAccesos(List<UsuarioAcceso> usuarioAccesos) {
		this.usuarioAccesos = usuarioAccesos;
	}

	public UsuarioAcceso addUsuarioAcceso(UsuarioAcceso usuarioAcceso) {
		getUsuarioAccesos().add(usuarioAcceso);
		usuarioAcceso.setUsuario(this);

		return usuarioAcceso;
	}

	public UsuarioAcceso removeUsuarioAcceso(UsuarioAcceso usuarioAcceso) {
		getUsuarioAccesos().remove(usuarioAcceso);
		usuarioAcceso.setUsuario(null);

		return usuarioAcceso;
	}

}