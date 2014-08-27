package com.firstonesoft.mu.data;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;

import com.firstonesoft.utils.Data;
import com.firstonesoft.utils.Entity;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class DAcceso extends Data implements Serializable {

	public DAcceso(Connection connection) {
		super(connection);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public <T extends Entity> T loadEntity(ResultSet result) throws IllegalArgumentException {
		return null;
	}

}
