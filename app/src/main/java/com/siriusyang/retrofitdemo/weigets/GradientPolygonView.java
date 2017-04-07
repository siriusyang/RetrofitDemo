package com.siriusyang.retrofitdemo.weigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siriusyang.retrofitdemo.R;

/**
 * Created by sirius on 2017-3-31.
 */

public class GradientPolygonView extends View {  int backgroundColor =  Color.parseColor("#0E8DD4");
    int progressColor =Color.parseColor("#0399E5");
    int width = 200;
    int height = 80;
    int MAX = 100;
    private Paint paintBg = null;
    private Paint progressPaint = null;
    private Rect backgroundRect = null;
    private Rect progressRect = null;
    private int progress = 0;

    public GradientPolygonView(Context context) {
        this(context, null);
    }

    public GradientPolygonView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientPolygonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paintBg = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBg.setColor(backgroundColor);
        paintBg.setStyle(Paint.Style.FILL_AND_STROKE);
        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setColor(progressColor);
        progressPaint.setStyle(Paint.Style.FILL_AND_STROKE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = getSize(widthMeasureSpec, getResources().getDimensionPixelSize(R.dimen.default_width));
        height = getSize(heightMeasureSpec, getResources().getDimensionPixelSize(R.dimen.default_height));
        setMeasuredDimension(width, height);
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
        if (progress <= 0) {
            drawInit(canvas);
        } else if (progress < MAX) {
            drawProgress(canvas);
        } else {
            drawFinish(canvas);
        }
    }

    private void drawProgress(Canvas canvas) {
        backgroundRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.drawRect(backgroundRect, paintBg);
        int widthProgress = (int) (progress * 1f / MAX * canvas.getWidth());
        widthProgress=widthProgress/2;
        progressRect = new Rect(widthProgress, 0,canvas.getWidth()- widthProgress, canvas.getHeight());
        canvas.drawRect(progressRect, progressPaint);

    }

    private void drawFinish(Canvas canvas) {
        backgroundRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.drawRect(backgroundRect, paintBg);
    }

    private void drawInit(Canvas canvas) {
//        backgroundRect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
//        canvas.drawRect(backgroundRect, paintBg);
        Shader mShader = new LinearGradient(0, 0,  canvas.getWidth()/2, canvas.getHeight(),
                new int[] {Color.parseColor("#F99E08"),Color.parseColor("#FFC91A") }, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。
        paintBg.setShader(mShader);
//        backgroundRect = new Rect(0, 0,  canvas.getWidth(), canvas.getHeight());
//        canvas.drawRect(backgroundRect, paintBg);
        Path path = new Path();
        path.moveTo(0, 0);// 此点为多边形的起点  左上点
        path.lineTo(0,  canvas.getHeight());//左下点
        path.lineTo(canvas.getWidth()/2, canvas.getHeight());//右下点
        path.lineTo(canvas.getWidth()/2*1f/10*9, 0);//右上点
        path.close(); // 使这些点构成封闭的多边形
        Path path2 = new Path();
        path2.moveTo(canvas.getWidth()/2*1f/10*9, 0);// 此点为多边形的起点  左上点
        path2.lineTo(canvas.getWidth()/2,  canvas.getHeight());//左下点
        path2.lineTo(canvas.getWidth(), canvas.getHeight());//右下点
        path2.lineTo(canvas.getWidth(), 0);//右上点
        path2.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, paintBg);
        Paint paint2=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setColor(Color.parseColor("#000000"));
        paint2.setAlpha(30);
        canvas.drawPath(path2, paint2);

    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}

