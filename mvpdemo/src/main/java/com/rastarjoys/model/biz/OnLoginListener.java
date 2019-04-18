package com.rastarjoys.model.biz;

import com.rastarjoys.model.bean.User;

/**
 * Created by Administrator on 2018/05/21.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFail();
}
