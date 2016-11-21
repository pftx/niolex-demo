/**
 * Main.java
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
package org.apache.niolex.spel.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author <a href="mailto:xiejiyun@foxmail.com">Xie, Jiyun</a>
 * @version 3.0.0
 * @since Nov 17, 2016
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> tags = new ArrayList<>();
        User u = new User();
        u.setAge(30);
        u.setName("Adla Jkon");
        u.setNation("Sebian");
        u.setTags(tags);
        tags.add(1);
        tags.add(2);
        tags.add(3);

        EvaluationContext context = new StandardEvaluationContext(u);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name matches '(\\w+ )?Jkon' && hasTag(2)");
        Boolean status = exp.getValue(context, Boolean.class);
        System.out.println("First eval = " + status);
    }

}
