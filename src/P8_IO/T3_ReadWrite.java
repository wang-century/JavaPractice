package P8_IO;

import org.junit.Test;

import java.io.*;

/**
 * 文件流操作
 */
public class T3_ReadWrite {
    @Test
    /**
     * 文件字节流读取
     */
    public void T1_(){
        // 1.创建源
        File file = new File("README.md");
        // 2.选择流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            // 3.操作(读取)     注：文件末尾返回-1
            int d;
            while ((d=inputStream.read())!=-1){
                System.out.print((char) d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 4.释放资源
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
