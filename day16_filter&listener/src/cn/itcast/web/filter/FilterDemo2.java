package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo2 implements Filter {
    /**
     * �ڷ������رպ�Filter�������١�����������������رգ����ִ��destroy����
     */
    public void destroy() {
    }

    /**
     * ÿһ������������Դʱ����ִ��
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo2....");
        //����
        chain.doFilter(req, resp);

        System.out.println("filterDemo2������...");
    }

    /**
     * �ڷ����������󣬻ᴴ��init����Ȼ�����init����
     * @param config
     * @throws ServletException
     */

    public void init(FilterConfig config) throws ServletException {

    }

}
