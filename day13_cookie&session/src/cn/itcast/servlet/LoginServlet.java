package cn.itcast.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.����request����
        request.setCharacterEncoding("utf-8");
        //2.��ȡ����
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //3.�Ȼ�ȡ���ɵ���֤��
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //��ȡ����֤��󣬼���checkCode_session����ֵ��ɾ��session�д洢����֤��,��֤��֤��һ����ʹ��
        session.removeAttribute("checkCode_session");

        //3.1�ж���֤���Ƿ���ȷ
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            //���Դ�Сд�Ƚ�
            //��֤����ȷ
            //�ж��û����������Ƿ�һ��

            //3.����User����
            User user = new User();
            user.setName(username);
            user.setPassword(password);

            //4.����UserDao��Login����
            UserDao userDao = new UserDao();
            User login = userDao.login(user);


            if (login != null) {//����UserDao��ѯ���ݿ�,�ǿռ��û���������ȷ
                //��¼�ɹ�
                //�洢��Ϣ���û���Ϣ
                session.setAttribute("user", username);
                //�ض���success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //��¼ʧ��
                //�洢��ʾ��Ϣ��request
                request.setAttribute("login_error", "�û������������");
                //ת������¼ҳ��
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //��֤�벻һ��
            //������ʾ��Ϣ��request
            request.setAttribute("cc_error", "��֤�����");
            //ת������¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
