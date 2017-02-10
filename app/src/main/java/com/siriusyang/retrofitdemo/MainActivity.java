package com.siriusyang.retrofitdemo;

import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.siriusyang.retrofitdemo.activity.AnimationActivity;
import com.siriusyang.retrofitdemo.activity.DataBindActivity;
import com.siriusyang.retrofitdemo.activity.NetRequestActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.image)
    ImageView image;

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
//    @OnClick(R.id.btnAnimation22)
//    public void wwww() {
//        Toast.makeText(this,"sss",Toast.LENGTH_LONG).show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Toast.makeText(this,"hydgkfd",Toast.LENGTH_LONG).show();

        final ClipDrawable drawable = (ClipDrawable)image.getDrawable();
        final Handler handler = new Handler()
        {
            public void handleMessage(Message msg)
            {
                if(msg.what == 0x1233)
                {
                    //修改ClipDrawable的level值
                    drawable.setLevel(drawable.getLevel() +100);
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            public void run()
            {
                Message msg = new Message();
                msg.what = 0x1233;
                //发送消息,通知应用修改ClipDrawable对象的level值
                handler.sendMessage(msg);
                //取消定时器
                if(drawable.getLevel() >= 10000)
                {
                    timer.cancel();
                }
            }
        },0,1000);
    }

}
