package com.goJava6Dev.project.dao.impl;

import com.goJava6Dev.project.dao.DeveloperDao;
import com.goJava6Dev.project.model.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 01.06.2017.
 */
public class DeveloperDaoImpl implements DeveloperDao {
    private static final Logger log = LoggerFactory.getLogger(DeveloperDaoImpl.class);

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/goJava6_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "80509167251";
    public static final String GET_ALL_QUERY = "SELECT * FROM developers";
    public static final String GET_BY_ID = "SELECT * FROM developers WHERE developer_id = ?";


    @Override
    public List<Developer> getAll() {
        List<Developer> devList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(GET_ALL_QUERY);

            while (rs.next()) {
                Developer developer = createDeveloper(rs);
                devList.add(developer);
            }

        } catch (SQLException e) {
            log.error("Can't get a connection from url -> " + JDBC_URL, e);
            throw new RuntimeException(e);
        }
        return devList;
    }

    @Override
    public Developer getDeveloperById(int id) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return createDeveloper(rs);
            } else {
                log.error("Can't find developer with id -> " + id);
                throw new RuntimeException("Can't find developer with id -> " + id);
            }

        } catch (SQLException e) {
            log.error("Can't get a connection from url -> " + JDBC_URL, e);
            throw new RuntimeException(e);
        }
    }

    private Developer createDeveloper(ResultSet rs) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getInt("developer_id"));
        developer.setFirstName(rs.getString("first_name"));
        developer.setLastName(rs.getString("last_name"));
        developer.setAge(rs.getInt("age"));
        developer.setSalary(rs.getDouble("salary"));
        return developer;
    }
}
