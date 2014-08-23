package com.firstonesoft.utils;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class Parameters {

    protected final static String configFile = "web_mu.properties";
    private static final Logger log = Logger.getLogger(Parameters.class);

    static {
	init();
    }

    public static String db_url;
    public static String db_driver;
    public static String db_username;
    public static String db_password;
    public static Integer db_max_active_connections;
    public static Integer db_max_connections;
    public static Integer db_min_connections;
    public static Integer db_time_out;

    public static void init() {
	try {
	    ResourceBundle rb = ResourceBundle.getBundle(configFile);

	    db_url = rb.getString("db.url");
	    db_driver = rb.getString("db.driver");
	    db_username = rb.getString("db.username");
	    db_password = rb.getString("db.password");
	    db_max_active_connections = Integer.parseInt(rb.getString("db.maxActiveConnections"));
	    db_max_connections = Integer.parseInt(rb.getString("db.maxConnections"));
	    db_min_connections = Integer.parseInt(rb.getString("db.minConnections"));
	    db_time_out = Integer.parseInt(rb.getString("db.timeOut"));

	} catch (Exception e) {
	    log.error("Fallo cargar el archivo de propiedades: " + configFile, e);
	}
    }
}
