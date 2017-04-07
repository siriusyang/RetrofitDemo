package com.siriusyang.retrofitdemo.activity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.siriusyang.retrofitdemo.R;
import com.siriusyang.retrofitdemo.weigets.ButtonProgressBar;
import com.siriusyang.retrofitdemo.weigets.GradientPolygonView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProgressActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    @Bind(R.id.sp_select_type)
    Spinner mLoaderTypeSp;
    @Bind(R.id.cl_main)
    ButtonProgressBar mButtonProgressBar;
    @Bind(R.id.cl_main2)
    GradientPolygonView mGradientPolygonView;
    private int progress = 0;
    @Bind(R.id.image)
    ImageView image;
    private Timer timer = null;
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x1233) {
                //修改ClipDrawable的level值
                drawable.setLevel(drawable.getLevel() + 100);
            }
        }
    };
    ;
    private ClipDrawable drawable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        drawable = (ClipDrawable) image.getDrawable();

        timer = new Timer();

        mLoaderTypeSp.setOnItemSelectedListener(this);
    }

    @OnClick({R.id.rlProgress, R.id.cl_main, R.id.cl_main2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cl_main:
                mButtonProgressBar.startLoader();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mButtonProgressBar.stopLoader();
                        Toast.makeText(ProgressActivity.this, "Complete", Toast.LENGTH_SHORT).show();
                    }
                }, 5000);
                break;
            case R.id.cl_main2:
                callHandler();
                break;
            case R.id.rlProgress:

                timer.schedule(new TimerTask() {
                    public void run() {
                        Message msg = new Message();
                        msg.what = 0x1233;
                        //发送消息,通知应用修改ClipDrawable对象的level值
                        handler.sendMessage(msg);
                        //取消定时器
                        if (drawable.getLevel() >= 10000) {
                            timer.cancel();
                        }
                    }
                }, 0, 100);
                break;
        }
    }

    private void callHandler() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (progress <= 100) {
                    mGradientPolygonView.setProgress(progress);
                    progress++;
                    callHandler();
                } else {
                    progress = 0;
                    Toast.makeText(ProgressActivity.this, "Complete", Toast.LENGTH_SHORT).show();
                }
            }
        }, 20);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mButtonProgressBar.reset();
        switch (position) {
            case 0:
                mButtonProgressBar.setLoaderType(ButtonProgressBar.Type.DETERMINATE);
                break;
            case 1:
                mButtonProgressBar.setLoaderType(ButtonProgressBar.Type.INDETERMINATE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
