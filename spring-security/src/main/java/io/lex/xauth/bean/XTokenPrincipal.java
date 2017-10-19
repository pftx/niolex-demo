/**
 * XTokenPrincipal.java
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

import java.security.Principal;
import java.util.List;

import lombok.Data;

/**
 * The X-Token Principal.
 * 
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 19, 2017
 */
@Data
public class XTokenPrincipal implements Principal {

    private String userName;
    private Long userId;
    private Long opUserId;
    private Long opAccountId;
    private List<String> permissionList;

    /**
     * This is the override of super method.
     * @see java.security.Principal#getName()
     */
    @Override
    public String getName() {
        return userName;
    }

}
