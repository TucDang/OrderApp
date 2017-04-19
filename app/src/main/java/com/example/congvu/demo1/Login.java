package com.example.congvu.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText edtEmaillogin, edtPasslogin;
    Button btnLogin;
    TextView txtNext, txtNextDish;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);
        mAuth = FirebaseAuth.getInstance();

        Dialog_Login();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextRegister = new Intent(Login.this, Register.class);
                startActivity(nextRegister);
            }
        });
        txtNextDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextDish = new Intent(Login.this, ChonBanAn.class);
                startActivity(nextDish);
            }
        });

    }
    private void LoginUser(){
        String email = edtEmaillogin.getText().toString().trim();
        String password = edtPasslogin.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                            Intent nextDish = new Intent(Login.this, ChonBanAn.class);
                            startActivity(nextDish);
                        }else{
                            Toast.makeText(Login.this, "Đã xảy ra lỗi!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void Dialog_Login(){
        edtEmaillogin  = (EditText)findViewById(R.id.editTextLogin);
        edtPasslogin   = (EditText)findViewById(R.id.editTextPassword);
        btnLogin       = (Button)findViewById(R.id.buttonLogin);
        txtNext        = (TextView)findViewById(R.id.textViewNextRegister);
        txtNextDish    = (TextView)findViewById(R.id.textViewDish);
    }
}
