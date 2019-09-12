package com.bbs.interceptor;

import com.bbs.domain.User;
import com.bbs.service.ISystemConfigService;
import com.bbs.service.IUserService;
import com.bbs.uitls.CookieUtil;
import com.bbs.uitls.IpUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @description: 通用拦截器
 * @author: zhenglubo
 * @create: 2019-09-11 16:51
 **/

@Component
@Log4j2
public class CommonInterceptor implements HandlerInterceptor {

    @Autowired
    private CookieUtil cookieUtil;
    @Autowired
    private ISystemConfigService systemConfigService;
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        HttpSession session = request.getSession();
        session.setAttribute("_start", start);
        /*User user = (User) session.getAttribute("user");
        if (user == null) {
            String token = cookieUtil.getCookie(systemConfigService.selectAll().get("cookie_name").toString());
            if (StringUtils.isNotBlank(token)) {
                //根据token查询用户是否存在
                user = userService.selectByToken(token);
                if (user != null) {
                    // 用户存在写session，cookie然后给予通过
                    session.setAttribute("user", user);
                    cookieUtil.setCookie(systemConfigService.selectAll().get("cookie_name").toString(),user.getToken());
                }
            }
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpSession session = request.getSession();
        long start = (long) session.getAttribute("_start");
        String actionName = request.getRequestURI();
        String clientIp = IpUtil.getIpAddr(request);
        StringBuilder builder = new StringBuilder();
        builder.append(clientIp).append("|").append(actionName).append("|");
        Map<String, String[]> paramMap = request.getParameterMap();
        paramMap.forEach((key, value) -> {
            builder.append(key).append(" = ");
            for (String paramString : value) {
                builder.append(paramString);
            }
            builder.append("|");
        });
        builder.append("耗时：").append(System.currentTimeMillis() - start).append("ms");
        log.info(builder.toString());
    }
}
