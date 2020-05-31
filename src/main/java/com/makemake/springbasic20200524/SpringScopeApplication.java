package com.makemake.springbasic20200524;

import com.makemake.springbasic20200524.basic.BinarySearchImpl;
import com.makemake.springbasic20200524.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//this annotation automatically scan the package
@SpringBootApplication
@ComponentScan("com.makemake.springbasic20200524") // default
public class SpringScopeApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(SpringScopeApplication.class);
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Springbasic20200524Application.class, args);
        PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
        PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
        LOGGER.info("{}", personDAO);
        LOGGER.info("{}", personDAO.getJdbcConnection());// jdbc 1
        LOGGER.info("{}", personDAO.getJdbcConnection());// jdbc 2
        LOGGER.info("{}", personDao2);
        LOGGER.info("{}", personDao2.getJdbcConnection());// jdbc 3
    }
}
