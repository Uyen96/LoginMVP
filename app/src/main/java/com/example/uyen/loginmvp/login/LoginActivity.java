package com.example.uyen.loginmvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uyen.loginmvp.MainActivity;
import com.example.uyen.loginmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View,
        android.view.View.OnClickListener {

    private EditText mTextUserName;
    private EditText mTextPassword;
    private Button mButtonLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        registerListener();
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.setView(this);
    }

    public void initView() {
        mTextUserName = findViewById(R.id.text_user_name);
        mTextPassword = findViewById(R.id.text_password);
        mButtonLogin = findViewById(R.id.button_login);
    }

    private void registerListener() {
        mButtonLogin.setOnClickListener(this);
    }


    @Override
    public void loginSuccess() {
        Toast.makeText(this, getResources().getText(R.string.message_success),
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFailed(int error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(android.view.View v) {
        if (v.getId() == R.id.button_login) {
            login();
        }
    }

    private void login() {
        String username = mTextUserName.getText().toString();
        String password = mTextPassword.getText().toString();
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, getResources().
                            getText(R.string.message_empty),
                    Toast.LENGTH_SHORT).show();
        }
        mLoginPresenter.handleLogin(username, password);
    }
}
