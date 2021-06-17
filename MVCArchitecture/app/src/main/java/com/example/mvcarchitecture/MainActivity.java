package com.example.mvcarchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText emailEdt;
    EditText passwordEdt;
    Button loginBtn;
    TextView messageTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdt = findViewById(R.id.edtEmail);
        passwordEdt = findViewById(R.id.edtPassword);
        loginBtn = findViewById(R.id.btnLogin);
        messageTxt = findViewById(R.id.txtLogin);

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

        if(user.isValidEmail() && user.isValidPassword()){
            messageTxt.setText("Login success");
            messageTxt.setVisibility(View.VISIBLE);
            messageTxt.setTextColor(getResources().getColor(R.color.teal_700));
        }
        else{
            messageTxt.setText("Email or Password invalid");
            messageTxt.setVisibility(View.VISIBLE);
            messageTxt.setTextColor(getResources().getColor(R.color.red));
        }
    }
}