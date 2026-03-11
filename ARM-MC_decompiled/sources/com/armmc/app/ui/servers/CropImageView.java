package com.armmc.app.ui.servers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\"\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J(\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0018\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H\u0002J(\u00105\u001a\u00020 2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/armmc/app/ui/servers/CropImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originalBitmap", "Landroid/graphics/Bitmap;", "displayMatrix", "Landroid/graphics/Matrix;", "inverseMatrix", "cropLeft", "", "cropTop", "cropSize", "overlayPaint", "Landroid/graphics/Paint;", "borderPaint", "cornerPaint", "lastTouchX", "lastTouchY", "isDragging", "", "isResizing", "resizeCorner", "cornerHitRadius", "minCropSize", "setImageBitmap", "", "bm", "initCropBox", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getCornerAt", "x", "y", "distance", "x1", "y1", "x2", "y2", "isInsideCropBox", "moveCropBox", "dx", "dy", "resizeCropBox", "touchX", "touchY", "getCroppedBitmap", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageCropDialog.kt */
public final class CropImageView extends AppCompatImageView {
    private final Paint borderPaint;
    private final float cornerHitRadius;
    private final Paint cornerPaint;
    private float cropLeft;
    private float cropSize;
    private float cropTop;
    private Matrix displayMatrix;
    private Matrix inverseMatrix;
    private boolean isDragging;
    private boolean isResizing;
    private float lastTouchX;
    private float lastTouchY;
    private final float minCropSize;
    private Bitmap originalBitmap;
    private final Paint overlayPaint;
    private int resizeCorner;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CropImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.displayMatrix = new Matrix();
        this.inverseMatrix = new Matrix();
        Paint paint = new Paint();
        paint.setColor(-1728053248);
        paint.setStyle(Paint.Style.FILL);
        this.overlayPaint = paint;
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(4.0f);
        this.borderPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(6.0f);
        this.cornerPaint = paint3;
        this.resizeCorner = -1;
        this.cornerHitRadius = 60.0f;
        this.minCropSize = 100.0f;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.originalBitmap = bitmap;
        super.setImageBitmap(bitmap);
        setScaleType(ImageView.ScaleType.MATRIX);
        post(new CropImageView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void setImageBitmap$lambda$3(CropImageView cropImageView) {
        cropImageView.initCropBox();
    }

    private final void initCropBox() {
        Bitmap bitmap;
        float f;
        float f2;
        if (getWidth() != 0 && getHeight() != 0 && (bitmap = this.originalBitmap) != null) {
            Intrinsics.checkNotNull(bitmap);
            float f3 = 0.0f;
            if (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) > ((float) getWidth()) / ((float) getHeight())) {
                f2 = ((float) getWidth()) / ((float) bitmap.getWidth());
                f = (((float) getHeight()) - (((float) bitmap.getHeight()) * f2)) / ((float) 2);
            } else {
                f2 = ((float) getHeight()) / ((float) bitmap.getHeight());
                f = 0.0f;
                f3 = (((float) getWidth()) - (((float) bitmap.getWidth()) * f2)) / ((float) 2);
            }
            this.displayMatrix.reset();
            this.displayMatrix.postScale(f2, f2);
            this.displayMatrix.postTranslate(f3, f);
            setImageMatrix(this.displayMatrix);
            this.displayMatrix.invert(this.inverseMatrix);
            float width = ((float) bitmap.getWidth()) * f2;
            float height = ((float) bitmap.getHeight()) * f2;
            float min = Math.min(width, height) * 0.8f;
            this.cropSize = min;
            float f4 = (float) 2;
            this.cropLeft = f3 + ((width - min) / f4);
            this.cropTop = f + ((height - min) / f4);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.originalBitmap != null) {
            float f = this.cropLeft;
            float f2 = this.cropSize;
            float f3 = this.cropTop + f2;
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), this.cropTop, this.overlayPaint);
            Canvas canvas2 = canvas;
            float f4 = f3;
            canvas2.drawRect(0.0f, f4, (float) getWidth(), (float) getHeight(), this.overlayPaint);
            float f5 = f4;
            canvas2.drawRect(0.0f, this.cropTop, this.cropLeft, f5, this.overlayPaint);
            Canvas canvas3 = canvas;
            float f6 = f + f2;
            canvas3.drawRect(f6, this.cropTop, (float) getWidth(), f5, this.overlayPaint);
            float f7 = f6;
            canvas3.drawRect(this.cropLeft, this.cropTop, f7, f5, this.borderPaint);
            float f8 = f7;
            float f9 = f5;
            float f10 = this.cropLeft;
            float f11 = this.cropTop;
            canvas3.drawLine(f10, f11, f10 + 30.0f, f11, this.cornerPaint);
            float f12 = this.cropLeft;
            float f13 = this.cropTop;
            canvas3.drawLine(f12, f13, f12, f13 + 30.0f, this.cornerPaint);
            float f14 = f8 - 30.0f;
            float f15 = this.cropTop;
            float f16 = f8;
            canvas3.drawLine(f14, f15, f16, f15, this.cornerPaint);
            float f17 = f14;
            float f18 = f16;
            float f19 = this.cropTop;
            canvas3.drawLine(f18, f19, f16, f19 + 30.0f, this.cornerPaint);
            float f20 = f18;
            float f21 = this.cropLeft;
            float f22 = f9;
            canvas3.drawLine(f21, f22, f21 + 30.0f, f9, this.cornerPaint);
            float f23 = f22;
            float f24 = this.cropLeft;
            float f25 = f23 - 30.0f;
            canvas3.drawLine(f24, f25, f24, f23, this.cornerPaint);
            float f26 = f25;
            float f27 = f17;
            float f28 = f20;
            canvas3.drawLine(f27, f23, f28, f23, this.cornerPaint);
            canvas3.drawLine(f28, f26, f28, f23, this.cornerPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.lastTouchX;
                    float y = motionEvent.getY() - this.lastTouchY;
                    if (this.isResizing) {
                        resizeCropBox(x, y, motionEvent.getX(), motionEvent.getY());
                    } else if (this.isDragging) {
                        moveCropBox(x, y);
                    }
                    this.lastTouchX = motionEvent.getX();
                    this.lastTouchY = motionEvent.getY();
                    invalidate();
                    return true;
                } else if (action != 3) {
                    return super.onTouchEvent(motionEvent);
                }
            }
            this.isDragging = false;
            this.isResizing = false;
            this.resizeCorner = -1;
            return true;
        }
        this.lastTouchX = motionEvent.getX();
        this.lastTouchY = motionEvent.getY();
        int cornerAt = getCornerAt(motionEvent.getX(), motionEvent.getY());
        this.resizeCorner = cornerAt;
        if (cornerAt >= 0) {
            this.isResizing = true;
            this.isDragging = false;
        } else if (isInsideCropBox(motionEvent.getX(), motionEvent.getY())) {
            this.isDragging = true;
            this.isResizing = false;
        }
        return true;
    }

    private final int getCornerAt(float f, float f2) {
        float f3 = this.cropLeft;
        float f4 = this.cropSize;
        float f5 = f3 + f4;
        float f6 = this.cropTop;
        float f7 = f4 + f6;
        if (distance(f, f2, f3, f6) < this.cornerHitRadius) {
            return 0;
        }
        if (distance(f, f2, f5, this.cropTop) < this.cornerHitRadius) {
            return 1;
        }
        if (distance(f, f2, this.cropLeft, f7) < this.cornerHitRadius) {
            return 2;
        }
        return distance(f, f2, f5, f7) < this.cornerHitRadius ? 3 : -1;
    }

    private final float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    private final boolean isInsideCropBox(float f, float f2) {
        float f3 = this.cropLeft;
        if (f < f3) {
            return false;
        }
        float f4 = this.cropSize;
        if (f > f3 + f4) {
            return false;
        }
        float f5 = this.cropTop;
        return f2 >= f5 && f2 <= f5 + f4;
    }

    private final void moveCropBox(float f, float f2) {
        float f3;
        float f4;
        Bitmap bitmap = this.originalBitmap;
        if (bitmap != null) {
            float f5 = 0.0f;
            if (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) > ((float) getWidth()) / ((float) getHeight())) {
                f4 = ((float) getWidth()) / ((float) bitmap.getWidth());
                f3 = (((float) getHeight()) - (((float) bitmap.getHeight()) * f4)) / ((float) 2);
            } else {
                f4 = ((float) getHeight()) / ((float) bitmap.getHeight());
                f3 = 0.0f;
                f5 = (((float) getWidth()) - (((float) bitmap.getWidth()) * f4)) / ((float) 2);
            }
            float width = ((float) bitmap.getWidth()) * f4;
            float height = ((float) bitmap.getHeight()) * f4;
            float f6 = this.cropLeft + f;
            float f7 = this.cropTop + f2;
            float coerceIn = RangesKt.coerceIn(f6, f5, RangesKt.coerceAtLeast((width + f5) - this.cropSize, f5));
            float coerceIn2 = RangesKt.coerceIn(f7, f3, RangesKt.coerceAtLeast((height + f3) - this.cropSize, f3));
            this.cropLeft = coerceIn;
            this.cropTop = coerceIn2;
        }
    }

    private final void resizeCropBox(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Bitmap bitmap = this.originalBitmap;
        if (bitmap != null) {
            if (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) > ((float) getWidth()) / ((float) getHeight())) {
                f5 = ((float) getWidth()) / ((float) bitmap.getWidth());
                f6 = (((float) getHeight()) - (((float) bitmap.getHeight()) * f5)) / ((float) 2);
                f7 = 0.0f;
            } else {
                f5 = ((float) getHeight()) / ((float) bitmap.getHeight());
                f7 = (((float) getWidth()) - (((float) bitmap.getWidth()) * f5)) / ((float) 2);
                f6 = 0.0f;
            }
            float width = ((float) bitmap.getWidth()) * f5;
            float height = ((float) bitmap.getHeight()) * f5;
            float max = Math.max(Math.abs(f), Math.abs(f2)) * ((float) (f + f2 > 0.0f ? 1 : -1));
            int i = this.resizeCorner;
            if (i == 0) {
                float f8 = this.cropSize;
                float coerceIn = RangesKt.coerceIn(this.cropSize - max, this.minCropSize, RangesKt.coerceAtLeast(Math.min((this.cropLeft - f7) + f8, (this.cropTop - f6) + f8), this.minCropSize));
                float f9 = this.cropSize - coerceIn;
                this.cropLeft += f9;
                this.cropTop += f9;
                this.cropSize = coerceIn;
            } else if (i == 1) {
                float coerceIn2 = RangesKt.coerceIn(this.cropSize + max, this.minCropSize, RangesKt.coerceAtLeast(Math.min((f7 + width) - this.cropLeft, (this.cropTop - f6) + this.cropSize), this.minCropSize));
                this.cropTop -= coerceIn2 - this.cropSize;
                this.cropSize = coerceIn2;
            } else if (i == 2) {
                float coerceIn3 = RangesKt.coerceIn(this.cropSize + max, this.minCropSize, RangesKt.coerceAtLeast(Math.min((this.cropLeft - f7) + this.cropSize, (f6 + height) - this.cropTop), this.minCropSize));
                this.cropLeft -= coerceIn3 - this.cropSize;
                this.cropSize = coerceIn3;
            } else if (i == 3) {
                this.cropSize = RangesKt.coerceIn(this.cropSize + max, this.minCropSize, RangesKt.coerceAtLeast(Math.min((f7 + width) - this.cropLeft, (f6 + height) - this.cropTop), this.minCropSize));
            }
        }
    }

    public final Bitmap getCroppedBitmap() {
        float f;
        float f2;
        Bitmap bitmap = this.originalBitmap;
        if (bitmap == null) {
            return null;
        }
        float f3 = 0.0f;
        if (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) > ((float) getWidth()) / ((float) getHeight())) {
            f2 = ((float) getWidth()) / ((float) bitmap.getWidth());
            f = (((float) getHeight()) - (((float) bitmap.getHeight()) * f2)) / ((float) 2);
        } else {
            f2 = ((float) getHeight()) / ((float) bitmap.getHeight());
            f = 0.0f;
            f3 = (((float) getWidth()) - (((float) bitmap.getWidth()) * f2)) / ((float) 2);
        }
        int coerceAtLeast = RangesKt.coerceAtLeast((int) ((this.cropLeft - f3) / f2), 0);
        int coerceAtLeast2 = RangesKt.coerceAtLeast((int) ((this.cropTop - f) / f2), 0);
        int i = (int) (this.cropSize / f2);
        int coerceAtMost = RangesKt.coerceAtMost(coerceAtLeast, bitmap.getWidth() - 1);
        int coerceAtMost2 = RangesKt.coerceAtMost(coerceAtLeast2, bitmap.getHeight() - 1);
        int coerceAtMost3 = RangesKt.coerceAtMost(i, Math.min(bitmap.getWidth() - coerceAtMost, bitmap.getHeight() - coerceAtMost2));
        try {
            return Bitmap.createBitmap(bitmap, coerceAtMost, coerceAtMost2, coerceAtMost3, coerceAtMost3);
        } catch (Exception unused) {
            return null;
        }
    }
}
