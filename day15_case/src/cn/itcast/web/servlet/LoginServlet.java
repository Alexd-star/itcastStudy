package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
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
        //1.���ñ���
        request.setCharacterEncoding("utf-8");
        //2.��ȡ����
        //2.1��ȡ��֤��
        String verifycode = request.getParameter("verifycode");


        //3.��֤��У��
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//��֤��֤��һ��������

        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            //��֤�벻��ȷ
            //��ʾ��Ϣ
            request.setAttribute("login_msg","��֤�����");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        Map<String,String[]> map = request.getParameterMap();
        //4.��װuser����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.����service��ѯ
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        //6.�ж��Ƿ��¼�ɹ�
        if (loginUser!=null){
            //��¼�ɹ�
            //���û�����Session
            session.setAttribute("user",loginUser);
            //��תҳ��
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //��¼ʧ��
            //��ʾ��Ϣ
            request.setAttribute("login_msg","�û������������");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
