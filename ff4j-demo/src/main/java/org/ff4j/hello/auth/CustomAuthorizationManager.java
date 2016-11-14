package org.ff4j.hello.auth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.ff4j.security.AbstractAuthorizationManager;

public class CustomAuthorizationManager extends AbstractAuthorizationManager {
	public static ThreadLocal<String> currentUserThreadLocal = new ThreadLocal<String>();
	private static final Map<String, Set<String>> permissions = new HashMap<String, Set<String>>();
	
	static {
		permissions.put("userA", new HashSet<String>(Arrays.asList("user", "admin", "beta")));
		permissions.put("userB", new HashSet<String>(Arrays.asList("user")));
		permissions.put("userC", new HashSet<String>(Arrays.asList("user", "beta")));
	}

	/** {@inheritDoc} */
	@Override
	public Set<String> getCurrentUserPermissions() {
		String currentUser = currentUserThreadLocal.get();
		return permissions.containsKey(currentUser) ? permissions.get(currentUser) : new HashSet<String>();
	}

	/** {@inheritDoc} */
	@Override
	public Set<String> listAllPermissions() {
		Set<String> allPermissions = new HashSet<String>();
		for (Set<String> subPersmission : permissions.values()) {
			allPermissions.addAll(subPersmission);
		}
		return allPermissions;
	}

}
