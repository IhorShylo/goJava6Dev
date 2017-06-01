package com.goJava6Dev.project.dao.impl;

import com.goJava6Dev.project.dao.DeveloperDao;
import com.goJava6Dev.project.model.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 01.06.2017.
 */
public class DeveloperDaoImpl implements DeveloperDao {
    private static final Logger log = LoggerFactory.getLogger(DeveloperDaoImpl.class);

    public static final String GET_ALL_QUERY = "SELECT * FROM developers";
    public static final String GET_BY_ID = "SELECT * FROM developers WHERE developer_id = ?";

    private DataSource dataSource;

/*ДАО методы по работе с бд лучше применять propagation = Propagation.MANDATORY
* Это связано с тем, что этот метод, это мельчайшая точка взаимодействия с БД и к моменту обращения к ней
* с более "высокого слоя"(к примеру слой сервисов или контроллеров), транзакция уже должна будет быть открытой*/
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Developer> getAll() {
        List<Developer> devList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(GET_ALL_QUERY);

            while (rs.next()) {
                Developer developer = createDeveloper(rs);
                devList.add(developer);
            }

        } catch (SQLException e) {
            log.error("Can't get a connection from", e);
            throw new RuntimeException(e);
        }
        return devList;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Developer getDeveloperById(int id) {

        try (Connection connection = dataSource.getConnection();
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
            log.error("Can't get a connection", e);
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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
