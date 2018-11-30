package shejimoshi;

public class prototype implements Cloneable {

        private String name;
        private int age;
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

}
