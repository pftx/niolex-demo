package org.apache.niolex.spel;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Hello world!
 *
 */
public class App {
    
    @Data
    @AllArgsConstructor
    public static final class Inventor {
        private String name;
        private Date birth;
        private String nation;
    }
    
    public static void main(String[] args) {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor(new String("Nikola Tesla"), c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name1 = (String) exp.getValue(context);
        String name2 = (String) exp.getValue(tesla);
        
        System.out.println(name1);
        System.out.println(name2);
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "lex");
        Expression exp3 = parser.parseExpression("[name]");
        String name3 = (String) exp3.getValue(map);
        System.out.println(name3);
        
        Expression exp2 = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp2.getValue(context, Boolean.class); // evaluates to true
        System.out.println(result);
    }
}
