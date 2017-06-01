package com.goJava6Dev.project;

import com.goJava6Dev.project.dao.DeveloperDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Igor on 31.05.2017.
 */
public class Main {

    /*В констуктор фабрикы мы передаём класс в котором создаём логер*/
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private DeveloperDao developerDao;

    private static final String CTX_PATH = "application-context.xml";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(CTX_PATH);
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        developerDao.getAll().forEach(System.out::println);
        int devId = 6;
        System.out.println("Dev with id: " + devId);
        System.out.println(developerDao.getDeveloperById(devId));
    }

    public void setDeveloperDao(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }
}
