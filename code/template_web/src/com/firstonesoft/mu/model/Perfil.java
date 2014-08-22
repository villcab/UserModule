package com.firstonesoft.mu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERFIL_PERFILID_GENERATOR", sequenceName="PERFIL_PERFIL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERFIL_PERFILID_GENERATOR")
	@Column(name="perfil_id")
	private Long perfilId;

	private String descripcion;

	private Boolean estado;

	private String nombre;

	//bi-directional many-to-one association to PerfilAcceso
	@OneToMany(mappedBy="perfil")
	private List<PerfilAcceso> perfilAccesos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	public Perfil() {
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

	public PerfilAcceso addPerfilAcceso(PerfilAcceso perfilAcceso) {
		getPerfilAccesos().add(perfilAcceso);
		perfilAcceso.setPerfil(this);

		return perfilAcceso;
	}

	public PerfilAcceso removePerfilAcceso(PerfilAcceso perfilAcceso) {
		getPerfilAccesos().remove(perfilAcceso);
		perfilAcceso.setPerfil(null);

		return perfilAcceso;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}