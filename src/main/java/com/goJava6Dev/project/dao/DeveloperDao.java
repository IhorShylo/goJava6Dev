package com.goJava6Dev.project.dao;

import com.goJava6Dev.project.model.Developer;

import java.util.List;

/**
 * Created by Igor on 01.06.2017.
 */
public interface DeveloperDao {

    List<Developer> getAll();

    Developer getDeveloperById(int id);
}
