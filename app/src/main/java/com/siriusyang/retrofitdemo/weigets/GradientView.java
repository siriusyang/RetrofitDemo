package com.siriusyang.retrofitdemo.weigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siriusyang.retrofitdemo.R;

/**
 * Created by sirius on 2017-3-31.
 */

public class GradientView extends View {
    int backgroundColor = Color.parseColor("#0E8DD4");
    private static final int[] COLOR_BLUES = new int[]{
            0xff1db6ff, 0xff1db6ff, 0xff0b58c2, 0xff002a6d
    };
    // 颜色对应的位置数组
    private static final float[] COLOR_LOCATIONS = new float[]{
            0, 0.15f, 0.65f, 1f
    };
    private float SCREEN_HEIGHT_FRACTION = 14f / 15f;
    private int mTotalHeight = 0;
    private int mTotalWidth = 0;
    private int mHalfWidth = 0;
    private RadialGradient mRadialGradient;
    private Paint mLightGradientPaint;

    public GradientView(Context context) {
        this(context, null);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mHalfWidth = mTotalWidth / 2;
        mRadialGradient = new RadialGradient(mHalfWidth, mTotalHeight * SCREEN_HEIGHT_FRACTION,
                mTotalHeight * SCREEN_HEIGHT_FRACTION,
                COLOR_BLUES, COLOR_LOCATIONS, Shader.TileMode.MIRROR);
        mLightGradientPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mLightGradientPaint.setShader(mRadialGradient);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mTotalWidth = getSize(widthMeasureSpec, getResources().getDimensionPixelSize(R.dimen.default_width));
        mTotalHeight = getSize(heightMeasureSpec, getResources().getDimensionPixelSize(R.dimen.default_height));
        setMeasuredDimension(mTotalWidth, mTotalHeight);
    }

    private int getSize(int widthMeasureSpec, int defaultSize) {
        int size = 0;
        int sizeSpec = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                size = sizeSpec;
                break;
            default:
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                size = defaultSize;
                break;
        }
        return size;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        canvas.drawRect(new Rect(0, 0, mTotalWidth, mTotalHeight), mLightGradientPaint);
    }

}

