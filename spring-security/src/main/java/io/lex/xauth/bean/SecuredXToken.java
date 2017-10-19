/**
 * SecuredXToken.java
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
package io.lex.xauth.bean;

import java.util.stream.Collectors;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 19, 2017
 */
public class SecuredXToken extends AbstractAuthenticationToken {

    /**
     * Generated UID.
     */
    private static final long serialVersionUID = 5599787261774529459L;
    private final XTokenPrincipal principal;
    private String credential;

    /**
     * Constructor
     * 
     * @param authorities
     */
    public SecuredXToken(XTokenPrincipal principal, String credential) {
        super(principal.getPermissionList().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        this.principal = principal;
        this.credential = credential;
        this.setAuthenticated(true);
    }

    /**
     * This is the override of super method.
     * 
     * @see org.springframework.security.core.Authentication#getCredentials()
     */
    @Override
    public String getCredentials() {
        return credential;
    }

    /**
     * This is the override of super method.
     * 
     * @see org.springframework.security.core.Authentication#getPrincipal()
     */
    @Override
    public XTokenPrincipal getPrincipal() {
        return principal;
    }

}
