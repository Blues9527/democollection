package com.example.encrypdemo;


import android.annotation.TargetApi;
import android.os.Build;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * User : Blues
 * Date : 2019/10/14
 * Time : 14:07
 */

public class EncryptUtils {


    //================================================== MD5 ==========================================================================

    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param origin      字符
     * @param charsetName 编码
     * @return
     */
    public static String MD5Encode(String origin, String charsetName) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetName || "".equals(charsetName)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }


    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (byte a : b) {
            resultSb.append(byteToHexString(a));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }

    //================================================== Base64 ==========================================================================

    /**
     * 加密字符串
     */
    @TargetApi(Build.VERSION_CODES.O)
    public static String decodeData(String inputData) {
        if (null == inputData) {
            return null;
        }
        return new String(Base64.getDecoder().decode(inputData.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    /**
     * 解密加密后的字符串
     */
    @TargetApi(Build.VERSION_CODES.O)
    public static String encodeData(String inputData) {
        if (null == inputData) {
            return null;
        }
        return new String(Base64.getEncoder().encode(inputData.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }


}
