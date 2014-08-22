package com.firstonesoft.mu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acceso database table.
 * 
 */
@Entity
@NamedQuery(name="Acceso.findAll", query="SELECT a FROM Acceso a")
public class Acceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acceso_id")
	private Integer accesoId;

	private String nombre;

	private Integer secuencia;

	private String url;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	@JoinColumn(name="modulo_id")
	private Modulo modulo;

	//bi-directional many-to-one association to PerfilAcceso
	@OneToMany(mappedBy="acceso")
	private List<PerfilAcceso> perfilAccesos;

	//bi-directional many-to-one association to UsuarioAcceso
	@OneToMany(mappedBy="acceso")
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

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<PerfilAcceso> getPerfilAccesos() {
		return this.perfilAccesos;
	}

	public void setPerfilAccesos(List<PerfilAcceso> perfilAccesos) {
		this.perfilAccesos = perfilAccesos;
	}

	public PerfilAcceso addPerfilAcceso(PerfilAcceso perfilAcceso) {
		getPerfilAccesos().add(perfilAcceso);
		perfilAcceso.setAcceso(this);

		return perfilAcceso;
	}

	public PerfilAcceso removePerfilAcceso(PerfilAcceso perfilAcceso) {
		getPerfilAccesos().remove(perfilAcceso);
		perfilAcceso.setAcceso(null);

		return perfilAcceso;
	}

	public List<UsuarioAcceso> getUsuarioAccesos() {
		return this.usuarioAccesos;
	}

	public void setUsuarioAccesos(List<UsuarioAcceso> usuarioAccesos) {
		this.usuarioAccesos = usuarioAccesos;
	}

	public UsuarioAcceso addUsuarioAcceso(UsuarioAcceso usuarioAcceso) {
		getUsuarioAccesos().add(usuarioAcceso);
		usuarioAcceso.setAcceso(this);

		return usuarioAcceso;
	}

	public UsuarioAcceso removeUsuarioAcceso(UsuarioAcceso usuarioAcceso) {
		getUsuarioAccesos().remove(usuarioAcceso);
		usuarioAcceso.setAcceso(null);

		return usuarioAcceso;
	}

}