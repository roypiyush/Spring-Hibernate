package com.personal.spring.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventDemoMain {

	public static void main(String[] args) {
		
		String[] configLocation = {"EventConfigBean.xml"};
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		CustomEventPublisher publisher = (CustomEventPublisher) context.getBean("customEventPublisher");
		publisher.publish();
	}

}
