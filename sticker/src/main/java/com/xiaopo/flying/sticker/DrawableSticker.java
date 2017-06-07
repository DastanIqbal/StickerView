package com.xiaopo.flying.sticker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * @author wupanjie
 */
public class DrawableSticker extends Sticker {

    private Drawable drawable;
    private Rect realBounds;
    private PointF centerPointXY = new PointF();
    private String stickerPath;
    private PointF size;

    public DrawableSticker(Context context, Drawable drawable) {
        super(context);
        this.drawable = drawable;
        realBounds = new Rect(0, 0, getWidth(), getHeight());
    }

    @NonNull
    @Override
    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public DrawableSticker setDrawable(@NonNull Drawable drawable) {
        this.drawable = drawable;
        return this;
    }

    @Override
    public void setCenterPointXY(PointF currentCenterPoint) {
        PointF pointF = new PointF();
        pointF.x = currentCenterPoint.x;
        pointF.y = currentCenterPoint.y;
        this.centerPointXY = pointF;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(getMatrix());
        drawable.setBounds(realBounds);
        drawable.draw(canvas);
        canvas.restore();
    }

    @NonNull
    @Override
    public DrawableSticker setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        drawable.setAlpha(alpha);
        return this;
    }

    @Override
    public int getWidth() {
        return drawable.getIntrinsicWidth();
    }

    @Override
    public int getHeight() {
        return drawable.getIntrinsicHeight();
    }

    @Override
    public void release() {
        super.release();
        if (drawable != null) {
            drawable = null;
        }
    }

    public PointF getCenterPointXY() {
        return new PointF(centerPointXY.x, centerPointXY.y /*- point.y*/);
    }

    public void setStickerPath(String stickerPath) {
        this.stickerPath = stickerPath;
    }

    public String getStickerPath() {
        return stickerPath;
    }

    public PointF getSize() {
        size = new PointF(getCurrentWidth(), getCurrentHeight());
        return size;
    }
}
