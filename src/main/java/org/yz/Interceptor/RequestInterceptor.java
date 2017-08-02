package org.yz.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yz.domain.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 张鹏程 on 2017/6/22.
 */
@Component
public class RequestInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
        System.out.println(request.getRequestURI() + "被调用……");
        Object obj = request.getSession().getAttribute("cur_user");
        if (obj == null || !(obj instanceof Account)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(httpServletRequest.getRequestURI() + "完成调用……");
    }

}
