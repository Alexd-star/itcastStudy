package cn.itcast.web.proxy;

public class Lenovo implements SaleComputer{

    @Override
    public String sale(double money) {
        System.out.println("����"+money+"Ԫ����һ̨����");
        return "�������";
    }

    @Override
    public void show() {
        System.out.println("չʾ����");
    }
}
