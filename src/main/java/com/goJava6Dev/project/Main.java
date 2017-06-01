package com.goJava6Dev.project;

import com.goJava6Dev.project.dao.DeveloperDao;
import com.goJava6Dev.project.dao.impl.DeveloperDaoImpl;
import com.goJava6Dev.project.model.Developer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Igor on 31.05.2017.
 */
public class Main {

    /*В констуктор фабрикы мы передаём класс в котором создаём логер*/
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static DeveloperDao developerDao = new DeveloperDaoImpl();

    public static void main(String[] args) {
        List<Developer> developers = developerDao.getAll();
        developers.forEach(System.out::println);
        int devId = 6;
        System.out.println("Dev with id: " + devId);
        System.out.println(developerDao.getDeveloperById(devId));
    }

}
