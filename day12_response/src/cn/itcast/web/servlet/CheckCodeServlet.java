package cn.itcast.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1.����һ�������ڴ���ͼƬ(��֤��ͼƬ����)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.����ͼƬ
        //2.1��䱳��ɫ
        Graphics g = image.getGraphics();//��ȡ���ʶ���
        g.setColor(Color.PINK);//���û�����ɫ
        g.fillRect(0,0,width,height);//��䱳��ɫ

        //2.2���߿�
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //��������Ǳ�
        Random random = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //��ȡ�ַ�
            char c = str.charAt(index);//����ַ�
            g.drawString(c+"",width/5*i,height/2);
        }

        //2.4��������
        g.setColor(Color.GREEN);
        //������������

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);


            g.drawLine(x1,y1,x2,y2);
        }


        //3.��ͼƬ�����ҳ��չʾ
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
