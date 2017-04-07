package com.siriusyang.retrofitdemo.weigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.siriusyang.retrofitdemo.utils.SizeUtils;

/**
 * @author nanck on 2016/8/2.
 */
public class WaveformView extends View {
    private Paint mPaint;
    private TextPaint mTextPaint;
    private int mLineColor;
    private int topX = 0;
    private Context mContext;
    private String mInitialText = "11:08";
    private int lineNumber = 8;

    public WaveformView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public WaveformView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public WaveformView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    private void init() {
        mPaint = new Paint(); // 打开抗锯齿
        mLineColor = Color.parseColor("#FFFFFF");
        mPaint.setColor(mLineColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setFakeBoldText(true);
        mPaint.setTextSize(SizeUtils.dp2px(mContext, 18f));

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mLineColor);
        mTextPaint.setTextSize(SizeUtils.dp2px(mContext, 18f));

    }

    int width = 0;
    int index = 0;
    int index2 = 0;
    int height = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = getSize(widthMeasureSpec, 0);
        height = getSize(heightMeasureSpec, 0);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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

    private float linesPoint1[] = {22f, 22f, 22f, 82f, 14f, 30f, 14f, 74f, 6f, 38f, 6f, 66f};
    private float linesPoint2[] = {40f, 22f, 40f, 82f, 48f, 30f, 48f, 74f, 56f, 38f, 56f, 66f};

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Rect bounds = new Rect();
        mTextPaint.getTextBounds(mInitialText, topX, mInitialText.length(), bounds);
        int xPos = (canvas.getWidth() - bounds.width()) / 2;
        int textAdjust = (int) (mTextPaint.descent() + mTextPaint.ascent()) / 2;
        int yPos = ((canvas.getHeight() / 2) - textAdjust);
        canvas.drawText(mInitialText, xPos, yPos, mTextPaint);
        index = (canvas.getWidth() - bounds.width()) / 2;
        index2 = (canvas.getWidth() + bounds.width()) / 2;
        int minHeight = canvas.getHeight() / (lineNumber * 2);
        int maxHeight = canvas.getHeight() / 2;


        for (int j = 1; j <= lineNumber; j++) {
            float x = index * j / (lineNumber + 1);
            float yLeft = maxHeight - minHeight * (j % 4);
            if (yLeft < minHeight) {
                yLeft = minHeight;
            }
            float bYLeft = canvas.getHeight() - yLeft;
            canvas.drawLine(x, yLeft, x, bYLeft, mPaint);
        }

        for (int j = 1; j <= lineNumber; j++) {
            float x = canvas.getWidth() - index * j / (lineNumber + 1);
            float y = maxHeight - minHeight * (j % 4);
            float bY = canvas.getHeight() - y;
            canvas.drawLine(x, y, x, bY, mPaint);
        }


    }
}
