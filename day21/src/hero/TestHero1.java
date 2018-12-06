package hero;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHero1 {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines (Paths.get ("day21\\heroes.txt"), Charset.forName ("utf-8"));
        // \t  split("\t")

        List<Hero> Herolist = lines.map (str -> str.split ("\t")).map (array ->

                new Hero (
                        Integer.parseInt (array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt (array[4]),
                        Integer.parseInt (array[5]),
                        Integer.parseInt (array[6]))

        ).collect (Collectors.toList ());

        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序

//        Herolist.stream ().sorted ((o1, o2) -> o2.getPower ()-o1.getPower ()).limit (3).forEach
//                    (o1-> System.out.println (o1));
        // 2. 按出生地分组
//       Map<String, List<hero>> map = Herolist.stream().collect(Collectors.groupingBy((s) -> s.getLoc () ));
//        map.forEach ((key,value)-> System.out.println ("key:"+key+",value"+value.stream ().map (o->o.getName ()).collect(Collectors.toList())));
        // 3. 找出寿命前三的武将
//        Herolist.stream ().sorted ((o1,o2)->{int age1=o1.getDeath ()-o1.getBirth ();
//        int age2=o2.getDeath ()-o2.getBirth ();
//        return age2-age1;}).limit (3).collect (Collectors.toList ()).forEach (o1-> System.out.println (o1.getName ()));
        // 4. 女性寿命最高的
//        Herolist.stream ().filter (o1->o1.getSex ().equals ("女")).sorted ((o1,o2)->{int age1=o1.getDeath ()-o1.getBirth ();
//        int age2=o2.getDeath ()-o2.getBirth ();
//        return age2-age1;}).limit (1).collect (Collectors.toList ()).forEach (o1-> System.out.println (o1.getName ())
//        );
     //   5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 "吕布", "张飞", "关羽", "马超"
//       Set set= Herolist.stream ().map (o->o.getPower ()).sorted ((o1, o2) -> o2-o1).limit (3).collect (Collectors.toSet ());
//       Herolist.stream ().filter (o1->set.contains (o1.getPower ())).collect (Collectors.toList ()).forEach (o-> System.out.println (o.getName ()));
      //  6. 按各个年龄段分组： 0~20, 2140, 41~60, 60以上

//       Map<String, List<hero>> map2 =Herolist.stream ().collect (Collectors.groupingBy ((h -> ageRange(h.getDeath() - h.getBirth()))));
//       map2.forEach ((key,value) -> System.out.println ("key:"+key+",value"+value.stream ().map(h -> h.getName()).collect(Collectors.toList())));
        // 7. 按武力段分组： >=90， 80~89, 70~79, <70
        Map <String,List<Hero>> map3=Herolist.stream ().collect (Collectors.groupingBy (o->powerRange (o.getPower ())));
        map3.forEach ((key,value) -> System.out.println ("key:"+key+",value"+value.stream ().map(h -> h.getName()).collect(Collectors.toList())));
        // 8. 按出生地分组后，统计各组人数
        Map <String,Long> map4=Herolist.stream ().collect (Collectors.groupingBy (o -> o.getLoc(), Collectors.counting()));
        map4.forEach ((key,value) -> System.out.println ("key:"+key+",value:"+value));

    }

    private static String ageRange(int i) {
        if (i>=90){
            return "武力值>=90";
        }else if(i>=80&&i<90){
            return "武力值80~89";
        }else if(i>=70&&i<80){
            return "武力值70~79";
        }else
            return "武力值小于70";


    }
    private static String powerRange(int i) {
        if (i>=0&&i<20){
            return "年龄0~20";
        }else if(i>20&&i<40){
            return "年龄20~40";
        }else if(i>40&&i<60){
            return "年龄40~60";
        }else
            return "年龄60以上";


    }
}
