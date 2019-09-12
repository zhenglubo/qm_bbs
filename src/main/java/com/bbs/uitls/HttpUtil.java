package com.bbs.uitls;

import com.alibaba.fastjson.JSON;
import com.bbs.result.DataResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: HttpUtil
 * @author: zhenglubo
 * @create: 2019-09-11 17:49
 **/

public class HttpUtil {

    public static void responseWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        DataResult<Object> result = new DataResult<>();
        result.setStatus(400);
        result.setInfo("请先登录");
        result.setMessage("请先登录");
        result.setData(null);
        response.getWriter().write(JSON.toJSONString(result));
    }
}
