package org.apache.niolex.spring.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.niolex.commons.net.HTTPResult;
import org.apache.niolex.commons.net.NetException;
import org.apache.niolex.commons.net.RESTClient;
import org.apache.niolex.commons.net.RESTResult;
import org.apache.niolex.commons.test.OrderedRunner;
import org.apache.niolex.spring.demo.vo.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(OrderedRunner.class)
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
        assertEquals(1, r.getUserId());
    }

    @Test
    public void testPost2() throws NetException, IOException {
        User params = new User();
        params.setUserName("Andy");
        params.setPosition("SSE");
        RESTResult<User> result = client.post("users", User.class, params);
        assertEquals(201, result.getRespCode());
        User r = result.getResponse();

        assertEquals("SSE", r.getPosition());
        assertEquals(2, r.getUserId());
    }

    @Test
    public void testRetrieve() throws NetException, IOException {
        RESTResult<User> result = client.get("/users/1", User.class, null);
        assertEquals(200, result.getRespCode());
        User r = result.getResponse();

        assertEquals("CEO", r.getPosition());
        assertEquals("Lex", r.getUserName());
        assertEquals(1, r.getUserId());
    }

    @Test
    public void testRetrieveUpdate() throws NetException, IOException {
        User params = new User();
        params.setUserName("Lily");
        params.setPosition("CFO");

        RESTResult<User> result = client.put("/users/1", User.class, params);
        assertEquals(200, result.getRespCode());
        User r = result.getResponse();

        assertEquals("CEO", r.getPosition());
        assertEquals(1, r.getUserId());
    }

    @Test
    public void testRetrieveZZZ() throws NetException, IOException {
        RESTResult<User> result = client.get("/users/1", User.class, null);
        assertEquals(200, result.getRespCode());
        User r = result.getResponse();

        assertEquals("CFO", r.getPosition());
        assertEquals("Lily", r.getUserName());
        assertEquals(1, r.getUserId());
    }

    @Test
    public void testZDel() throws NetException, IOException {
        RESTResult<User> result = client.delete("/users/2", User.class, null);

        assertEquals(200, result.getRespCode());
        User r = result.getResponse();

        assertEquals("SSE", r.getPosition());
        assertEquals("Andy", r.getUserName());
        assertEquals(2, r.getUserId());
    }

    @Test
    public void testZRetrieve() throws NetException, IOException {
        HTTPResult result = client.get("/users/2", null);
        assertEquals(200, result.getRespCode());
        assertNull(result.getRespBody());
    }

}
