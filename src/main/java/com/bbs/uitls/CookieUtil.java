package com.bbs.uitls;

import com.bbs.service.ISystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @description: cookie
 * @author: zhenglubo
 * @create: 2019-09-11 09:57
 **/

@Component
public class CookieUtil {

    @Autowired
    private ISystemConfigService systemConfigService;

    public void setCookie(String key, String value) {
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getResponse();
        Cookie cookie = new Cookie(key, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.valueOf(systemConfigService.selectAll().get("cookie_max_age").toString()));
        cookie.setDomain(systemConfigService.selectAll().get("cookie_domain").toString());
        assert response != null;
        response.addCookie(cookie);
    }

    public String getCookie(String name) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public void clearCookie(String name) {
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(-1);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setDomain(systemConfigService.selectAll().get("cookie_domain").toString());
        assert response != null;
        response.addCookie(cookie);
    }
}
