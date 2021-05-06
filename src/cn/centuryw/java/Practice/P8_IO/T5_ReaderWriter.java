package cn.centuryw.java.Practice.P8_IO;

import org.junit.Test;

import java.io.*;

/**
 * @author centuryw
 * @version 1.0
 * @description: 文件字符流操作
 * @date 2021/4/28 下午5:22
 */
public class T5_ReaderWriter {
    /**
     * @description: 文件字符输入流
     * @param:  无
     * @return: void
     * @author centuryw
     * @date: 2021/4/28 下午5:24
     */
    @Test
    public void T1_Reader(){
        // 1.创建源
        File src = new File("TestFiles/IOTest3.txt");
        // 2.选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            // 3.操作
            char[] flush = new char[4];
            int length = -1;
            while ((length=reader.read(flush))!=-1){
                String str = new String(flush,0,length);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 4.释放资源
            try {
                if (reader!=null){
                    reader.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * @description: 文件字符输出流
     * @param: 无
     * @return:  void
     * @author centuryw
     * @date: 2021/4/28 下午5:29
     */
    @Test
    public void T2_Writer(){
        // 1.创建源
        File dest = new File("TestFiles/IOTest4.txt");
        // 2.选择流
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            // 3.操作
            // (1).将字符串转为字符数组写入
            String str = new String("你好世界\n");
            char[] strBytes = str.toCharArray();
            writer.write(strBytes);
            // (2).直接将字符串写入
            writer.write(str);
            // (3).使用append方法
            writer.append('a').append("方法").append("\n");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 4.释放资源
            try {
                if (writer!=null){
                    writer.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
