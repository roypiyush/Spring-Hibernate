package com.personal.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.personal.spring.config.AppConfig;
import com.personal.spring.interfaces.IOutputGenerator;
import com.personal.spring.springbeans.HelloWorld;
import com.personal.spring.springbeans.impl.OutputHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	String[] configLocations = {"SpringBeans.xml"};
    	
//    	Resource resource = new FileSystemResource("src\\main\\resources\\" + configLocations[0]);
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(configLocations[0]));
    	ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
 
//		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		HelloWorld obj = (HelloWorld) beanFactory.getBean("helloBean");
		obj.printHello();
		System.out.println("Hello world object : " + obj.hashCode());
		HelloWorld obj1 = (HelloWorld) beanFactory.getBean("helloBean");
		System.out.println("Hello world object : " + obj1.hashCode());
		
		System.out.println("Manual Hello world object : " + new HelloWorld("Piyush Roy").hashCode());
		System.out.println("Manual Hello world object : " + new HelloWorld("Piyush Roy").hashCode());
		
		OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
    	output.generateOutput();
    	((AbstractApplicationContext) context).registerShutdownHook();
    	
    	context = new AnnotationConfigApplicationContext(AppConfig.class);
    	IOutputGenerator helper = (IOutputGenerator) context.getBean("CsvOutputHelper");
    	helper.generateOutput();
    	
    	
    	
    }
}
