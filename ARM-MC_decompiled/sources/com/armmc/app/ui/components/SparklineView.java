package com.armmc.app.ui.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.armmc.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/armmc/app/ui/components/SparklineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linePaint", "Landroid/graphics/Paint;", "fillPaint", "linePath", "Landroid/graphics/Path;", "fillPath", "dataPoints", "", "", "maxValue", "minValue", "horizontalPadding", "verticalPadding", "setData", "", "points", "setValueRange", "min", "max", "setLineColor", "color", "clearData", "onDraw", "canvas", "Landroid/graphics/Canvas;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: SparklineView.kt */
public final class SparklineView extends View {
    private List<Float> dataPoints;
    private final Paint fillPaint;
    private final Path fillPath;
    private final float horizontalPadding;
    private final Paint linePaint;
    private final Path linePath;
    private float maxValue;
    private float minValue;
    private final float verticalPadding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SparklineView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SparklineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SparklineView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SparklineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(ContextCompat.getColor(context, R.color.primary_accent));
        this.linePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.fillPaint = paint2;
        this.linePath = new Path();
        this.fillPath = new Path();
        this.dataPoints = CollectionsKt.emptyList();
        this.maxValue = 100.0f;
        this.horizontalPadding = 2.0f;
        this.verticalPadding = 4.0f;
    }

    public final void setData(List<Float> list) {
        Intrinsics.checkNotNullParameter(list, "points");
        this.dataPoints = list;
        invalidate();
    }

    public final void setValueRange(float f, float f2) {
        this.minValue = f;
        this.maxValue = f2;
        invalidate();
    }

    public final void setLineColor(int i) {
        this.linePaint.setColor(i);
        invalidate();
    }

    public final void clearData() {
        this.dataPoints = CollectionsKt.emptyList();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        if (!this.dataPoints.isEmpty() && getWidth() != 0 && getHeight() != 0) {
            float f = (float) 2;
            float width = ((float) getWidth()) - (this.horizontalPadding * f);
            float height = ((float) getHeight()) - (this.verticalPadding * f);
            float f2 = this.maxValue - this.minValue;
            float f3 = 0.0f;
            if (f2 > 0.0f && this.dataPoints.size() >= 2) {
                boolean z2 = true;
                float coerceAtLeast = width / ((float) RangesKt.coerceAtLeast(this.dataPoints.size() - 1, 1));
                this.linePath.reset();
                this.fillPath.reset();
                int i = 0;
                for (Object next : this.dataPoints) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    float floatValue = ((Number) next).floatValue();
                    float f4 = this.horizontalPadding + (((float) i) * coerceAtLeast);
                    float coerceIn = (this.verticalPadding + height) - (RangesKt.coerceIn((floatValue - this.minValue) / f2, f3, 1.0f) * height);
                    if (i == 0) {
                        this.linePath.moveTo(f4, coerceIn);
                        this.fillPath.moveTo(f4, (float) getHeight());
                        this.fillPath.lineTo(f4, coerceIn);
                        z = z2;
                    } else {
                        int i3 = i - 1;
                        float f5 = this.horizontalPadding + (((float) i3) * coerceAtLeast);
                        float coerceIn2 = (this.verticalPadding + height) - (RangesKt.coerceIn((this.dataPoints.get(i3).floatValue() - this.minValue) / f2, f3, 1.0f) * height);
                        float f6 = (f5 + f4) / f;
                        float f7 = (f4 - f5) / ((float) 4);
                        float f8 = f5 + f7;
                        float f9 = (coerceIn2 + coerceIn) / f;
                        this.linePath.quadTo(f8, coerceIn2, f6, f9);
                        z = z2;
                        float f10 = f4 - f7;
                        this.linePath.quadTo(f10, coerceIn, f4, coerceIn);
                        this.fillPath.quadTo(f8, coerceIn2, f6, f9);
                        this.fillPath.quadTo(f10, coerceIn, f4, coerceIn);
                    }
                    i = i2;
                    z2 = z;
                    f3 = 0.0f;
                }
                boolean z3 = z2;
                this.fillPath.lineTo(this.horizontalPadding + (((float) (this.dataPoints.size() - 1)) * coerceAtLeast), (float) getHeight());
                this.fillPath.close();
                this.fillPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) getHeight(), this.linePaint.getColor() & 1090519039, this.linePaint.getColor() & ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
                canvas2.drawPath(this.fillPath, this.fillPaint);
                canvas2.drawPath(this.linePath, this.linePaint);
            }
        }
    }
}
