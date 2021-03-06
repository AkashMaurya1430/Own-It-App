package com.example.own_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.registerText2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
    }

    private Boolean validateName(){
        TextInputLayout name = (TextInputLayout)findViewById(R.id.name);

        String val = name.getEditText().getText().toString();

        if (val.isEmpty()){
            name.setError("Field cannot be empty");
            return false;
        }else{
            name.setError(null);
            return true;
        }
    }

    private Boolean validateMobileNo(){
        TextInputLayout mobileNumber = (TextInputLayout)findViewById(R.id.mobileNumber);

        String val = mobileNumber.getEditText().getText().toString();

        if (val.isEmpty()){
            mobileNumber.setError("Field cannot be empty");
            return false;
        }else if(val.length() != 10){
            mobileNumber.setError("Invalid contact");
            return false;
        } else{
            mobileNumber.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        TextInputLayout password = (TextInputLayout)findViewById(R.id.password);

        String val = password.getEditText().getText().toString();

        if (val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }else{
            password.setError(null);
            return true;
        }
    }

    public void register(View view){
        if(!validateName() | !validateMobileNo()){
            return;
        }
    }
}