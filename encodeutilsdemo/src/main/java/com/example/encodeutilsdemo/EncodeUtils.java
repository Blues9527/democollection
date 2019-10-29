package com.example.encodeutilsdemo;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * User : Blues
 * Date : 2019/5/16
 * Time : 14:10
 */

public class EncodeUtils {

    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    public static byte[] encodeParameters(Map<String, String> params, String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        if (TextUtils.isEmpty(paramsEncoding))
            paramsEncoding = DEFAULT_PARAMS_ENCODING;
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(
                            String.format(
                                    "Request#getParams() or Request#getPostParams() returned a map "
                                            + "containing a null key or value: (%s, %s). All keys "
                                            + "and values must be non-null.",
                                    entry.getKey(), entry.getValue()));
                }
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }
}
