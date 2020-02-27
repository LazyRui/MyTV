package com.bw.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.base_mvp.BasePresenter;

public class MainActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPrenseter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
