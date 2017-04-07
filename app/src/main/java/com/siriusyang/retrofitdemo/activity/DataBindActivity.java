package com.siriusyang.retrofitdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.siriusyang.retrofitdemo.R;
import com.siriusyang.retrofitdemo.databinding.DatabindactivityBinding;
import com.siriusyang.retrofitdemo.modle.User;

/**
 * Created by jack on 2016/7/aaa.
 */
public class DataBindActivity extends AppCompatActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabindactivityBinding databindactivityBinding = DataBindingUtil.setContentView(this, R.layout.databindactivity);
        databindactivityBinding.setUser(new User("样", "谁说的"));
    }
}
