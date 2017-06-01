package com.goJava6Dev.project;

import com.goJava6Dev.project.controllers.DeveloperController;
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

    private DeveloperController developerController;

    private static final String CTX_PATH = "application-context.xml";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(CTX_PATH);
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
//        System.out.println("All developers:");
//        developerController.getAllDevelopers().forEach(System.out::println);
        int devId = 6;
        System.out.println("Developer with id = " + devId + ":");
        System.out.println(developerController.getDeveloperById(devId));
    }

    public void setDeveloperController(DeveloperController developerController) {
        this.developerController = developerController;
    }
}
