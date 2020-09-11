package com.example.iap_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.iap_project.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText fname,emailA,password,Cpassword;
    Button register;
    TextView signin;
    FirebaseAuth mFirebaseAuth;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.password,".{5,}",R.string.invalid_password);
        awesomeValidation.addValidation(this,R.id.Cpassword,R.id.password,R.string.invalid_confirm_password);

        mFirebaseAuth = FirebaseAuth.getInstance();
        fname = findViewById(R.id.fname);
        emailA = findViewById(R.id.emailA);
        password = findViewById(R.id.password);
        Cpassword = findViewById(R.id.Cpassword);
        register = findViewById(R.id.register);
        signin = findViewById(R.id.signin);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fname.getText().toString();
                String email = emailA.getText().toString();
                String pwd = password.getText().toString();
                String cpwd = Cpassword.getText().toString();
                if(name.isEmpty()){
                    fname.setError("Please enter your name");
                }
                else if(email.isEmpty()){
                    emailA.setError("Please enter your Email Address");
                }
                else if(pwd.isEmpty()){
                    password.setError("Password field is empty");
                }
                else if(cpwd.isEmpty()){
                    Cpassword.setError("Confirm password field is empty");
                }
                else if(!(awesomeValidation.validate())){
                    Cpassword.setError("Password and Confirm Password should match");
                }
                else if(name.isEmpty() && email.isEmpty() && pwd.isEmpty() && cpwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }
                else if(!(name.isEmpty() && email.isEmpty() && pwd.isEmpty() && cpwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Registration Unsuccessful",Toast.LENGTH_SHORT).show();
                            }

                            else{
                                startActivity(new Intent(MainActivity.this, Vendor.class));
                                Toast.makeText(MainActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
                else {
                    Toast.makeText(MainActivity.this,"Error Occurred. Please try again",Toast.LENGTH_SHORT).show();
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToSignin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intToSignin);
            }
        });

    }
}



