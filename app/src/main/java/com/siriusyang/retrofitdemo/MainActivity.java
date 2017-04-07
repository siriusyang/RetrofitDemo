package com.siriusyang.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.siriusyang.retrofitdemo.activity.AnimationActivity;
import com.siriusyang.retrofitdemo.activity.BezierRoundActivity;
import com.siriusyang.retrofitdemo.activity.DataBindActivity;
import com.siriusyang.retrofitdemo.activity.NetRequestActivity;
import com.siriusyang.retrofitdemo.activity.ProgressActivity;
import com.siriusyang.retrofitdemo.navtivemeath.JniUtils;

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

    @OnClick(R.id.btnProgress)
    public void intentProgressActivity() {
        Intent intentProgressActivity = new Intent(this, ProgressActivity.class);
        startActivity(intentProgressActivity);
    }
    @OnClick(R.id.btnBezier)
    public void brView() {
        Intent intentProgressActivity = new Intent(this, BezierRoundActivity.class);
        startActivity(intentProgressActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvNav)
    public void onClick() {
        Toast.makeText(this, JniUtils.getStringFormC(), Toast.LENGTH_LONG).show();
        JniUtils.getStringFormC();
    }
}
