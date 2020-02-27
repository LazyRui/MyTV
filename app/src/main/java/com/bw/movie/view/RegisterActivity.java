package com.bw.movie.view;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.user.LoginContract;
import com.bw.movie.contract.user.RegisterContract;
import com.bw.movie.entity.user.LoginEntity;
import com.bw.movie.presenter.user.LoginPresenter;
import com.bw.movie.presenter.user.RegisterPresenter;
import com.bw.movie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.IView {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.but_register)
    Button butRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {


    }

    @Override
    protected RegisterPresenter initPrenseter() {
        return new RegisterPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.but_register)
    public void butRegister(View view) {
        String email = etEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            return;
        }
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            return;
        }

       mPresenter.getRegisterData("",email, EncryptUtil.encrypt(password),"");

        Log.e("xxx","================="+EncryptUtil.encrypt(password));

    }

    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity != null) {
            Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }
}
