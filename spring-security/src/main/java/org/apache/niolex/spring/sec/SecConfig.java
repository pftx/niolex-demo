/**
 * SecConfig.java
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
package org.apache.niolex.spring.sec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.lex.xauth.auth.XTokenAuthenticationProvider;
import io.lex.xauth.filter.XTokenAuthenticationFilter;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 18, 2017
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {

    @Value("${xtoken.authKey}")
    private String authKey;

    @Bean
    public XTokenAuthenticationProvider authenticationProvider() {
        return new XTokenAuthenticationProvider(authKey);
    }

    /**
     * This is the override of super method.
     * 
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable().authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(new XTokenAuthenticationFilter(), BasicAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider()).sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
    }

}
