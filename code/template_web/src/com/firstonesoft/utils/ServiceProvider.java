package com.firstonesoft.utils;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class ServiceProvider {
	
	private static BasicDataSource dataSource = null;
	private static Connection connection = null;
	
	private static String URL = Parameters.db_url;
	private static String DRIVER = Parameters.db_driver;
	private static String USERNAME = Parameters.db_username;
	private static String PASSWORD = Parameters.db_password;
	
	private static Integer MAX_ACTIVE = Parameters.db_max_active_connections;
	private static Integer MAX_CONNECTIONS = Parameters.db_max_connections;
	private static Integer MIN_CONNECTIONS = Parameters.db_min_connections;
	private static Integer TIME_OUT = Parameters.db_time_out;

	static {
		if (null == dataSource) {
			createDataSource();
		}
	}
	
	public static Connection getConnection() throws Exception {
		if (connection == null) {
			connection = dataSource.getConnection();
		} else {
			if (connection.isClosed()) {
				connection = dataSource.getConnection();
			}
		}
		return connection;
	}
	
	private static void createDataSource() {
		dataSource = new BasicDataSource();
		
		dataSource.setUrl(URL);
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		dataSource.setMaxActive(MAX_ACTIVE);
		dataSource.setMaxIdle(MAX_CONNECTIONS);
		dataSource.setMinIdle(MIN_CONNECTIONS);
		dataSource.setMaxWait(TIME_OUT);
		
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(20);
	}

}
