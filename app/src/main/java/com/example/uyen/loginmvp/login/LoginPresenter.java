package com.example.uyen.loginmvp.login;

import com.example.uyen.loginmvp.R;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mLoginView;

    public void setView(LoginContract.View view) {
        mLoginView = view;
    }

    @Override
    public void handleLogin(String username, String password) {
        if (username.equals("uyen") &&
                password.equals("1234")) {
            mLoginView.loginSuccess();
            return;
        } else
            mLoginView.loginFailed(R.string.message_failed);
    }
}
