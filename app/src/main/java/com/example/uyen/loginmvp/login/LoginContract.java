package com.example.uyen.loginmvp.login;

public interface LoginContract {

    interface View {
        void loginSuccess();

        void loginFailed(int error);
    }

    interface Presenter {
        void handleLogin(String username, String password);
    }
}
