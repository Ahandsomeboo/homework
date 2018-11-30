package shejimoshi;

public class danli3 {
        static{
            System.out.println("danli3类被加载了");
        }
        private danli3() {

        }
        private static class Holder {
            static{
                System.out.println("Holder类被加载了");
            }
            static danli3 ME = new danli3 ();
        }
        public static danli3 getInstance() {
            return Holder.ME;
        }
        public static void test() {
            System.out.println("danli3其它方法");
        }

}
