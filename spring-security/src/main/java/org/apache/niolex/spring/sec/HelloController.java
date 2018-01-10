/**
 * HelloController.java
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

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:pftx@live.com">Lex Xie</a>
 * @version 1.0.0
 * @since Oct 18, 2017
 */
@RestController
public class HelloController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "Hello";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String admin() {
        return "Hello admin!";
    }

    @RequestMapping(value = "/root", method = RequestMethod.GET)
    @PreAuthorize("authentication.isRoot()")
    public String root() {
        return "Hello root!";
    }

    @RequestMapping(value = "/param", method = RequestMethod.GET)
    @PreAuthorize("authentication.isRoot(#p)")
    public String param(@RequestParam("p") String p) {
        return "Hello " + p;
    }

}
