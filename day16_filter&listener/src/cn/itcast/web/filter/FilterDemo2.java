package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo2 implements Filter {
    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法
     */
    public void destroy() {
    }

    /**
     * 每一次请求被拦截资源时，会执行
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo2....");
        //放行
        chain.doFilter(req, resp);

        System.out.println("filterDemo2回来了...");
    }

    /**
     * 在服务器启动后，会创建init对象，然后调用init方法
     * @param config
     * @throws ServletException
     */

    public void init(FilterConfig config) throws ServletException {

    }

}
