/**
 * OAuthServer.java
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
package org.apache.niolex.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 16, 2017
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableResourceServer
public class OAuthServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OAuthServer.class, args);
        System.out.println("OAuthServer is Up!");
        System.out.println(Resources.toString(OAuthServer.class.getResource("/logo.txt"), Charsets.UTF_8));
    }

}
