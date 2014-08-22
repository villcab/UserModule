package com.firstonesoft.mu.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_acceso database table.
 * 
 */
@Entity
@Table(name="usuario_acceso")
@NamedQuery(name="UsuarioAcceso.findAll", query="SELECT u FROM UsuarioAcceso u")
public class UsuarioAcceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ACCESO_USUARIOACCESOID_GENERATOR", sequenceName="USUARIO_ACCESO_USUARIO_ACCESO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ACCESO_USUARIOACCESOID_GENERATOR")
	@Column(name="usuario_acceso_id")
	private Long usuarioAccesoId;

	//bi-directional many-to-one association to Acceso
	@ManyToOne
	@JoinColumn(name="acceso_id")
	private Acceso acceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public UsuarioAcceso() {
	}

	public Long getUsuarioAccesoId() {
		return this.usuarioAccesoId;
	}

	public void setUsuarioAccesoId(Long usuarioAccesoId) {
		this.usuarioAccesoId = usuarioAccesoId;
	}

	public Acceso getAcceso() {
		return this.acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}