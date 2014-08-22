package com.firstonesoft.mu.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfil_acceso database table.
 * 
 */
@Entity
@Table(name="perfil_acceso")
@NamedQuery(name="PerfilAcceso.findAll", query="SELECT p FROM PerfilAcceso p")
public class PerfilAcceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERFIL_ACCESO_PERFILACCESOID_GENERATOR", sequenceName="PERFIL_ACCESO_PERFIL_ACCESO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERFIL_ACCESO_PERFILACCESOID_GENERATOR")
	@Column(name="perfil_acceso_id")
	private Long perfilAccesoId;

	//bi-directional many-to-one association to Acceso
	@ManyToOne
	@JoinColumn(name="acceso_id")
	private Acceso acceso;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil perfil;

	public PerfilAcceso() {
	}

	public Long getPerfilAccesoId() {
		return this.perfilAccesoId;
	}

	public void setPerfilAccesoId(Long perfilAccesoId) {
		this.perfilAccesoId = perfilAccesoId;
	}

	public Acceso getAcceso() {
		return this.acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}