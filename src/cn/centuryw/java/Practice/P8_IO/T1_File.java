package cn.centuryw.java.Practice.P8_IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;


/**
 * File类的使用
 */
public class T1_File {
    @Test
    /**
     * 1.路径分隔符
     */
    public void T1_Separator() {
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
    public void T2_Constructor() {
        String path = "./README.md";
        // 构建File对象 方法1
        File file1 = new File(path);
        System.out.println(file1.length());  // 打印文件长度
        // 构建File对象 方法2
        File file2 = new File("./", "README.md");
        System.out.println(file2.length());  // 打印文件长度
        // 构建File对象 方法3
        File file3 = new File(new File("./"), "README.md");
        System.out.println(file3.length());  // 打印文件长度
    }

    @Test
    /**
     * 3.文件名、路径
     */
    public void T3_AbsoluteRelativePath() {
        // 获取当前工作路径
        String currentPath = System.getProperty("user.dir");
        System.out.println("当前工作路径：");
        System.out.println(currentPath);
        // 获取文件绝对路径
        File file = new File(currentPath, "README.md");
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
    public void T4_FileStatus() {
        String currentPath = System.getProperty("user.dir");
        File file = new File(currentPath, "README.md");
        // 判断文件是否存在
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            System.out.println("文件不存在");
        }
        // 判断文件对象是否是一个文件
        if (file.isFile()) {
            System.out.println("该对象是文件");
        } else {
            System.out.println("该对象不是文件");
        }
        // 判断文件对象是否是一个目录
        if (file.isDirectory()) {
            System.out.println("该对象是目录");
        } else {
            System.out.println("该对象不是目录");
        }
    }

    @Test
    /**
     * 5.创建新文件，删除文件
     */
    public void T5_CreateDeleteFile() throws IOException {
        File file = new File("./IO.txt");
        // 创建新文件(文件存在则创建失败)
        boolean flag = file.createNewFile();
        if (flag) {
            System.out.println("文件创建成功");
        } else {
            System.out.println("文件创建失败");
        }
        // 删除文件
        flag = file.delete();
        if (flag) {
            System.out.println("文件删除成功");
        } else {
            System.out.println("文件删除失败");
        }
    }

    @Test
    /**
     * 6.目录
     */
    public void T6_Directory() {
        // 创建目录(非递归)
        File file = new File("./TestDir");
        boolean flag = file.mkdir();
        if (flag) {
            System.out.println("创建目录成功");
        }
        flag = file.delete();
        if (flag) {
            System.out.println("目录删除成功");
        }
        // 创建目录(递归)
        file = new File("./dirs/dir1");
        flag = file.mkdirs();
        if (flag) {
            System.out.println("创建目录成功");
        }
        flag = file.delete();
        if (flag) {
            System.out.println("目录删除成功");
        }
        // 列出下级目录
        file = new File("src");
        String[] subDirs = file.list();
        if (subDirs != null) {
            System.out.println("下级目录：");
            for (String dirName : subDirs) {
                System.out.print(dirName + "\t");
            }
            System.out.println();
        }
        // 列出下级文件
        file = new File("./");
        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            System.out.println("下级文件：");
            for (File f : subFiles) {
                System.out.print(f.getName() + "\t");
            }
        }

    }

    @Test
    /**
     * 7.列出指定目录下的所有目录及文件
     */
    public void T7_ListAllDirsFiles() {
        File dir = new File("./");
        ListAllDirsFiles(dir);
    }

    public void ListAllDirsFiles(File dir) {
        String[] subs = dir.list();
        if (subs == null) {
            System.out.println("目录为空");
            return;
        }
        File file;
        for (String s : subs) {
            file = new File(dir, s);
            if (file.isDirectory()) {
                System.out.println("-- " + s);
                ListAllDirsFiles(file, "\t");
            } else {
                System.out.println("\t| " + s);
            }
        }
    }

    public void ListAllDirsFiles(File dir, String separate) {
        String[] subs = dir.list();
        if (subs == null) {
            System.out.println("目录为空");
            return;
        }
        File file;
        for (String s : subs) {
            file = new File(dir, s);
            if (file.isDirectory()) {
                System.out.println(separate + "-- " + s);
                ListAllDirsFiles(file, separate + "\t");
            } else {
                System.out.println(separate + "| " + s);
            }
        }
    }

    @Test
    /**
     * 8.统计文件夹大小
     */
    public void T8_CountFolderSize() {
        File file = new File("/home/centuryw/图片");
        CountFolderSize(file);
        System.out.println("文件夹大小为:"+folderSize+"字节");
        System.out.println("文件夹大小为:"+(int)(CountFolderSize2(file))+"字节");
        // 使用类
        DirCount dirCount = new DirCount("/home/centuryw/图片");
        System.out.println("文件夹大小为:"+dirCount.getSize()+"字节");
        System.out.println("文件夹个数为:"+dirCount.getDirCount());
        System.out.println("文件个数为:"+dirCount.getFileCount());
    }

    public static long folderSize = 0;
    public void CountFolderSize(File folder) {
        // 获取大小
        if (folder!=null && folder.exists()){
            // 如果是文件，统计大小，否则
            if (folder.isFile()){
                folderSize += folder.length();
            }else{
                for (File f:folder.listFiles()){
                    CountFolderSize(f);
                }
            }
        }
    }

    public double CountFolderSize2(File folder){
        long sumSize = 0;
        // 目标是否为目录，是目录扫描全部，否则返回文件大小
        if (folder.isDirectory()){
            // 获取目录下所有目录
            File[] files = folder.listFiles();
            for (File f:files){
                if (f.isFile()){
                    sumSize += f.length();
                }else{
                    sumSize += CountFolderSize2(f);
                }
            }
            return sumSize;
        }else{
            return folder.length();
        }
    }

}



class DirCount{
    private long size;  // 目录大小
    private File root; // 源目录
    private int fileCount;  // 文件个数
    private int dirCount = -1;   // 目录个数(减去本身 本身也被统计了)

    public DirCount(String dirName){
        root = new File(dirName);
        count(root);
    }

    private void count(File folder) {
        // 获取大小
        if (folder!=null && folder.exists()){
            // 如果是文件，统计大小，否则
            if (folder.isFile()){
                size += folder.length();
                fileCount += 1;
            }else{
                dirCount += 1;
                for (File f:folder.listFiles()){
                    count(f);
                }
            }
        }
    }

    public long getSize() {
        return size;
    }


    public int getFileCount() {
        return fileCount;
    }


    public int getDirCount() {
        return dirCount;
    }

}