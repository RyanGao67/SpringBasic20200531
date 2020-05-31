package com.makemake.springbasic20200524.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
// Spring framework introduce the concept of dependency injection
// it also introduced ioc container
// CDI tries to standardized these as part of the java EE, CDI is like a interface defining the annotation
//@inject  this is the annotation needs to be used(@Autowired)
//@named   this is the annotation needs to be used(@Component&@Qualifier)
//@Singletion  this is the annotation needs to be used(Defines a scope of Singleton)
// the CDI framework will provide the functionality
// it is like
// JPA it is a interface java persistence api
// hibernate  understand the apis defined by JPA and provide the implementation for that
// similarly, CDI is the interface defining how to do the dependency injection
// the comparable spring annotation for CDI @named is @Component
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SortAlgorithm sortAlgorithm;
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] nums, int numberToSearchFor){
        //Sorting an array
        int[] sortedNumbers = sortAlgorithm.sort(nums);
        //Search the array
        // Return the result
        System.out.println(sortAlgorithm);

        return 3;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("postConstruct");
    }
    @PreDestroy
    public void preDestroy(){
        logger.info("preDesdroy");
    }
}
