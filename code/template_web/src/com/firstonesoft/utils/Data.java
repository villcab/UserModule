package com.firstonesoft.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public abstract class Data {

	private static final Logger log = Logger.getLogger(Data.class);

	protected Connection connection;
	private Statement statement = null;
	private ResultSet result = null;

	public Data(Connection connection) {
		this.connection = connection;
	}

	@SuppressWarnings("unchecked")
	protected <T extends Entity> T search(String query) {
		ResultSet result = null;
		T entity = null;
		try {
			result = getList(query);
			while (result.next()) {
				entity = (T) this.loadEntity(result);
			}
			
		} catch (Exception e) {
			log.error("Error al ejecutar la consulta: " + query, e);
			
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					log.error("Error al cerrar la conexion del ResultSet", e);
				}
			}
		}
		return entity;
	}

	private ResultSet getList(String query) throws SQLException {
		statement = connection.createStatement();
		try {
			result = statement.executeQuery(query);
			
		} catch (Exception e) {
			log.error("Error al ejecutar la consulta: " + query, e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected <T extends Entity> List<T> list(String query) {
		List<T> Col = new ArrayList<T>();
		ResultSet result = null;
		try {
			result = getList(query);
			while (result.next()) {
				Col.add((T) this.loadEntity(result));
			}
			
		} catch (Exception e) {
			log.error("Error al ejecutar la consulta: " + query, e);
			
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					log.error("Error al cerrar la conexion del ResultSet", e);
				}
			}
		}
		return Col;
	}

	public Timestamp dateToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	public abstract <T extends Entity> T loadEntity(ResultSet result) throws IllegalArgumentException;

}
