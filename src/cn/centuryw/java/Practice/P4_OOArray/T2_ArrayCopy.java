package cn.centuryw.java.Practice.P4_OOArray;

import org.junit.Test;

/**
 * @author centuryw
 * @version 1.0
 * @description: 数组的拷贝
 * @date 2021/5/6 下午5:20
 */
public class T2_ArrayCopy {
    /**
     * @description: 数组拷贝
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 上午11:41
     */
    @Test
    public void T1_() {
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        // 参数：源数组，开始位置索引，目标数组，开始位置索引，拷贝长度
        System.arraycopy(s1, 2, s2, 3, 3);
        for (String s : s2) {
            System.out.println(s);
        }
    }

    /**
     * @description: 从数组中删除元素(本质是数组拷贝)
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 上午11:50
     */
    @Test
    public void T2_() {
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = deleteArrayElementByIndex(s1,2);
        for (String s:s2){
            System.out.println(s);
        }

    }

    /**
     * @description: 删除数组指定位置元素并将原数组返回
     * @param: index 索引
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 上午11:55
     */
    public String[] deleteArrayElementByIndex(String[] s, int index) {
        System.arraycopy(s,index+1,s,index,s.length-index-1);
        s[s.length-1] = null;
        return s;
    }


    /**
     * @description: 数组尾部插入元素
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 下午12:11
     */
    @Test
    public void T3_(){
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        s1 = extendArrayElement(s1,"nihao");
        for (String s:s1){
            System.out.println(s);
        }
    }
    /**
     * @description:  数组尾部插入元素(本质是定义一个更大的数组，将原数组原封不动拷贝到新数组中)
     * @param: s    源数组
     * @param: element 插入的元素
     * @return: java.lang.String[] 插入后的数组
     * @author centuryw
     * @date: 2021/5/7 下午12:17
     */
    public String[] extendArrayElement(String[] s,String element){
        String[] strings = new String[s.length+1];  // 创建新数组
        System.arraycopy(s,0,strings,0,s.length);
        strings[strings.length-1] = element;
        return strings;
    }
}
