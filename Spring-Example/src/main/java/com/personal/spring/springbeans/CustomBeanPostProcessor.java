package com.personal.spring.springbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println(String.format("inside postProcessBeforeInitialization Bean Name: %s, Bean Object: %s", beanName, bean));
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(String.format("inside postProcessAfterInitialization Bean Name: %s, Bean Object: %s", beanName, bean));
		
		return bean;
	}

}
