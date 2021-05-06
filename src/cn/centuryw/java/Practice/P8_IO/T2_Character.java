package cn.centuryw.java.Practice.P8_IO;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * 编码：字符串-->字节
 * 解码：字节-->字符串
 */
public class T2_Character {
    @Test
    /**
     * 编码
     */
    public void T1_encode() {
        String message = "君子以厚德载物";
        // 编码
        byte[] content = message.getBytes();    // 工程默认字符集
        content = message.getBytes(StandardCharsets.UTF_8); // 指定字符集
        System.out.println("长度：" + content.length);
    }

    @Test
    /**
     * 解码
     */
    public void T2_decode() {
        String message = "君子以厚德载物";
        // 编码
        byte[] content = message.getBytes();    // 工程默认字符集
        // 解码
        message = new String(content, 0, content.length, StandardCharsets.UTF_8);
        System.out.println("解码结果：" + message);
    }


}
