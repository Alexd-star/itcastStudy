package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //��ȡ������֮ǰ����������Ĭ�ϱ��룺ISO-8859-1 ����Ϊ��GBK
        // response.setCharacterEncoding("utf-8");

        //��������������������͵���Ϣ�����ݵı��롣���������ʹ�øñ������
        //response.setHeader("content-type","text/html;charset=utf-8");

        //�򵥵���ʽ�����ñ���
        resp.setContentType("text/html;charset=utf-8");

        //1.��ȡ�ַ������
        PrintWriter pw = resp.getWriter();
        //2.�������
        //pw.write("<h1>hello response</h1>");
        pw.write("��ð����� response");
    }
}
