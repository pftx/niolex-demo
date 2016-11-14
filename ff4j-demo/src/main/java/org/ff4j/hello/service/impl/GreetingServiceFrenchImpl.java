package org.ff4j.hello.service.impl;

import org.ff4j.hello.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("greeting.french")
public class GreetingServiceFrenchImpl implements GreetingService {
	
	public String sayHello(String name) {
		return "Bonjour " + name;
	}
	
}
