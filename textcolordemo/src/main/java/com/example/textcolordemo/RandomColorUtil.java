package com.example.textcolordemo;

import java.util.Random;

/**
 * User : Blues
 * Date : 2019/7/26
 * Time : 10:14
 */

public class RandomColorUtil {

    private static Random random = new Random();
    private static int[] colors = {0xFFFF0000, 0xFFFF7F00, 0xFFFFFF00, 0xFF00FF00, 0xFF00FFFF, 0xFF0000FF, 0xFF8B00FF};

//    public static void main(String[] args) {
//        int temp;
//        for (int i = 0; i < 20; i++) {
//            System.out.println(temp = random.nextInt(colors.length));
//            System.out.println("======================");
//            System.out.println(colors[temp]);
//        }
//    }

    public static int getRandomColor() {
        return colors[random.nextInt(colors.length)];
    }
}
