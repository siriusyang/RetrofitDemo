package com.siriusyang.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.siriusyang.retrofitdemo.activity.AnimationActivity;
import com.siriusyang.retrofitdemo.activity.DataBindActivity;
import com.siriusyang.retrofitdemo.activity.NetRequestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.btnDataBind)
    public void jumpToDataBindActivity() {
        Intent jumpToNetRequestActivity = new Intent(this, DataBindActivity.class);
        startActivity(jumpToNetRequestActivity);
    }

    @OnClick(R.id.btnNetRequest)
    public void jumpToNetRequestActivity() {
        Intent jumpToNetRequestActivity = new Intent(this, NetRequestActivity.class);
        startActivity(jumpToNetRequestActivity);
    }

    @OnClick(R.id.btnAnimation)
    public void jumpToMusicActivity() {
        Intent intentMusicActivity = new Intent(this, AnimationActivity.class);
        startActivity(intentMusicActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
