package com.example.nur.belajaronline;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import static com.example.nur.belajaronline.R.id.et_register_phone;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsername, mEmail, mPhone, mPassword, mPasswordConfirm;
    private Button mBtnRegister;
    private Toolbar mToolbar;

    private AwesomeValidation mValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getInit();
        setFormValidation();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void getInit() {
        mUsername = (EditText) findViewById(R.id.et_register_username);
        mEmail = (EditText) findViewById(R.id.et_register_email);
        mPhone = (EditText) findViewById(et_register_phone);
        mPassword = (EditText) findViewById(R.id.et_register_password);
        mPasswordConfirm = (EditText) findViewById(R.id.et_register_password_confirm);
        mBtnRegister = (Button) findViewById(R.id.btn_register_submit);
        mToolbar = (Toolbar) findViewById(R.id.register_toolbar);

        mBtnRegister.setOnClickListener(this);
    }

    private void setFormValidation() {
        mValidation = new AwesomeValidation(ValidationStyle.UNDERLABEL);
        mValidation.setContext(this);

        mValidation.addValidation(this, R.id.et_register_username, RegexTemplate.NOT_EMPTY, R.string.validation_error_username);
        mValidation.addValidation(this, R.id.et_register_email, Patterns.EMAIL_ADDRESS, R.string.validation_error_email);
        mValidation.addValidation(this, R.id.et_register_phone, RegexTemplate.NOT_EMPTY, R.string.validation_error_phone);
        mValidation.addValidation(this, R.id.et_register_password, RegexTemplate.NOT_EMPTY, R.string.validation_error_password);
        mValidation.addValidation(this, R.id.et_register_password_confirm, R.id.et_register_password, R.string.validation_error_password_confirm);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_submit:
                if (mValidation.validate()) {
                    // Do register
                    Toast.makeText(this, "Do register.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
