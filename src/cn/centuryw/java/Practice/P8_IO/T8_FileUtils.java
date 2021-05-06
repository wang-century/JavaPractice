package cn.centuryw.java.Practice.P8_IO;

import java.io.*;

/**
 * @author centuryw
 * @version 1.0
 * @description: 文件工具：封装拷贝、封装释放资源
 * @date 2021/4/30 上午11:47
 */
public class T8_FileUtils {
    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("TestFiles/test.jpg");
            OutputStream os = new FileOutputStream("TestFiles/test_copy.jpg");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 文件到字节数组
        byte[] data = null;
        try {
            InputStream is = new FileInputStream("TestFiles/test.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            copy(is,baos);
            data = baos.toByteArray();
            System.out.println(data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(data);
            OutputStream os = new FileOutputStream("TestFiles/test_copy2.jpg");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     * @description:  对接输入输出流
     * @param: is   输入流
     * @param: os   输出流
     * @return: void 
     * @author centuryw
     * @date: 2021/4/30 上午11:48
     */ 
    public static void copy(InputStream is, OutputStream os){
        try{
            byte[] flush = new byte[1024];  // 缓冲容器
            int len = -1;   // 接收长度
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);  // 分段写出
            }
            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放资源
            close(is,os);
        }
    }

    /**
     * @description: 释放资源
     * @param: is   输入流
     * @param: os   输出流
     * @return: void
     * @author centuryw
     * @date: 2021/4/30 上午11:58
     */
    public static void close(InputStream is,OutputStream os){
        try {
            if (is!=null){
                is.close();
            }
            if (os!=null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @description: 释放资源
     * @param: ios 可变参数
     * @return: void
     * @author centuryw
     * @date: 2021/4/30 下午12:02
     */
    public static void close(Closeable... ios){
        for (Closeable io:ios){
            try {
                if (io!=null){
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @description:  对接输入输出流（使用特性释放资源try...with...resource）
     * @param: is   输入流
     * @param: os   输出流
     * @return: void
     * @author centuryw
     * @date: 2021/4/30 上午11:48
     */
    public static void copy2(InputStream is, OutputStream os){
        try(is;os){
            byte[] flush = new byte[1024];  // 缓冲容器
            int len = -1;   // 接收长度
            while ((len=is.read(flush))!=-1){
                os.write(flush,0,len);  // 分段写出
            }
            os.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
