package com.example.handler;

import cn.hutool.json.JSONUtil;
import com.example.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Slf4j
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //super.onAuthenticationFailure(request, response, exception);
        log.info("用户登录失败 - > {}", request.getAttribute("username"));
        log.info("失败异常信息：{}", exception.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        HashMap<String, Object> map = new HashMap<>();
        map.put("res",0);
        map.put("data", "账户密码错误或或账户被冻结");

        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(R.error().data(map)));

        writer.flush();
        writer.close();
    }
}
