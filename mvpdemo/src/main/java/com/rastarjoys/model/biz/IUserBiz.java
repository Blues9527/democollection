package com.rastarjoys.model.biz;

/**
 * Created by Administrator on 2018/05/21.
 */

public interface IUserBiz {

    void login(String username, String password, OnLoginListener onLoginListener);
}
