package com.siriusyang.retrofitdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siriusyang.retrofitdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jack on 2016/7/aaa.
 */
public class DanMuActivity extends AppCompatActivity {
    @Bind(R.id.llDanMuBody)
    LinearLayout llDanMuBody;
    @Bind(R.id.btnAdd)
    Button btnAdd;
    @Bind(R.id.ll_swip)
    LinearLayout llSwip;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danmu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAdd)
    public void onViewClicked() {
        TextView tvDanmu = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.setMargins(50,0,50,50);
        tvDanmu.setPadding(20,10,10,20);
        tvDanmu.setLayoutParams(lp);
        tvDanmu.setBackground(this.getResources().getDrawable(R.drawable.shape_progress_background));
        tvDanmu.setText("社保局开始编辑就开始年就开始电脑城几点睡");
        tvDanmu.setTextColor(getResources().getColor(R.color.white));
        if (llDanMuBody.getChildCount() >= 2) {
            llDanMuBody.removeViewAt(0);
        }
        llDanMuBody.addView(tvDanmu);
        ObjectAnimator dissAnimator = ObjectAnimator.ofFloat(tvDanmu, "alpha", 1f, 0.7f, 0f);
        dissAnimator.setDuration(3000);
        dissAnimator.start();

        dissAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                View vew = (View) ((ObjectAnimator) animation).getTarget();
                if (vew != null) {
                    llDanMuBody.removeView(vew);
                }
            }
        });

    }
}
