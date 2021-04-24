package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �ڷ������е�Servlet�ж��Ƿ���һ����ΪlastTime��cookie
 * 1. �У����ǵ�һ�η���
 * 1. ��Ӧ���ݣ���ӭ���������ϴη���ʱ��Ϊ:2018��6��10��11:50:20
 * 2. д��Cookie��lastTime=2018��6��10��11:50:01
 * 2. û�У��ǵ�һ�η���
 * 1. ��Ӧ���ݣ����ã���ӭ���״η���
 * 2. д��Cookie��lastTime=2018��6��10��11:50:01
 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //������Ӧ����Ϣ������ݸ�ʽ�Լ�����
        response.setContentType("text/html;charset=utf-8");

        //1.��ȡ����Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//û��cookieΪlastTime
        //2.����cookie����
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3.��ȡcookie������
                String name = cookie.getName();
                //4.�ж������Ƿ��ǣ�lastTime
                if ("lastTime".equals(name)) {
                    //�и�Cookie�����ǵ�һ�η���

                    flag = true;//��lastTime��cookie

                    //����Cookie��value
                    //��ȡ��ǰʱ����ַ�������������Cookie��ֵ�����·���cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("����ǰ��" + str_date);
                    //URL����
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("�����" + str_date);
                    cookie.setValue(str_date);
                    //����cookie�Ĵ��ʱ��
                    cookie.setMaxAge(60 * 60 * 24 * 30);//һ����
                    response.addCookie(cookie);


                    //��Ӧ����
                    //��ȡCookie��value��ʱ��
                    String value = cookie.getValue();
                    System.out.println("����ǰ��" + value);
                    //URL���룺
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("�����" + value);
                    response.getWriter().write("<h1>��ӭ���������ϴη���ʱ��Ϊ:" + value + "</h1>");


                    break;

                }
            }
        }


        if (cookies == null || cookies.length == 0 || flag == false) {
            //û�У���һ�η���

            //����Cookie��value
            //��ȡ��ǰʱ����ַ�������������Cookie��ֵ�����·���cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("����ǰ��" + str_date);
            //URL����
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("�����" + str_date);

            Cookie cookie = new Cookie("lastTime", str_date);
            //����cookie�Ĵ��ʱ��
            cookie.setMaxAge(60 * 60 * 24 * 30);//һ����
            response.addCookie(cookie);

            response.getWriter().write("<h1>���ã���ӭ���״η���</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}