package com.firstonesoft.mu.beans;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static ch.lambdaj.Lambda.sort;
import static org.hamcrest.Matchers.equalTo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.firstonesoft.mu.business.PerfilBL;
import com.firstonesoft.mu.model.Perfil;
import com.firstonesoft.utils.FacesUtil;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable {

	private static final long serialVersionUID = -8833644426472357294L;
	private static final Logger log = Logger.getLogger(PerfilBean.class);

	@Inject
	private PerfilBL perfilBL;

	private List<Perfil> listPerfiles;
	private Perfil perfil;
	private Boolean edit;

	@PostConstruct
	private void init() {
		try {
			nuevo();
			listPerfiles = perfilBL.getPerfiles();

		} catch (Exception e) {
			log.error("Error al cargar la vista", e);
		}
	}

	public void nuevo() {
		perfil = new Perfil();
		edit = false;
	}

	public void editar() {
		Long id = Long.parseLong(FacesUtil.getParameter("perfilId").toString());
		perfil = selectFirst(listPerfiles,
				having(on(Perfil.class).getPerfilId(), equalTo(id)));
		log.info("editando: " + perfil);
		edit = true;
	}

	public void guardar() {
		if (!edit) { // NUEVO
			try {
				perfil.setEstado(true);
				perfilBL.save(perfil);

				listPerfiles.add(perfil);
				listPerfiles = sort(listPerfiles, on(Perfil.class).getNombre());
				nuevo();

				log.info("Perfil guardado correctamente: " + perfil);
				FacesUtil.showMessage("Perfil guardado correctamente",
						FacesUtil.INFO);

			} catch (Exception e) {
				log.error("Error al guardar el perfil: " + perfil, e);
				FacesUtil.showMessage("Error al guardar el perfil",
						FacesUtil.ERROR);
			}

		} else { // EDITAR
			try {
				perfil.setEstado(true);
				perfilBL.update(perfil);

				nuevo();

				log.info("Perfil actualizado correctamente: " + perfil);
				FacesUtil.showMessage("Perfil actualizado correctamente",
						FacesUtil.INFO);

			} catch (Exception e) {
				log.error("Error al actualizar el perfil: " + perfil, e);
				FacesUtil.showMessage("Error al actualizar el perfil",
						FacesUtil.ERROR);
			}
		}
	}

	public void eliminar() {
		Long id = Long.parseLong(FacesUtil.getParameter("perfilId").toString());
		perfil = selectFirst(listPerfiles,
				having(on(Perfil.class).getPerfilId(), equalTo(id)));
		log.info("validar para eliminar: " + perfil);
		FacesUtil.showMessage(
				"No puede eliminar por que este perfil tiene Usuarios",
				FacesUtil.WARN);
	}

	/**
	 * VALIDACIONES
	 */
	public void validarNombre(FacesContext context, UIComponent validate, Object value) {
		((UIInput) validate).setValid(false);
		FacesUtil.showMessage("validarNombre", FacesUtil.ERROR);
	}

	/**
	 * GETTER AND SETTER
	 */
	public List<Perfil> getListPerfiles() {
		return listPerfiles;
	}

	public void setListPerfiles(List<Perfil> listPerfiles) {
		this.listPerfiles = listPerfiles;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Boolean getEdit() {
		return edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

}
