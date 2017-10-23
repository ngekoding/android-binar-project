package com.example.nur.belajaronline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsername, mPassword;
    private Button mBtnLogin, mBtnRegister;


    private AwesomeValidation mValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getInit();
        setValidation();
    }

    private void getInit() {
        mUsername = (EditText) findViewById(R.id.et_login_username);
        mPassword = (EditText) findViewById(R.id.et_login_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login_submit);
        mBtnRegister = (Button) findViewById(R.id.btn_login_register);

        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
    }

    private void setValidation() {
        mValidation = new AwesomeValidation(ValidationStyle.UNDERLABEL);
        mValidation.setContext(this);

        mValidation.addValidation(this, R.id.et_login_username, RegexTemplate.NOT_EMPTY, R.string.validation_error_username);
        mValidation.addValidation(this, R.id.et_login_password, RegexTemplate.NOT_EMPTY, R.string.validation_error_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_login_submit:
                if (mValidation.validate()) {
                    Toast.makeText(this, "Do login.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
