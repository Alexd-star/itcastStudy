package cn.itcast.web.servlet.LoginServlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//��¼ʧ��ҳ��
@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ҳ��дһ�仰
        //���ñ���
        resp.setContentType("text/html;charset=utf-8");
        //���
        resp.getWriter().write("��¼ʧ�ܣ��û������������");
    }
}
