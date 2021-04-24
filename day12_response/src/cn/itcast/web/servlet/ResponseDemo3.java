package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1...");

        /*// ����/responseDemo1,���Զ���ת��/responseDemo2��Դ
        //1.����״̬��Ϊ302
        response.setStatus(302);
        //2.������Ӧͷlocation
        response.setHeader("location","/day12/responseDemo2");*/

        //�򵥵��ض��򷽷�
        resp.sendRedirect("/day12/responseDemo4");
    }
}
