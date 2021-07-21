package cn.itcast.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.�����������
        Lenovo lenovo = new Lenovo();

        //2.��̬������ǿlenovo����
        /**
         * ����������
         *      1.�����������ʵ����.getClass().getClassLoader()
         *      2.�ӿ����飺��ʵ����.getClass().getInterfaces()
         *      3.��������new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
                �����߼���д�ķ��������������õ����з������ᴥ���÷���ִ��
                    ������
                        1.proxy:�������
                        2.method:���������õķ���������װΪ�Ķ���
                        3.args:���������÷���ʱ�����ݵ�ʵ�ʲ���
             */
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                System.out.println("�÷���ִ����...");
//                System.out.println(method.getName());
//                System.out.println(objects[0]);

                //�ж��Ƿ���sale����
                if (method.getName().equals("sale")){
                    //1.��ǿ����
                    double money = (double) objects[0];
                    money = money * 0.85;
                    //������ʵ������ø÷���
                    String obj = (String) method.invoke(lenovo, money);
                    //2.��ǿ����ֵ

                    return obj+"_����";
                }else {
                    //������ʵ������ø÷���
                    Object obj = method.invoke(lenovo, objects);

                    return obj;
                }
            }
        });

        //3.���÷���
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
    }
}
