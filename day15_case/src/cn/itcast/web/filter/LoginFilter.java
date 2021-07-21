package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;

/*
 * ��¼��֤�Ĺ�����
 * */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //ǿ��ת��
        HttpServletRequest request = (HttpServletRequest) req;

        //1.��ȡ��Դ����·��
        String uri = request.getRequestURI();
        //2.�ж��Ƿ������¼�����Դ��·��,Ҫע���ų���css/js/ͼƬ/��֤�����Դ
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/")  || uri.contains("/js/")|| uri.contains("/font/")|| uri.contains("/checkCodeServlet")) {
            //�������û����¼������
            chain.doFilter(req, resp);
        } else {
            //���������ж��û��Ƿ��¼
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //��¼������
                chain.doFilter(req, resp);
            }else {
                //δ��¼����ת��¼ҳ��
                request.setAttribute("login_msg","����δ��¼�����¼");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
