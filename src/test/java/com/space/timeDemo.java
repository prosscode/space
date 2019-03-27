package com.space;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/16
 */
public class timeDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        String yesterday = new SimpleDateFormat( "yyyyMMddHHmmss").format(cal.getTime());
        System.out.println(yesterday);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,   0);
        String today = new SimpleDateFormat( "yyyy-MM-dd 00:00:00").format(calendar.getTime());
        System.out.println(today);
    }
}
