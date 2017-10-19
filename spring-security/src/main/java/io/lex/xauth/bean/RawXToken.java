/**
 * RawXToken.java
 *
 * Copyright 2017 the original author or authors.
 *
 * We licenses this file to you under the Apache License, version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.lex.xauth.bean;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * The value object to save raw X-Token.
 * 
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 19, 2017
 */
public class RawXToken extends AbstractAuthenticationToken {

    /**
     * Generated UID.
     */
    private static final long serialVersionUID = 1275194991068796815L;
    private final Object principal;
    private Object credentials;

    /**
     * Construct a raw X-Token with the token value saved as principal.
     * 
     * @param principal the token value
     */
    public RawXToken(Object principal) {
        super(null);
        this.principal = principal;
        this.credentials = "Not Available";
        setAuthenticated(false);
    }

    /**
     * This is the override of super method.
     * 
     * @see org.springframework.security.core.Authentication#getCredentials()
     */
    @Override
    public Object getCredentials() {
        return credentials;
    }

    /**
     * This is the override of super method.
     * @see org.springframework.security.core.Authentication#getPrincipal()
     */
    @Override
    public Object getPrincipal() {
        return principal;
    }

}
