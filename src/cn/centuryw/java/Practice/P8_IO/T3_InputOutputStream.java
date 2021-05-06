package cn.centuryw.java.Practice.P8_IO;
import org.junit.Test;
import java.io.*;

/**
 * 文件字节流操作
 */
public class T3_InputOutputStream {

    /**
     * 文件字节流读取
     */
    @Test
    public void T1_() {
        // 1.创建源
        File file = new File("TestFiles/IOTest.txt");
        // 2.选择流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            // 3.操作(读取)     注：文件末尾返回-1
            int d;
            while ((d = inputStream.read()) != -1) {
                System.out.print((char) d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 分段读取文件字节流
     */
    @Test
    public void T2_() {
        // 1.创建源
        File file = new File("TestFiles/IOTest.txt");
        // 2.选择流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            // 3.操作(分段读取)     注：文件末尾返回-1
            byte[] flush = new byte[4];   // 缓冲容器
            int len;   // 接收长度
            while ((len = inputStream.read(flush)) != -1) {
                // 字节数组-->字符串 (解码)
                String str = new String(flush,0,len);
                System.out.print(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 文件字节输出流
     */
    @Test
    public void T3_(){
        // 1.创建源
        File file = new File("TestFiles/IOTest2.txt");
        // 2.选择流
        OutputStream outputStream = null;
        try {
            // 非追加写
            outputStream = new FileOutputStream(file);
            // 追加写
            // outputStream = new FileOutputStream(file,true);
            // 3.操作(写出)
            String message = "This is io test string.";
            byte[] content = message.getBytes();
            outputStream.write(content,0,content.length);
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 4.释放资源
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
