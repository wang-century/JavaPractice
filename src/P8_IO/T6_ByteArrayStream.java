package P8_IO;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author centuryw
 * @version 1.0
 * @description: 字节数组流操作
 * @date 2021/4/29 上午11:44
 */
public class T6_ByteArrayStream {
    /**
     * @description: 字节数组输入流 ByteArrayInputStream
     * @param:  无
     * @return: void
     * @author centuryw
     * @date: 2021/4/29 上午11:45
     */
    @Test
    public void T1_(){
        // 1.创建源
        byte[] src = "talk is cheap, show me your code".getBytes(StandardCharsets.UTF_8);
        // 2.选择流
        InputStream bais = null;
        try{
            bais = new ByteArrayInputStream(src);
            // 3.操作(分段读取)
            byte[] flush = new byte[4]; // 缓冲容器
            int len;
            while ((len=bais.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * @description: 字节数组输出流
     * @param:  无
     * @return: void
     * @author centuryw
     * @date: 2021/4/29 上午11:45
     */
    @Test
    public void T2_(){
        // 1.创建源
        byte[] dest = null;
        // 2.选择流
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            // 3.操作
            String message = "show me your code.";
            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            baos.write(data,0,data.length);
            baos.flush();
            // 4.获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length+":"+new String(dest,0,baos.size()));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
