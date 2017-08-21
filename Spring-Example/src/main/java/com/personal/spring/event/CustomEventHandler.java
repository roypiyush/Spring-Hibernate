package com.personal.spring.event;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println("Caught application custom event @ CustomEventHandler.onApplicationEvent(): " + event.toString());
	}

}
