/**
 * OAuth2ExtraInfo.java
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
package org.apache.niolex.oauth.internal;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 17, 2017
 */
@Data
public class OAuth2ExtraInfo implements Serializable {

    /**
     * Generated UID.
     */
    private static final long serialVersionUID = -1711096923761253417L;

    @JsonProperty("auth_user_id")
    private Long authUserId;

    @JsonProperty("op_user_id")
    private Long opUserId;

    @JsonProperty("op_account_id")
    private Long opAccountId;

    @JsonProperty("account_list")
    private List<AccountInfo> accountList;

    @JsonProperty("permission_list")
    private List<String> permissionList;

}
