package Meiju;


    public enum Student {
        pupils,middleschoolstudent,highschoolstudent;
    }
    class TestStudnet{
        public static void main(String[] args) {
            System.out.println (Student.pupils.ordinal ());
            System.out.println (Student.pupils.name());
            System.out.println (Student.valueOf ("pupils")==Student.pupils);
            for(Student value:Student.values ()){
                System.out.println (value);
            }
        }
    }

