package cn.centuryw.java.Practice.P4_OOArray;

import org.junit.Test;


/**
 * @author centuryw
 * @version 1.0
 * @description: String类常用方法
 * @date 2021/5/6 下午5:04
 */
public class T1_String {
    @Test
    public void T1_(){
        String s1 = "Hello world!";
        String s2 = "hello world!";
        System.out.println(s1.charAt(3));   // 提取下标为3的字符
        System.out.println(s1.length());    // 返回字符串长度
        System.out.println(s1.equals(s2));  // 比较字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));    // 比较字符串是否相等(忽略大小写)
        System.out.println(s1.indexOf("Hello"));    // 字符串是否包含Hello
        String s3 = s1.replace(' ','&');    // 将s1中的空格替换成&
        System.out.println(s3);
        System.out.println(s1.startsWith("Hello")); // 是否以Hello开头
        System.out.println(s1.endsWith("!"));   // 是否以!结尾
        String s4 = s1.substring(4);    // 提取s1字符串，从下标4开始到结尾
        System.out.println(s4);
        String s5 = s1.substring(4,7);  // 提取s1字符串，从下标4开始到下标7结束
        System.out.println(s5);
        String s6 = s1.toLowerCase();    // 全转小写
        System.out.println(s6);
        String s7 = s1.toUpperCase();    // 全转大写
        System.out.println(s7);
        String s8 = " Hello world! ".trim();    // 去除首尾空格
        System.out.println(s8);

    }

}
