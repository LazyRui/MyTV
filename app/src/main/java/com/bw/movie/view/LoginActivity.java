package com.bw.movie.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.user.LoginContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.presenter.user.LoginPresenter;
import com.bw.movie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.IView {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    /* @BindView(R.id.but_login)
     Button butLogin;*/
    @BindView(R.id.but_go_register)
    Button butGoRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //WRuiTao@1314520.

    }

    @Override
    protected LoginPresenter initPrenseter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.but_login)
    public void butLogin(View view) {
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            return;
        }
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            return;
        }

        mPresenter.getLoginData(email, EncryptUtil.encrypt(password));

        Log.e("xxx", "=================" + EncryptUtil.encrypt(password));

    }

    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity != null) {
            Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.but_go_register)
    public void onViewClicked() {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}
