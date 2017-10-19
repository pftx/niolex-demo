/**
 * FeignRelayAuthRequestInterceptor.java
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
package org.apache.niolex.spring.cloud.eureka_feign;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 18, 2017
 */
public class FeignRelayAuthRequestInterceptor implements RequestInterceptor {

    private static final HystrixRequestVariableDefault<String> tokenContainer = new HystrixRequestVariableDefault<>();

    public static void putToken(String token) {
        tokenContainer.set(token);
        System.out.println("Token " + token + " set from thread = " + Thread.currentThread().getId());
    }

    /**
     * This is the override of super method.
     * 
     * @see feign.RequestInterceptor#apply(feign.RequestTemplate)
     */
    @Override
    public void apply(RequestTemplate template) {
        String token = tokenContainer.get();
        System.out.println("Token " + token + " used from thread = " + Thread.currentThread().getId());
        template.header("Authorization", token);
    }

}
