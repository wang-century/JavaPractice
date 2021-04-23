package P8_IO;

import org.junit.Test;
import java.io.File;


/**
 * File类的使用
 */
public class T1_File {
    @Test
    /**
     * 1.路径分隔符
     */
    public void T1_Separator(){
        // 1.使用 / 符号
        String path1 = "./README.md";
        System.out.println(path1);
        // 2.使用常量 File.separator 拼接
        String path2 = "." + File.separator + "README.md";
        System.out.println(path2);
    }
    @Test
    /**
     * 2.构造器
     */
    public void T2_Constructor(){
        String path = "./README.md";
        // 构建File对象 方法1
        File file1 = new File(path);
        System.out.println(file1.length());  // 打印文件长度
        // 构建File对象 方法2
        File file2 = new File("./","README.md");
        System.out.println(file2.length());  // 打印文件长度
        // 构建File对象 方法3
        File file3 = new File(new File("./"),"README.md");
        System.out.println(file3.length());  // 打印文件长度
    }
    @Test
    /**
     * 3.文件名、路径
     */
    public void T3_AbsoluteRelativePath(){
        // 获取当前工作路径
        String currentPath = System.getProperty("user.dir");
        System.out.println("当前工作路径：");
        System.out.println(currentPath);
        // 获取文件绝对路径
        File file = new File(currentPath,"README.md");
        String absolutePath = file.getAbsolutePath();
        System.out.println("文件绝对路径：");
        System.out.println(absolutePath);
        // 获取文件名
        String fileName = file.getName();
        System.out.println("文件名：");
        System.out.println(fileName);
        // 获取文件路径
        String filePath = file.getPath();
        System.out.println("文件路径：");
        System.out.println(filePath);
        // 获取文件父路径
        String fileParent = file.getParent();
        System.out.println("文件父路径：");
        System.out.println(fileParent);
    }

    @Test
    /**
     * 4.文件状态
     */
    public void T4_FileStatus(){
        String currentPath = System.getProperty("user.dir");
        File file = new File(currentPath,"README.md");
        // 判断文件是否存在
        if (file.exists()){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
        }
        // 判断文件对象是否是一个文件
        if (file.isFile()){
            System.out.println("该对象是文件");
        }else{
            System.out.println("该对象不是文件");
        }
        // 判断文件对象是否是一个目录
        if (file.isDirectory()){
            System.out.println("该对象是目录");
        }else{
            System.out.println("该对象不是目录");
        }
    }

    @Test
    /**
     * 5.创建新文件，删除文件
     */
    public void T5_CreateDeleteFile(){

    }

}
