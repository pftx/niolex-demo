/**
 * UserController.java
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
package org.apache.niolex.spring.demo.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.niolex.spring.demo.vo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:xiejiyun@foxmail.com">Xie, Jiyun</a>
 * @version 0.6.1
 * @since Aug 12, 2016
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final AtomicLong userIdGen = new AtomicLong();
    private ConcurrentMap<Long, User> userStore = new ConcurrentHashMap<Long, User>();

    @Value("${common.greeting:Welcome to use REST, %s.}")
    private String greeting = "Hi, %s!";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(greeting, name);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User u) {
        if (u.getUserName() == null) {
            throw new IllegalArgumentException("User Name should not be null.");
        }
        long userId = userIdGen.incrementAndGet();
        u.setUserId(userId);
        userStore.put(userId, u);

        return u;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long userId) {
        return userStore.get(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public User getUser(@PathVariable Long userId, @RequestBody User u) {
        if (u.getUserName() == null) {
            throw new IllegalArgumentException("User Name should not be null.");
        }
        u.setUserId(userId);
        return userStore.replace(userId, u);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long userId) {
        return userStore.remove(userId);
    }

}
