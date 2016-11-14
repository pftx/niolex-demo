package org.ff4j.hello;

import org.ff4j.FF4j;

public class MyFF4jProvider implements org.ff4j.web.api.FF4JProvider {

	private final FF4j ff4j;

	public MyFF4jProvider() {
		ff4j = new FF4j("ff4j.xml");
	}

	/** {@inheritDoc} */
	public FF4j getFF4j() {
		return ff4j;
	}
	
}
