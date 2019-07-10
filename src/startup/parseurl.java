package startup;


import org.w3c.dom.Document;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Base64;
public class parseurl {
    public static void main(String... args)
    {
        final String reg = "document.write\\(strencode\\(\"(.+)\",\"(.+)\",.+\\)\\);";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(html);
        String param1 = "", param2 = "";
        if(m.find()){
            param1 = m.group(1);
            param2 = m.group(2);
        }
        param1 = new String(Base64.getDecoder().decode(param1.getBytes()));
        String source_str = "";
        for (int i = 0,k=0; i<param1.length(); i++) {
            k = i % param2.length();
            source_str += ""+(char)(param1.codePointAt(i) ^ param2.codePointAt(k));
        }
        source_str = new String(Base64.getDecoder().decode(source_str.getBytes()));
        //Document source = Jsoup.parse(source_str);
        //String videoUrl = source.select("source").first().attr("src");
        System.out.println(source_str);
    }

    static String html = "<video id=\"vid\" class=\"video-js vjs-default-skin vjs-big-play-centered\"\n" +
            "        controls preload=\"auto\" width=\"465\" height=\"360\"\n" +
            "         poster=\"http://img2.t6k.co/thumb/69759.jpg\"      >\n" +
            "     \n" +
            "                      <script>\n" +
            "         <!--\n" +
            "                document.write(strencode(\"M3F6RAAtA1oUNDscIBQabQdbKUoBZ2p6ARdZDCl1Nh45GVJALhkkTS4FPAcvHEgwMCI+HzsSNHQ+M2xhKBRbDyAeShA9Ins5Jz8iOQoXJDgcfBADMwYrOyp8DkMTMRtZOgYVKi0nYlY+HR15HTYHfiM1Kk8faiY+NBlHJW8ZWxoXJxQhMGJdMy0zDFNzTgZZ\",\"c942duI0NgyfCyWTMiAze/+LMnatf1cktc55cMi8cQqpceqDSfoewhmApI9TdyjxnZsjYfJQCRhQoOfTK9FYgNaapNvuFZw8kRShgJ7osIHKPbFJlqszR9EYPQ+R5MktsJxJj5eEOkM\",\"M3F6RAAtA1oUNDscIBQabQdbKUoBZ2p6ARdZDCl1Nh45GVJALhkkTS4FPAcvHEgwMCI+HzsSNHQ+M2xhKBRbDyAeShA9Ins5Jz8iOQoXJDgcfBADMwYrOyp8DkMTMRtZOgYVKi0nYlY+HR15HTYHfiM1Kk8faiY+NBlHJW8ZWxoXJxQhMGJdMy0zDFNzTgZZ\"));\n" +
            "         //-->\n" +
            "</script>";
}
