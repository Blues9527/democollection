package com.rastarjoys.view;

import com.rastarjoys.model.bean.User;

/**
 * Created by Administrator on 2018/05/21.
 */

public interface IUserLoginView {
    String getUsername();

    String getPassword();

    void  showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

    void clearUserName();

    void clearPassword();

}
