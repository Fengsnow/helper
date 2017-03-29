package com.app1.buju.helper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app1.buju.helper.Bean.UserModelBean;
import com.app1.buju.helper.R;
import com.app1.buju.helper.model.Const;
import com.app1.buju.helper.model.LocalDataModel;
import com.app1.buju.helper.util.ShareXmlUtil;
import com.app1.buju.helper.view.MyEditText;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    private MyEditText usernameEditText;
    private MyEditText passwordEditText;
    private Button registButtom;
    private TextView loginTextView;

    private boolean isName;
    private boolean isPassword;

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //用户名限制到2到16位
            if(usernameEditText.getText().toString().trim().matches("^([\\S\\s]){3,16}")){
                usernameEditText.setImageVisible(true);
                isName=true;
            }else{
                usernameEditText.setImageVisible(false);
                isName=false;
            }
            //密码限制6到16位
            if(passwordEditText.getText().toString().trim().matches("^([\\S\\s]){6,16}")){
                passwordEditText.setImageVisible(true);
                isPassword=true;
            }else{
                passwordEditText.setImageVisible(false);
                isPassword=false;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        initView();
    }

    private void initView() {
        usernameEditText = (MyEditText) findViewById(R.id.user_name_regist_et);
        passwordEditText = (MyEditText) findViewById(R.id.pass_word_regist_et);
        registButtom = (Button) findViewById(R.id.regist_btn);
        loginTextView = (TextView) findViewById(R.id.login_tv);
        //加入点击监听
        registButtom.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
        //加入观察者
        usernameEditText.addTextChangedListener(watcher);
        passwordEditText.addTextChangedListener(watcher);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regist_btn:
                submitRegist();
                break;
            case R.id.login_tv:
                startActivity(new Intent(RegistActivity.this,LoginActivity.class));
                finish();
                break;

        }
    }
    /*提交登录信息*/
    private void submitRegist() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        if(isName && isPassword){
            //保存
            UserModelBean user = new UserModelBean();
            user.setUsername(username);
            user.setPassword(password);
           LocalDataModel.getInstance().saveuser(user);

            new ShareXmlUtil(this).write(Const.LOGINUSERNAME,username);
            startActivity(new Intent(RegistActivity.this,MainActivity.class));
            finish();

        }
    }
}
