package com.example.zgh.acproj.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.zgh.acproj.ConnectManger;
import com.example.zgh.acproj.NoSuchUserException;
import com.example.zgh.acproj.R;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {

    ConnectManger connectManger = ConnectManger.getConnectManger();
    EditText userID;
    EditText passworld;
    TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        userID = findViewById(R.id.userIDV);
        passworld = findViewById(R.id.userPassWordV);
        warning = findViewById(R.id.warnV);
    }

    public void logIn(View view) {
        // TODO: 2018/11/29 登录按钮
        String userID = this.userID.getText().toString();
        String passworld = this.passworld.getText().toString();
        User currU = null;
        try {
            currU = connectManger.getUser(userID);
        } catch (SQLException | NoSuchUserException e) {
            e.printStackTrace();
        }
        if(currU != null){
            if(currU.getPassWorld().equals(passworld))
                Toast.makeText(this,"OKKKK!!!",Toast.LENGTH_LONG).show();
            else
                warning.setText("错误的密码");
        }
    }

    public void findPassWord(View view) {
        // TODO: 2018/11/29 找回密码
    }

    public void register(View view) {
        // TODO: 2018/11/29 注册
    }
}
