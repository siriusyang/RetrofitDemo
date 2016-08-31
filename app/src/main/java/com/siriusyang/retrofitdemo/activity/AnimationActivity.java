package com.siriusyang.retrofitdemo.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.siriusyang.retrofitdemo.R;
import com.siriusyang.retrofitdemo.weigets.WaveView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity {

    @Bind(R.id.iv_music) ImageView iv_music;
    @Bind(R.id.ll_swip) LinearLayout swipeView;
    @Bind(R.id.wv_wave)
    WaveView wv_wave;
    private static ColorStateList sColorStatePlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        ButterKnife.bind(this);

        //音乐动画
        if (sColorStatePlaying == null) {
            initializeColorStateLists(this);
        }
        AnimationDrawable animation = (AnimationDrawable)
                ContextCompat.getDrawable(this, R.drawable.ic_equalizer_white_36dp);
        DrawableCompat.setTintList(animation, sColorStatePlaying);
        iv_music.setImageDrawable(animation);
        animation.start();

        //水波
        wv_wave.setColor(Color.parseColor("#ff0000"));
        wv_wave.setInterpolator(new LinearOutSlowInInterpolator());
        wv_wave.start();
        CoordinatorLayout.LayoutParams coordinatorParams =
                (CoordinatorLayout.LayoutParams) swipeView.getLayoutParams();
        SwipeDismissBehavior<View> swip = new SwipeDismissBehavior<View>();
        swip.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
        swip.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override public void onDismiss(View view) {
                finish();
            }

            @Override public void onDragStateChanged(int state) {
                Log.i("state", "state=" + state);
            }
        });
        coordinatorParams.setBehavior(swip);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    static private void initializeColorStateLists(Context ctx) {
        sColorStatePlaying = ColorStateList.valueOf(ctx.getResources().getColor(
                R.color.media_item_icon_playing));
    }
}
