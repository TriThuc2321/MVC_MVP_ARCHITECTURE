package com.example.mvparchitecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginInterface {
    EditText emailEdt;
    EditText passwordEdt;
    Button loginBtn;
    TextView messageTxt;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdt = findViewById(R.id.edtEmail);
        passwordEdt = findViewById(R.id.edtPassword);
        loginBtn = findViewById(R.id.btnLogin);
        messageTxt = findViewById(R.id.txtLogin);

        loginPresenter = new LoginPresenter(this);
        
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClick();
            }
        });
    }

    private void loginClick() {
        String email = emailEdt.getText().toString();
        String password = passwordEdt.getText().toString();
        User user = new User(email, password);

        loginPresenter.login(user);
    }


    @Override
    public void loginSuccess() {
        messageTxt.setText("Login success");
        messageTxt.setVisibility(View.VISIBLE);
        messageTxt.setTextColor(getResources().getColor(R.color.teal_700));
    }

    @Override
    public void loginError() {
        messageTxt.setText("Email or Password invalid");
        messageTxt.setVisibility(View.VISIBLE);
        messageTxt.setTextColor(getResources().getColor(R.color.red));
    }
}