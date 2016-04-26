package com.dome.androidtools.view.circles;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class CircularProgressDrawable extends Drawable {

    private float mSweepAngle;
    private float mStartAngle;
    private int mSize;
    private int mStrokeWidth;
    private int mStrokeColor;

    final Bitmap loadingImage;


    public CircularProgressDrawable(Resources resources, int size, int strokeWidth, int strokeColor,
                                    int loadResId) {
        mSize = size;
        mStrokeWidth = strokeWidth;
        mStrokeColor = strokeColor;
        mStartAngle = -90;
        mSweepAngle = 0;
        if (loadResId != -1)
            loadingImage = BitmapFactory.decodeResource(resources, loadResId);
        else
            loadingImage = null;
    }

    public void setSweepAngle(float sweepAngle) {
        mSweepAngle = sweepAngle;
    }

    public int getSize() {
        return mSize;
    }

    @Override
    public void draw(Canvas canvas) {
        final Rect bounds = getBounds();

        if (mPath == null) {
            mPath = new Path();
        }
        mPath.reset();
        //向该路径添加椭圆弧度，startAngle为开始的弧度，SweepAngle表示扫描过的弧度
        mPath.addArc(getRect(), mStartAngle, mSweepAngle);
        mPath.offset(bounds.left, bounds.top);
        int destWidth = (int) (getSize() * 0.7);
        int destHeight = destWidth;
        int destLeft = (int) (bounds.left + 0.15 * getSize());
        int destTop = (int) (bounds.top + 0.15 * getSize());

        canvas.drawPath(mPath, createPaint());
        if (loadingImage != null) {
            canvas.drawBitmap(Bitmap.createScaledBitmap(loadingImage, destWidth, destHeight, true),
                    destLeft, destTop, null);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return 1;
    }

    private RectF mRectF;
    private Paint mPaint;
    private Path mPath;

    private RectF getRect() {
        if (mRectF == null) {
            int index = mStrokeWidth / 2;
            mRectF = new RectF(index, index, getSize() - index, getSize() - index);
        }
        return mRectF;
    }

    private Paint createPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(mStrokeWidth);
            mPaint.setColor(mStrokeColor);
        }
        return mPaint;
    }
}
