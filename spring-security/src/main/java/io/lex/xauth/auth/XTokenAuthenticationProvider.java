/**
 * XTokenAuthenticationProvider.java
 *
 * Copyright 2017 the original author or authors.
 *
 * We licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.lex.xauth.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import io.lex.xauth.bean.RawXToken;

/**
 * Decode X-Token and verify it's credentials.
 * 
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 19, 2017
 */
public class XTokenAuthenticationProvider implements AuthenticationProvider {

    private final String authenticationKey;

    /**
     * Constructor
     * 
     * @param authenticationKey the key used to verify X-Token
     */
    public XTokenAuthenticationProvider(String authenticationKey) {
        super();
        this.authenticationKey = authenticationKey;
    }

    /**
     * This is the override of super method.
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            RawXToken x = (RawXToken) authentication;
            return XTokenUtil.decodeToken(x.getName(), authenticationKey);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Invalid X-Token.", e);
        }
    }

    /**
     * This is the override of super method.
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (RawXToken.class.isAssignableFrom(authentication));
    }

}
