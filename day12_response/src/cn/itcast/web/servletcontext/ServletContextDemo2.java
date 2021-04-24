package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*

            ServletContext���ܣ�
               1. ��ȡMIME���ͣ�
                * MIME����:�ڻ�����ͨ�Ź����ж����һ���ļ���������
                    * ��ʽ�� ������/С����   text/html		image/jpeg

                * ��ȡ��String getMimeType(String file)
                2. ����󣺹�������
                3. ��ȡ�ļ�����ʵ(������)·��
         */

        //2. ͨ��HttpServlet��ȡ
        ServletContext context = this.getServletContext();

        //3. �����ļ�����
        String filename = "a.jpg";//image/jpeg


        //4.��ȡMIME����
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
