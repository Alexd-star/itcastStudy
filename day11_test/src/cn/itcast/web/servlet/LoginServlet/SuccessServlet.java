package cn.itcast.web.servlet.LoginServlet;

import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//��¼�ɹ�ҳ��
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ȡrequest���й����user��������
        User user = (User) req.getAttribute("user");

        if (user != null) {

            //��ҳ��дһ�仰
            //���ñ���
            resp.setContentType("text/html;charset=utf-8");
            //���
            resp.getWriter().write("��¼�ɹ���" + user.getName() + "��ӭ����");

        }
    }
}
