package com.bbs.uitls;

import com.bbs.domain.User;
import com.bbs.service.ISystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description: session工具类
 * @author: zhenglubo
 * @create: 2019-09-11 14:30
 **/

@Component
public class SessionUtil {

    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private ISystemConfigService systemConfigService;

    public void doUserStorage(User user){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if (session != null) {
            session.setAttribute("user", user);
        }
        cookieUtil.setCookie(systemConfigService.selectAll().get("cookie_name").toString(),user.getToken());
    }
}
