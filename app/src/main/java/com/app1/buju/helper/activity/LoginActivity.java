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
import com.app1.buju.helper.util.ShareUtil;
import com.app1.buju.helper.util.ShareXmlUtil;
import com.app1.buju.helper.view.MyEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private MyEditText usernameEditText;
    private MyEditText passwordEditText;
    private Button loginButtom;
    private TextView registTextView;

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
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        usernameEditText = (MyEditText) findViewById(R.id.user_name_login_et);
        passwordEditText = (MyEditText) findViewById(R.id.pass_word_login_et);
        loginButtom = (Button) findViewById(R.id.login_btn);
        registTextView = (TextView) findViewById(R.id.regist_tv);
        //加入点击监听
        loginButtom.setOnClickListener(this);
        registTextView.setOnClickListener(this);
        //加入观察者
        usernameEditText.addTextChangedListener(watcher);
        passwordEditText.addTextChangedListener(watcher);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                submitLogin();
                break;
            case R.id.regist_tv:
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                finish();
                break;

        }
    }
/*提交登录信息*/
    private void submitLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        if(isName && isPassword){
            UserModelBean userModelBean = LocalDataModel.getInstance().selectUser(username);

            if(userModelBean == null){
                Toast.makeText(this,"您输入的用户名或密码有误，请重新输入",Toast.LENGTH_SHORT).show();
                return;
            }
            if((username.equals(userModelBean.getUsername()))&&(password.equals(userModelBean.getPassword()))){
                new ShareXmlUtil(this).write(Const.LOGINUSERNAME,username);
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }else{
                Toast.makeText(this,"您输入的密码有误，请重新输入",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
