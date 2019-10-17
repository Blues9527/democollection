package com.example.encrypdemo;

/**
 * User : Blues
 * Date : 2019/10/14
 * Time : 14:17
 */

public class Test {

    public static void main(String[] args) {
        String a = "Hello";

        String b = EncryptUtils.encodeData(a);
        String c = EncryptUtils.decodeData(b);

        System.out.println(b);
        System.out.println(c);

        System.out.println(EncryptUtils.MD5Encode(a, ""));
    }
}
