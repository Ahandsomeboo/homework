package shejimoshi;

public class SendFactory {

    public Sender produce(String type) {
        if ("1".equals(type)) {
            return new MailSender();
        } else if ("2".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
    //多个工厂方法模式
//    public Sender produceMail(){
//
//        return new MailSender();
//    }
//
//    public Sender produceSms(){
//        return new SmsSender();
//    }
}
//静态工厂方法模式
//public class SendFactory {
//
//    public static Sender produceMail(){
//        return new MailSender();
//    }
//
//    public static Sender produceSms(){
//        return new SmsSender();
//    }
//}
