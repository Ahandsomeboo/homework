package PaChong;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaChong {
    public static void main(String[] args) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new
                URL("https://tieba.baidu.com/p/2256306796?red_tag=1781367364").openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String line =null;
        StringBuffer string = new StringBuffer();
        while ((line=r.readLine())!=null){
            string.append(line);
        }
        ArrayList<String> imgList = getSrc(string.toString());
        for (String s : imgList) {
            if (s.endsWith(".jpg")) {
                String[] split = s.split("src=\"");
                Pac(split[1]);

            }
        }
        r.close();
        connection.disconnect();
    }

    public static ArrayList<String> getSrc(String html){
        ArrayList<String> srcList = new ArrayList<>();
        Pattern compile = Pattern.compile("<img class=\"BDE_Image\" src=\"(.*?)\"");
        Matcher matcher = compile.matcher(html);
        while (matcher.find()) {
            srcList.add(matcher.group().substring(0,matcher.group().length() - 1));
        }
        return srcList;
    }
    private static void Pac(String s) {
        try {
            HttpURLConnection connection1 = (HttpURLConnection) new
                    URL(s).openConnection();
            InputStream in = connection1.getInputStream();
            UUID uuid = UUID.randomUUID();
            FileOutputStream fo = new FileOutputStream(new File(uuid+".jpg"));
            byte[] bytes = new byte[1024*8];
            int length = 0;
            System.out.println("查询到" + connection1);
            while ((length = in.read(bytes)) != -1) {
                fo.write(bytes, 0, length);
            }
            in.close();
            fo.close();
            System.out.println(uuid+".jpg" + "查询完成");

        } catch (Exception e) {
            System.out.println("查询失败");
        }
    }

}

