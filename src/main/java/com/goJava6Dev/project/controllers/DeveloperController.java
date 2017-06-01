package com.goJava6Dev.project.controllers;

import com.goJava6Dev.project.dao.DeveloperDao;
import com.goJava6Dev.project.model.Developer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import java.util.List;

/**
 * Created by Igor on 01.06.2017.
 */
public class DeveloperController {

    private PlatformTransactionManager txManager;
    private DeveloperDao developerDao;

    public List<Developer> getAllDevelopers() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute
                (TransactionDefinition.PROPAGATION_REQUIRED));

        try{
            List<Developer> result = developerDao.getAll();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException(e);
        }

    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDeveloperDao(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }
}
