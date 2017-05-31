package com.goJava6Dev.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Igor on 31.05.2017.
 */
public class Main {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/goJava6_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "80509167251";

    /*В констуктор фабрикы мы передаём класс в котором создаём логер*/
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        getConnection();
    }

    private static void getConnection() {
        log.info("Getting connection from url -> " + JDBC_URL);
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            log.info("Connection received  -> " + connection);
        } catch (SQLException e) {
            log.error("Can't get a connection from url -> " + JDBC_URL);
            throw new RuntimeException(e);

        }
    }
}
