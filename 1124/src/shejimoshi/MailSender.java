package shejimoshi;

public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("发信");
    }
}
