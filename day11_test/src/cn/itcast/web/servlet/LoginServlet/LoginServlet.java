package cn.itcast.web.servlet.LoginServlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/*
 * ��ɵ�¼�ľ����߼�
 * */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.���ñ���
        req.setCharacterEncoding("utf-8");
        /*//2.��ȡ�������
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.��װ����
        User user = new User();
        user.setName(username);
        user.setPassword(password);*/

        //2.��ȡ�����������
        Map<String, String[]> map = req.getParameterMap();
        //3.����User����
        User user = new User();
        //3.2ʹ��BeanUtils��װ
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����UserDao��Login����
        UserDao userDao = new UserDao();
        User login = userDao.login(user);

        //5.�ж�user
        if (login == null) {
            //��¼ʧ��
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            //��¼�ɹ�
            //�洢����
            req.setAttribute("user", user);
            //ת��
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
