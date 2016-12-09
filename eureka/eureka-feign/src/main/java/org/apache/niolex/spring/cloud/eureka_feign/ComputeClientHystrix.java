/**
 * ComputeClientHystrix.java
 *
 * Copyright 2016 the original author or authors.
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
package org.apache.niolex.spring.cloud.eureka_feign;

import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:xiejiyun@foxmail.com">Xie, Jiyun</a>
 * @version 3.0.1
 * @since Dec 8, 2016
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    /**
     * This is the override of super method.
     * 
     * @see org.apache.niolex.spring.cloud.eureka_feign.ComputeClient#add(int, int)
     */
    @Override
    public Integer add(int a, int b) {
        return -999;
    }

}
