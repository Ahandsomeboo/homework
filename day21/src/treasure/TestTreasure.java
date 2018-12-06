package treasure;

import java.lang.reflect.Method;

public class  TestTreasure{
    public static void main(String[] args) {

        for (Method method : new Treasure().getClass().getMethods()) {
            if(method.getAnnotations().length>=1){
                System.out.println(method);
            }
        }
    }
}
