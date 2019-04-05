package com.space;

import java.util.ArrayList;
import java.util.OptionalDouble;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/04/05
 */
public class ListStream {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(3);
//        arrayList.add(6);
        OptionalDouble average = arrayList.stream().mapToInt(Integer::shortValue).average();
        double v = average.orElse(0.0);
        System.out.println((int)v);
    }
}
