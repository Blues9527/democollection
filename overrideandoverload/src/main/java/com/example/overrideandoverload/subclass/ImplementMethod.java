package com.example.overrideandoverload.subclass;

import com.example.overrideandoverload.abstracrclass.AbstractMethod;
import com.example.overrideandoverload.interfaces.InterfaceMethod;

/**
 * User : Blues
 * Date : 2019/4/22
 * Time : 14:57
 */

public class ImplementMethod extends AbstractMethod {

    @Override
    public int doIt() {
        return 0;
    }

    @Override
    public void reDoIt() {

    }

    @Override
    public void retryIt() {

    }

    @Override
    public String charToString(char varchar) {
        return super.charToString(varchar);
    }


    public void tryIt(int code) {
    }

    private void tryIt(String message) {

    }

    protected String tryIt(int code, String message) throws Exception {

        return "";
    }

}
