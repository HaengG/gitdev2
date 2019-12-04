package com.nslb.membermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nslb.membermanagement.Button.Delete;
import com.nslb.membermanagement.Button.Manage;
import com.nslb.membermanagement.Button.Reading;
import com.nslb.membermanagement.Button.Writing;
import com.nslb.membermanagement.member.GeneralMember;
import com.nslb.membermanagement.member.ManagerMember;
import com.nslb.membermanagement.member.RegularMember;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ManagementListener{

    private String member = null;

    private String regular = "일반회원";
    private String general = "정회원";
    private String manager = "관리자";

    private Button mBtnLogin, mBtnWriting, mBtnDelete, mBtnReading, mBtnManage;
    private EditText mEditLogin, mEditShow;

    private Writing writing = new Writing();
    private Reading reading = new Reading();
    private Delete delete = new Delete();
    private Manage manage = new Manage();

    private GeneralMember g = new GeneralMember();
    private RegularMember r = new RegularMember();
    private ManagerMember m = new ManagerMember();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inintGUI();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_login :
                logindecide();
                break;
            case R.id.btn_writing :
                writing.show();
                break;
            case R.id.btn_delete :
                delete.show();
                break;
            case R.id.btn_reading :
                reading.show();
                break;
            case R.id.btn_manage :
                manage.show();
                break;
        }
    }

    @Override
    public void onManagement(String member) {
        mEditShow.setText(member);
    }

    @Override
    public void onLogin(boolean writing, boolean reading, boolean delete, boolean manage) {
        mBtnWriting.setEnabled(writing);
        mBtnReading.setEnabled(reading);
        mBtnDelete.setEnabled(delete);
        mBtnManage.setEnabled(manage);
    }
    private void inintGUI()
    {
        mBtnLogin = (Button)findViewById(R.id.btn_login);
        mBtnReading = (Button)findViewById(R.id.btn_reading);
        mBtnManage = (Button)findViewById(R.id.btn_manage);
        mBtnWriting = (Button)findViewById(R.id.btn_writing);
        mBtnDelete = (Button)findViewById(R.id.btn_delete);

        mEditLogin = (EditText)findViewById(R.id.edit_login);
        mEditShow = (EditText)findViewById(R.id.edit_show);

        mBtnLogin.setOnClickListener(this);
        mBtnReading.setOnClickListener(this);
        mBtnManage.setOnClickListener(this);
        mBtnWriting.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);

        writing.onManagementListener(this);
        reading.onManagementListener(this);
        delete.onManagementListener(this);
        manage.onManagementListener(this);

        g.onManagementListener(this);
        m.onManagementListener(this);
        r.onManagementListener(this);
    }

    private void logindecide(){
        member = mEditLogin.getText().toString();

        if (member.equals(regular)){
            r.decide();
        }
        else if (member.equals(general)){
            g.decide();
        }
        else if (member.equals(manager)){
            m.decide();
        }
        else {
            Toast.makeText(this, "회원이 아닙니다.", Toast.LENGTH_SHORT).show();
        }

    }
}
