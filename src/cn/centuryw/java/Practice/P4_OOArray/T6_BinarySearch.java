package cn.centuryw.java.Practice.P4_OOArray;

import java.util.Arrays;

/**
 * 二分法查找(折半检索)
 * 注：需要先排序
 */
public class T6_BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {30, 50, 80, 9, 7, 12, 100, 20, 14, 31, 10, 70, 993};
        // 排序
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int value = 993; // 要查找的数
        // 二分查找
        int flag = binarySearch(numbers, value);
        if (flag != -1) {
            System.out.println("找到该值, 索引为:" + flag);
        } else {
            System.out.println("未找到该值");
        }
    }

    /**
     * 折半查找
     *
     * @param numbers 原数组
     * @param value   要查找的值
     * @return 索引值  未找到返回-1
     */
    public static int binarySearch(int[] numbers, int value) {
        // 初始化 头部、尾部、中部
        int start = 0, end = numbers.length - 1;
        while (start<=end) {
            int mid = (start + end) / 2;
            System.out.println(start + "," + end + "," + mid + "-" + numbers[mid]);
            // 判断中部值是否为要找的数
            if (numbers[mid] == value) {
                return mid;
            }
            if (value > numbers[mid]) {
                start = mid + 1;
            }
            if (value < numbers[mid]) {
                end = mid - 1;
            }

        }
        return -1;
    }

}
