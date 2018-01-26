package com.example.contentprovoderdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class CanvasView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Rect mRect;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

//        canvas.drawCircle(200, 400, 200, mPaint);
//        mPaint.setStyle(Paint.Style.FILL);
//        RectF rectF = new RectF(0, 200, 400, 598);
//        canvas.drawArc(rectF, 0, 210, true, mPaint);
//        mPaint.setColor(Color.RED);
//        canvas.drawArc(rectF, 300, 345, true, mPaint);


        //缩放
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);
//        canvas.translate(mWidth/2,mHeight/2);
        mRect = new Rect(0, 0, 400, 400);
        canvas.drawRect(mRect,paint);

        canvas.scale(0.5f,0.5f);
        paint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(mRect,paint);
    }
}
