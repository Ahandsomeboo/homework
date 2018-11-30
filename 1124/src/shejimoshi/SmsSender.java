package shejimoshi;

public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("收信");
    }
}
