package shejimoshi;

public class danli2 {
    private danli2(){}
    private static danli2 ME;

    public synchronized static danli2 getME() {
        if(ME==null){
           danli2 ME=new danli2 ();
        }
        return ME;
    }
}

class Testdanli2{
    public static void main(String[] args) {
        danli2 x=danli2.getME ();
        danli2 y=danli2.getME ();
        danli2 z=danli2.getME ();
        System.out.println (x==y);
        System.out.println (y==z);
    }
}