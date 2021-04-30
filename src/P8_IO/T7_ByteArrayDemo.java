package P8_IO;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author centuryw
 * @version 1.0
 * @description: 图片读取到字节数组再转回图片
 * @date 2021/4/29 下午2:57
 */
public class T7_ByteArrayDemo {
    public static void main(String[] args) {
        // 1.将文件转为字节
        byte[] picBytes = fileToBytes("TestFiles/test.jpg");
        // 2.将字节写入字节数组
        ByteArrayOutputStream baos = byteToByteArray(picBytes);
        // 3.获取字节数组数据并写入文件
        byteArrayToFile(baos,"TestFiles/test_copy.jpg");
    }

    /**
     * @description: 文件转字节
     * @param:  文件路径
     * @return: byte[]
     * @author centuryw
     * @date: 2021/4/29 下午3:31
     */
    public static byte[] fileToBytes(String fileName){
        File file = new File(fileName);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            return is.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @description: 字节写入字节数组
     * @param: bytes
     * @return: void
     * @author centuryw
     * @date: 2021/4/29 下午3:42
     */
    public static ByteArrayOutputStream byteToByteArray(byte[] bytes){
        // 2.选择流
        ByteArrayOutputStream baos = null;
        try{
            baos = new ByteArrayOutputStream();
            // 3.操作
            baos.write(bytes,0,bytes.length);
            baos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        return baos;
    }

    /**
     * @description: 字节数组写入文件
     * @param:  baos 字节数组流
                fileName 文件名
     * @return: void
     * @author centuryw
     * @date: 2021/4/29 下午3:53
     */
    public static void byteArrayToFile(ByteArrayOutputStream baos, String fileName){
        byte[] dest = null;
        File file = new File(fileName);
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            // 获取数据
            dest = baos.toByteArray();
            // 写入文件
            os.write(dest);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
