package P8_IO;

import org.junit.Test;

import java.io.*;

/**
 * 文件拷贝
 */
public class T4_CopyFile {
    /**
     * @description: 测试文件拷贝
     * @param:  无
     * @return: void
     * @author centuryw
     * @date: 2021/4/28 下午5:11
     */
    @Test
    public void T1_() {
         copy("TestFiles/test.jpg","TestFiles/test2.jpg");
    }

    /**
     * @description: 文件拷贝
     * @param: 源文件名 目标文件名
     * @return: void
     * @author centuryw
     * @date: 2021/4/28 下午5:00
     */
    public void copy(String src, String dest) {
        // 1.初始化输入输出流、缓冲容器
        File fileSrc = new File(src);
        File fileDest = new File(dest);
        InputStream is = null;
        OutputStream os = null;
        byte[] buffer = new byte[1024]; // 字节流载体
        int readLength = -1;    // 读取文件长度
        try {
            is = new FileInputStream(fileSrc);
            os = new FileOutputStream(fileDest);
            // 2.读取源文件
            while ((readLength = is.read(buffer)) != -1) {
                // 3.写入目标文件
                os.write(buffer,0,readLength);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源(先打开的后关闭)
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
