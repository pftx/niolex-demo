package io.lex.xauth.auth;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import io.lex.xauth.bean.SecuredXToken;
import io.lex.xauth.bean.XTokenPrincipal;

public class XTokenUtilTest {

    @Test
    public void testVerifyStr() throws Exception {
        XTokenPrincipal p = new XTokenPrincipal();
        p.setOpAccountId(123L);
        p.setOpUserId(123456L);
        p.setUserId(1L);
        p.setUserName("user");
        p.setPermissionList(Lists.newArrayList("ADMIN", "READ"));
        SecuredXToken x = new SecuredXToken(p, "9d0500");
        String s = XTokenUtil.encodeToken(x, "Lippolis");
        System.out.println(s);
        System.out.println(XTokenUtil.plainStr(s));

        SecuredXToken dx = XTokenUtil.decodeToken(s, "Lippolis");
        Assert.assertEquals(x, dx);
    }

    @Test
    public void testGenerateMap() throws Exception {
        for (long seed = 23349001; seed < 23349101; ++seed) {
            char[] map1 = XTokenUtil.generateMap(seed);
            char[] map2 = XTokenUtil.generateMap(seed);
            Assert.assertArrayEquals(map1, map2);
        }
    }

}
