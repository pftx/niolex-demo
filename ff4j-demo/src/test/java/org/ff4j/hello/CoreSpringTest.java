package org.ff4j.hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.ff4j.FF4j;
import org.ff4j.exception.FeatureNotFoundException;
import org.ff4j.hello.auth.CustomAuthorizationManager;
import org.ff4j.hello.service.GreetingService;
import org.ff4j.security.AuthorizationsManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CoreSpringTest {

	@Autowired
	private FF4j ff4j;

	@Autowired
	@Qualifier("greeting.english")
	private GreetingService greeting;

	@Test(expected=FeatureNotFoundException.class)
	public void testWithSpring() {
		// Test value at runtime
		if (ff4j.check("sayHelloNoWay")) {
			// Feature ok !
			System.out.println("Hello World !");
		} else {
			fail();
		}
	}

	@Test
	public void testAOP() {
		assertEquals("Hello CLU", greeting.sayHello("CLU"));
		ff4j.enable("language-french");
		assertEquals("Bonjour CLU", greeting.sayHello("CLU"));
	}

	@Test
	public void sampleSecurityTest() {
		// Add the Authorization Manager Filter
		AuthorizationsManager authManager = new CustomAuthorizationManager();
		ff4j.setAuthorizationsManager(authManager);
		// Given : Feature exist and enable
		assertTrue(ff4j.exist("sayHello"));
		assertTrue(ff4j.getFeature("sayHello").isEnable());
		// Unknow user does not have any permission => check is false
		CustomAuthorizationManager.currentUserThreadLocal.set("unknown-user");
		System.out.println(authManager.getCurrentUserPermissions());
		assertFalse(ff4j.check("sayHello"));
		assertFalse(ff4j.check("sayGoodBye"));
		
		// userB exist bit he has not role Admin
		CustomAuthorizationManager.currentUserThreadLocal.set("userB");
		System.out.println(authManager.getCurrentUserPermissions());
		assertFalse(ff4j.check("sayHello"));
		assertTrue(ff4j.check("sayGoodBye"));
		
		// userA is admin
		CustomAuthorizationManager.currentUserThreadLocal.set("userA");
		System.out.println(authManager.getCurrentUserPermissions());
		assertTrue(ff4j.check("sayHello"));
		assertTrue(ff4j.check("sayGoodBye"));
	}
}
