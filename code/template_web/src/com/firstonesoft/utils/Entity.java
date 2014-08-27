package com.firstonesoft.utils;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Entity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Entity.class);

	private Action action = Action.None;

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@SuppressWarnings("unchecked")
	public <T extends Entity> T getClone() {
		Entity obj = null;
		try {
			obj = (Entity) super.clone();
			
		} catch (CloneNotSupportedException e) {
			log.error("Error al clonar la Entidad: " + obj, e);
		}
		return (T) obj;
	}
}
