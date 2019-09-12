package com.bbs.interceptor;

import com.bbs.domain.User;
import com.bbs.service.ISystemConfigService;
import com.bbs.service.IUserService;
import com.bbs.uitls.CookieUtil;
import com.bbs.uitls.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 用户登录拦截器
 * @author: zhenglubo
 * @create: 2019-09-11 09:43
 **/


@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private ISystemConfigService systemConfigService;
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            String token = cookieUtil.getCookie(systemConfigService.selectAll().get("cookie_name").toString());
            if (StringUtils.isNotBlank(token)) {
                user = userService.selectByToken(token);
                session.setAttribute("user", user);
            }
        }
        if (user == null) {
            HttpUtil.responseWrite(request, response);
            return false;
        } else {
            return true;
        }
    }
}
