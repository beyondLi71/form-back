package com.bgy.common.utils.cookie;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yyg
 * @date 2018/4/23 22:37
 * @desc token 创建工具类
 */
public class CookieUtils {

    @Value("${key}")
    String key;

    /***
     * 生成uuid的token
     * @return
     */
    public static String getUUToken() {
        String token = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return token;
    }

    /**
     * 把token 保存在cookie里
     *
     * @param toekn
     * @param response
     */
    public static void setTokenCookie(String key, String toekn, Integer outTime, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, toekn);
        cookie.setMaxAge(outTime);
        cookie.setDomain("");
        cookie.setPath("/");
        response.addCookie(cookie);
        response.setHeader("P3P", "CP='CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR'");
    }


    /**
     * 讲cookie用K,V存储
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 删除制定的cookie
     *
     * @param request
     * @param response
     * @param deleteKey
     * @throws NullPointerException
     */
    public static void delectCookieByName(HttpServletRequest request, HttpServletResponse response, String deleteKey) throws NullPointerException {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        for (String key : cookieMap.keySet()) {
            if (key.equals(deleteKey)) {
                Cookie cookie = cookieMap.get(key);
                //设置cookie有效时间为0
                cookie.setMaxAge(0);
                //不设置存储路径
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }
}
