package io.muic.ooc.webapp.service;

import com.zaxxer.hikari.HikariDataSource;
import io.muic.ooc.webapp.config.ConfigProperties;
import io.muic.ooc.webapp.config.ConfigurationLoader;

import java.sql.Connection;

import java.sql.SQLException;

public class DatabaseConnectionService {

    private final HikariDataSource ds;

    private static DatabaseConnectionService service;

    /**
     * Database connection pool using hikari libary
     */

    private DatabaseConnectionService() {
        ds = new HikariDataSource();
        ds.setMaximumPoolSize(20);
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        // TODO: these are hard code so it's not convenient and insecured.
        // change to use configuration file or environment variable

        ConfigProperties configProperties = ConfigurationLoader.load();
        if(configProperties == null){
            throw new RuntimeException("Unable to read the config.properties.");
        }
        ds.setDriverClassName(configProperties.getDatabaseDriverClassName());
        ds.setJdbcUrl(configProperties.getDatabaseConnectionUrl());
        ds.addDataSourceProperty("user",configProperties.getDatabaseUsername());
        ds.addDataSourceProperty("password",configProperties.getDatabasePassword());
        ds.setAutoCommit(false);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DatabaseConnectionService getInstance(){
        if(service == null){
            service = new DatabaseConnectionService();

        }
        return service;
    }

}
