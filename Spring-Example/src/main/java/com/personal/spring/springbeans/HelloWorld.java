package com.personal.spring.springbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HelloWorld {
	private String name;

	public HelloWorld() {
	}
	
	public HelloWorld(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Spring 3 : Hello ! " + name);
	}
	
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("Init method using @PostConstruct");
	}
 
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Destroy method using @PreDestroy");
	}
	
	public void initMethod() {
		System.out.println("Bean is initialized.");
	}
	
	public void destroyMethod() {
		System.out.println("Bean is destroyed.");
	}
}