package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;

/*
 * 登录验证的过滤器
 * */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源的路径,要注意排除掉css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/")  || uri.contains("/js/")|| uri.contains("/font/")|| uri.contains("/checkCodeServlet")) {
            //包含，用户想登录，放行
            chain.doFilter(req, resp);
        } else {
            //不包含，判断用户是否登录
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //登录，放行
                chain.doFilter(req, resp);
            }else {
                //未登录，跳转登录页面
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
