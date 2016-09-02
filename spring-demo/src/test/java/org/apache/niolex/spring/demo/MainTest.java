package org.apache.niolex.spring.demo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.niolex.commons.net.HTTPResult;
import org.apache.niolex.commons.net.NetException;
import org.apache.niolex.commons.net.RESTClient;
import org.apache.niolex.commons.net.RESTResult;
import org.apache.niolex.spring.demo.vo.User;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainTest {

    RESTClient client = new RESTClient("http://localhost:8080", "utf8", 1000, 1000);

    @BeforeClass
    public static void setUp() {
        Main.main(new String[] { "hello" });
    }

    @Test
    public void testGet() throws NetException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Lex");
        HTTPResult result = client.get("users", params);

        assertEquals("We are in dev, Lex!", result.getRespBodyStr());
    }

    @Test
    public void testGet2() throws NetException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Andy");
        HTTPResult result = client.get("users", params);

        assertEquals("We are in dev, Andy!", result.getRespBodyStr());
    }

    @Test
    public void testPost() throws NetException, IOException {
        User params = new User();
        params.setUserName("Lex");
        params.setPosition("CEO");
        RESTResult<User> result = client.post("users", User.class, params);
        assertEquals(201, result.getRespCode());
        User r = result.getResponse();

        assertEquals("CEO", r.getPosition());
    }
}
