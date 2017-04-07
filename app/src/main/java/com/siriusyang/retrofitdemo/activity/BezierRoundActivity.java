package com.siriusyang.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.siriusyang.retrofitdemo.R;
import com.siriusyang.retrofitdemo.weigets.BezierRoundView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class BezierRoundActivity extends AppCompatActivity {


    @Bind(R.id.brView)
    BezierRoundView brView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_round);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
//        brView
    }

}
