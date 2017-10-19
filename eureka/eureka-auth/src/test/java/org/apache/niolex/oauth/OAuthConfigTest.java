package org.apache.niolex.oauth;

import java.security.SecureRandom;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class OAuthConfigTest {

    @Test
    public void testPasswordEncoder() throws Exception {
        PasswordEncoder pe = new BCryptPasswordEncoder(12, SecureRandom.getInstanceStrong());
        System.out.println(pe.encode("root"));
    }

}
