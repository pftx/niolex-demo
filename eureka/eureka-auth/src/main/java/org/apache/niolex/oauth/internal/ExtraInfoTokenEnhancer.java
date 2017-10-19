/**
 * ExtraInfoTokenEnhancer.java
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
package org.apache.niolex.oauth.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.google.common.collect.Lists;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 17, 2017
 */
public class ExtraInfoTokenEnhancer implements TokenEnhancer {
    private static final String EXTRA_INFO_KEY = "extension";

    /**
     * This is the override of super method.
     * @see org.springframework.security.oauth2.provider.token.TokenEnhancer#enhance(org.springframework.security.oauth2.common.OAuth2AccessToken, org.springframework.security.oauth2.provider.OAuth2Authentication)
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2ExtraInfo info = new OAuth2ExtraInfo();
        info.setAuthUserId(12345L);
        info.setOpUserId(101L);
        info.setOpAccountId(10001L);
        ArrayList<AccountInfo> list =
                Lists.newArrayList(new AccountInfo(1001L, "Demo Account"), new AccountInfo(1002L, "Test Account"));
        info.setAccountList(list);
        info.setPermissionList(Lists.newArrayList("SWITCH_ACCOUNT", "SEE_ADMIN_DATA", "WRITE", "READ"));
        return addExtraInfo(accessToken, info);
    }

    public static OAuth2AccessToken addExtraInfo(OAuth2AccessToken accessToken, OAuth2ExtraInfo info) {
        DefaultOAuth2AccessToken returnToken = new DefaultOAuth2AccessToken(accessToken);
        Map<String, Object> additionalInformation = new HashMap<>();
        additionalInformation.putAll(returnToken.getAdditionalInformation());
        additionalInformation.put(EXTRA_INFO_KEY, info);
        returnToken.setAdditionalInformation(additionalInformation);
        return returnToken;
    }

    public static OAuth2ExtraInfo extractExtraInfo(OAuth2AccessToken accessToken) {
        Object o = accessToken.getAdditionalInformation().get(EXTRA_INFO_KEY);
        if (o == null) {
            return new OAuth2ExtraInfo();
        }
        if (o instanceof OAuth2ExtraInfo) {
            return (OAuth2ExtraInfo) o;
        }
        return null;
    }

}
