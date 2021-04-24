package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         /*

            ServletContext���ܣ�
               1. ��ȡMIME���ͣ�

                2. ����󣺹�������
                3. ��ȡ�ļ�����ʵ(������)·��
         */

        // ͨ��HttpServlet��ȡ
        ServletContext context = this.getServletContext();


        // ��ȡ�ļ��ķ�����·��
        String b = context.getRealPath("/b.txt");//webĿ¼����Դ����
        System.out.println(b);
        // File file = new File(realPath);

        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INFĿ¼�µ���Դ����
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//srcĿ¼�µ���Դ����
        System.out.println(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}