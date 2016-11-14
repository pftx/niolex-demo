package org.ff4j.hello.service.impl;

import org.ff4j.hello.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("greeting.english")
public class GreetingServiceEnglishImpl implements GreetingService {
	
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
}
