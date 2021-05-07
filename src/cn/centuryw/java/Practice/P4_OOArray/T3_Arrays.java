package cn.centuryw.java.Practice.P4_OOArray;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author centuryw
 * @version 1.0
 * @description: Arrays工具类常用操作
 * @date 2021/5/7 下午4:18
 */
public class T3_Arrays {
    /**
     * @description: 打印数组 Arrays.toString(array)
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 下午4:21
     */
    @Test
    public void T1_(){
        int[] a = {1,2,3};
        System.out.println(Arrays.toString(a));
    }

    /**
     * @description: 数组元素排序
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 下午4:22
     */
    @Test
    public void T2_(){
        int[] a = {1,3,2,323,12,50};
        System.out.println(Arrays.toString(a)); // 无序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a)); // 有序
    }

    /**
     * @description:  引用类型数组排序(需要实现Comparable接口)
     * @param:
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 下午4:34
     */
    @Test
    public void T3_(){
        Person[] persons = {new Person(12,"Lucy"),new Person(24,"Lisi"),new Person(9,"Lili")};
        System.out.println(Arrays.toString(persons));
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));
    }


    class Person implements Comparable{
        int age;
        String name;
        public Person(int age,String name){
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return this.name+"("+this.age+")";
        }


        @Override
        public int compareTo(Object o) {
            Person person = (Person) o;
            if (this.age>person.age){
                return 1;
            }
            if (this.age< person.age){
                return -1;
            }
            return 0;
        }
    }

    /**
     * @description: 二分法查找
     * @return: void
     * @author centuryw
     * @date: 2021/5/7 下午5:04
     */
    @Test
    public void T4_(){
        int[] a = {1,2,3223,23,543,11,24};
        System.out.println(Arrays.toString(a));
        // 使用二分法查找，必须先对数组进行排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        // 查找
        System.out.println("元素543的索引为:"+Arrays.binarySearch(a,543));
    }
}
