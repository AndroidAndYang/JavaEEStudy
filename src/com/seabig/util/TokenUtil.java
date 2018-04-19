package com.seabig.util;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author: YJZ
 * data: 2018/4/19.
 * des: 令牌工具类
 */
public class TokenUtil {

    private static final String TOKEN_NAME = "TOKEN_IN_SESSION";

    public static String createToken(HttpServletRequest httpServletRequest) {
        // 获取UUID随机数
        String uuid = UUID.randomUUID().toString();
        // 设置随机数为session
        httpServletRequest.getSession().setAttribute(TOKEN_NAME, uuid);
        return uuid;
    }

    public static boolean checkToken(HttpServletRequest httpServletRequest, String uuid) {
        String tokenInSession = (String) httpServletRequest.getSession().getAttribute(TOKEN_NAME);
        if (uuid.equals(tokenInSession)) {
            httpServletRequest.getSession().removeAttribute(TOKEN_NAME);
            return true;
        }
        return false;
    }
}
