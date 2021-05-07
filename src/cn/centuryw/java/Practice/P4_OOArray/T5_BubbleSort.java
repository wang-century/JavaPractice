package cn.centuryw.java.Practice.P4_OOArray;

import java.util.Arrays;

/**
 * @author centuryw
 * @version 1.0
 * @description: 冒泡排序
 * @date 2021/5/7 下午5:57
 */
public class T5_BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {20,14,31,10,70,993};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(bubbleSort(numbers)));
    }
    /** 
     * @description: 冒泡排序
     * @param: numbers 数组
     * @return: int[] 排序结果
     * @author centuryw
     * @date: 2021/5/7 下午6:21
     */ 
    public static int[] bubbleSort(int[] numbers){
        int temp;
        for (int i=0;i<numbers.length;i++){
            for (int j=0;j<numbers.length-1-i;j++){
                if (numbers[j]>numbers[j+1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        return numbers;
    }
}
