package com.xxh.learn.java.thread;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;

public class NoCaughtThread {
//    public static void main(String[] args) {
//      /*  try {
//            Thread thread = new Thread(new Task());
//            thread.start();
//        } catch (Exception e) {
//            System.out.println("==Exception: " + e.getMessage());
//        }*/
//       /* Set<String> a=new CopyOnWriteArraySet<>();
//        a.add("a");
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        System.out.println(a.size());*/
//
//       /* String x="abcDEFg";
//        String y="abc defg";
//        System.out.println(x.toLowerCase()+" \n"+x.toLowerCase(Locale.SIMPLIFIED_CHINESE));*/
//
//        String a="ab;12;cd;34";
//        List<String> list= Arrays.asList(a.split(";"));
//        System.out.println(list.size());
//
//    }




    public static boolean isIPV6Format(String value) {
        value = value.trim();
        if(value.equals("")) {
            return false;
        }
        Pattern  pattern = Pattern.compile("^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:)|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}(:[0-9A-Fa-f]{1,4}){1,2})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){1,3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){1,4})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){1,5})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){1,6})|(:(:[0-9A-Fa-f]{1,4}){1,7})|(([0-9A-Fa-f]{1,4}:){6}(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){0,1}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){0,2}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){0,3}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){0,4}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(:(:[0-9A-Fa-f]{1,4}){0,5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}))$");

        return pattern.matcher(value).matches();
    }
    public static void main(String[] args) {
        String ipv6_1 = "2019:db8:a583:64:c68c:d6df:600c:ee9a";
        String ipv6_2 = "2019:db8:a583::9e42:be55:53a7";
        String ipv6_3 = "2019:db8:a583:::9e42:be55:53a7";
        String ipv6_4 = "1:2:3:4:5::192.168.254.254";
        String ipv6_5 = "ABCD:910A:2222:5498:8475:1111:3900:2020";
        String ipv6_6 = "1030::C9B4:FF12:48AA:1A2B";
        String ipv6_8 = "::0:0:0:0:0:0:1";
        String ipv6_9 = "2019:0:0:0:0::";
        String ipv6_10= "2048:877e:31::7";
//        String ipv6_11= "2408:873c:4011:1::18";
        String ipv6_11= "http://[2408:873c:4011:1::18]/imtt.dd.qq.com/sjy.20003/16891/apk/809854BDDE03C666AE1B11C351F6859C.apk?mkey=6284530e00002f9d&f=0ef1&fsname=com.greenpoint.android.mc10086.activity_7.7.0_77002.apk&csr=9301&cip=2408:8417:1b20:2fe7:4468:53ff:fe92:90bd&proto=http";

//         a=ipv6_11.split("\\[");

        URI uri = null;
        try {
            uri = new URI(ipv6_11);
            String returnVal = uri.getHost();
            ipv6_11=returnVal.substring(1,returnVal.length()-1);
            System.out.println("a="+returnVal);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        String resultLine = "\n==> ";
        String splitLine = "\n----------------------------------------------------\n";
        System.out.println(ipv6_1 + resultLine + isIPV6Format(ipv6_1) + splitLine);
        System.out.println(ipv6_2 + resultLine + isIPV6Format(ipv6_2) + splitLine);
        System.out.println(ipv6_3 + resultLine + isIPV6Format(ipv6_3) + splitLine);
        System.out.println(ipv6_4 + resultLine + isIPV6Format(ipv6_4) + splitLine);
        System.out.println(ipv6_5 + resultLine + isIPV6Format(ipv6_5) + splitLine);
        System.out.println(ipv6_6 + resultLine + isIPV6Format(ipv6_6) + splitLine);
//        System.out.println(ipv6_7 + resultLine + isIPV6Format(ipv6_7) + splitLine);
        System.out.println(ipv6_8 + resultLine + isIPV6Format(ipv6_8) + splitLine);
        System.out.println(ipv6_9 + resultLine + isIPV6Format(ipv6_9) + splitLine);
        System.out.println(ipv6_10 + resultLine + isIPV6Format(ipv6_10) + splitLine);
        System.out.println(ipv6_11 + resultLine + isIPV6Format(ipv6_11) + splitLine);
    }

}

