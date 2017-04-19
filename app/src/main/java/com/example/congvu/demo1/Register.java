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

public class Register extends AppCompatActivity {


    EditText edtEmail, edtPass, edtConfirm;
    private Button btnRegister;
    private TextView txtBack;
    FirebaseAuth mAuth;
    //private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);

        mAuth = FirebaseAuth.getInstance();
        //Anh xa
        Dialog_Register();

        //progressDialog = new ProgressDialog(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RegisterUser();
            }
        });
        txtBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent backLogin = new Intent(Register.this,Login.class);
                startActivity(backLogin);
            }
        });
    }

    private void RegisterUser(){
        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();

       /* if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Vui lòng nhập email của ban!",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Vui lòng nhập Password của bạn!",Toast.LENGTH_LONG).show();
            return;
        }*/

       // progressDialog.setMessage("Vui lòng chờ trong ít giây!");
        //progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Register.this, "Đã xảy ra lỗi!", Toast.LENGTH_SHORT).show();
                        }
                       // progressDialog.dismiss();
                    }
                });

    }
    private void Dialog_Register(){
        edtEmail     = (EditText)findViewById(R.id.editTextEmail);
        edtPass      = (EditText)findViewById(R.id.editTextPass);
        edtConfirm   = (EditText)findViewById(R.id.editTextConfirmPass);
        btnRegister  = (Button)findViewById(R.id.buttonRegister);
        txtBack      = (TextView)findViewById(R.id.textViewBackLogin);
    }
}
