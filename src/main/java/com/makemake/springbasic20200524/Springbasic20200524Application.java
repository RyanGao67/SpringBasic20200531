package com.makemake.springbasic20200524;

import com.makemake.springbasic20200524.basic.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//The Spring container is at the core of the Spring Framework. The container will create the objects, wire them together, configure them, and manage their complete life cycle from creation till destruction. The Spring container uses DI to manage the components that make up an application. These objects are called Spring Beans, which we will discuss in the next chapter.
//
//The container gets its instructions on what objects to instantiate,
// configure, and assemble by reading the configuration metadata provided.
// The configuration metadata can be represented either by XML, Java
// annotations, or Java code. The following diagram represents a
// high-level view of how Spring works. The Spring IoC container makes
// use of Java POJO classes and configuration metadata to produce a fully
// configured and executable system or application.
// The ApplicationContext container includes all functionality of the
// BeanFactorycontainer, so it is generally recommended over BeanFactory.
// BeanFactory can still be used for lightweight applications like mobile
// devices or applet-based applications where data volume and speed is significant.

//this annotation automatically scan the package
@SpringBootApplication
public class Springbasic20200524Application {
	// $ to implement dependency injection, we need the following:
	// 1. what are the beans?
	// 2. what are the dependencies for the beans?
	// 3. where to search for beans?
	public static void main(String[] args) {
//		$ if we do not use dependency injection
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		ApplicationContext applicationContext = SpringApplication.run(Springbasic20200524Application.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
//      $ one example is binarySearch and binarySearch1 the same object
//		default is singleton: One instance per Spring Context
//		prototype - New Bean whenever requested
//		request - One bean per Http request
//		session - One bean per Http user session
//		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[]{12, 5}, 3);
		System.out.println(result);
	}
}
