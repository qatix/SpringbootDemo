package com.qatix.hello.filter;

import com.qatix.hello.core.CommonUtil;
import com.qatix.hello.core.CommonUtil;
import com.qatix.hello.core.MythreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Component
@WebFilter(urlPatterns = "/user/*", filterName = "sessionFilter")
public class SessionFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getParameter("token");
        String url = request.getServletPath();

        logger.info("req url:" + url);

        if (url.contains("/user/login") ||
                url.contains("/user/reg")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (token != null) {
                Map map = (Map) CommonUtil.cache.get(token);
                MythreadLocal.set("session", map);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                PrintWriter writer = servletResponse.getWriter();
                writer.write("{code:401}");
                writer.close();
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
