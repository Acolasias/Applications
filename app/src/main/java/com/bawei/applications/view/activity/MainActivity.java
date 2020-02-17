package com.bawei.applications.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.applications.R;
import com.bawei.applications.base.BaseActivity;
import com.bawei.applications.contract.IRegisterAndLoginContract;
import com.bawei.applications.model.bean.LoginBean;
import com.bawei.applications.model.bean.RegisterBean;
import com.bawei.applications.presenter.RegisterAndLoginPresenter;
import com.blankj.utilcode.util.EncryptUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<RegisterAndLoginPresenter> implements IRegisterAndLoginContract.IView {

    @BindView(R.id.edt_phone)
    EditText edt_Phone;
    @BindView(R.id.edt_pwd)
    EditText edt_Pwd;
    @BindView(R.id.btn_login)
    Button btn_Login;
    @BindView(R.id.btn_register)
    Button btn_Register;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegisterAndLoginPresenter providerPresenter() {
        return new RegisterAndLoginPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRegisterSueccess(RegisterBean bean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSueccess(LoginBean bean) {
        Intent intent = new Intent(MainActivity.this, OrderformActivity.class);
        startActivity(intent);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String phones = edt_Phone.getText().toString();
                String pwdss = edt_Pwd.getText().toString();
                String pwds = EncryptUtils.encryptMD5ToString(pwdss);
                String substring1 = pwds.substring(0, 6);
                mPresenter.onLoginData(phones,substring1);
                break;
            case R.id.btn_register:
                String phone = edt_Phone.getText().toString();
                String pwd = edt_Pwd.getText().toString();
                String pwd1 = EncryptUtils.encryptMD5ToString(pwd);
                String substring = pwd1.substring(0, 6);
                mPresenter.onRegisterData(phone,substring);
                break;
        }
    }
}
