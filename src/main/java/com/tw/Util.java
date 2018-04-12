package com.tw;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: student-grade-command-basic-java
 * @description: 工具类
 * @author: liust
 * @create: 2018-04-12 14:52
 **/
public class Util {

    //获取输入值
    public String getEnter() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Double GetMedian(List<Integer> list) {
        double middle = 0;
        int size = list.size();
        if (size != 0) {
            Integer[] array = (Integer[]) list.toArray(new Integer[size]);
            Arrays.sort(array);
            if (size % 2 == 0) {
                middle = (array[size / 2 - 1] + array[size / 2]) / 2.0;
            } else {
                int inx = size / 2;
                middle = array[inx];
            }
        }
        return middle;
    }
}
