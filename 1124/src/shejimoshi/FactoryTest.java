package shejimoshi;

public class FactoryTest {

    public static void main(String[] args) {
        System.out.println("发信请输1，收信请输2");
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("1");
        //多个工厂方法模式
        //Sender sender = factory.produceMail();
        sender.Send();
    }
}
//静态工厂方法模式
//public class FactoryTest {
//
//    public static void main(String[] args) {
//        Sender sender = SendFactory.produceMail();
//        sender.Send();
//    }
//}