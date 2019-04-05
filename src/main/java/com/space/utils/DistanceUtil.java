package com.space.utils;

/**
 * @describe: 计算经纬度之间的距离
 * @author: 彭爽pross
 * @date: 2019/04/04
 */
public class DistanceUtil {

    // 地球半径
    private static double EARTH_RADIUS = 6378137;

    /** 计算距离*/
    public static double getDistance(double longShop, double latShop, double longUser, double latUser) {
        double a, b;
        latShop = latShop * Math.PI / 180.0;
        latUser = latUser * Math.PI / 180.0;
        a = latShop - latUser;
        b = (longShop - longUser) * Math.PI / 180.0;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        double distance = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(latShop) * Math.cos(latUser) * sb2 * sb2));
        return distance;
    }

    public static void main(String[] args) {
        double distance = DistanceUtil.getDistance(114.034039,22.578353, 114.066329, 22.575161);
        System.out.println((int)distance);
    }
}
