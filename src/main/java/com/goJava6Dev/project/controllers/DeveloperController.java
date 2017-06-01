package com.goJava6Dev.project.controllers;

import com.goJava6Dev.project.dao.DeveloperDao;
import com.goJava6Dev.project.model.Developer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Igor on 01.06.2017.
 */
public class DeveloperController {

    private PlatformTransactionManager txManager;
    private DeveloperDao developerDao;

    /*propagation - это правила по которым будет работать менеджер транзакций
    * Propagation.REQUIRED(ПО ДЕФОЛТУ) - это означает, что если в менеджере транзакций в момент входа в этот метод не будет существовать
    * транзакция, то она будет создана. Если она будет существовать, то будет использована
    * Propagation.REQUIRED_NEW - это означает, что при входе в этот метод ВСЕГДА будет создаваться НОВАЯ ТРАНЗАКЦИЯ
    * Propagation.MANDATORY - это означает, что если в момент входа в метод не будет найдено активных транзакций,
    * то этот метод бросит ошибку*/
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Developer> getAllDevelopers() {
        return developerDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Developer getDeveloperById(int id) {
        return developerDao.getDeveloperById(id);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDeveloperDao(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }
}
