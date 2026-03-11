package com.google.android.material.carousel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] MEDIUM_COUNTS_COMPACT = {0};
    private static final int[] SMALL_COUNTS = {1};
    private final boolean forceCompactArrangement;

    public MultiBrowseCarouselStrategy() {
        this(false);
    }

    public MultiBrowseCarouselStrategy(boolean z) {
        this.forceCompactArrangement = z;
    }

    /* access modifiers changed from: package-private */
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        float containerHeight = (float) carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = (float) carousel.getContainerWidth();
        }
        float f = containerHeight;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f2 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f3 = f2;
        float smallSizeMin = CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f3;
        float smallSizeMax = CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f3;
        float min = Math.min(measuredHeight + f3, f);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f3, CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f3, CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f3);
        float f4 = (min + clamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        int[] iArr2 = this.forceCompactArrangement ? MEDIUM_COUNTS_COMPACT : MEDIUM_COUNTS;
        int max = (int) Math.max(1.0d, Math.floor((double) (((f - (((float) CarouselStrategyHelper.maxValue(iArr2)) * f4)) - (((float) CarouselStrategyHelper.maxValue(iArr)) * smallSizeMax)) / min)));
        int ceil = (int) Math.ceil((double) (f / min));
        int i = (ceil - max) + 1;
        int[] iArr3 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = ceil - i2;
        }
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f3, f, Arrangement.findLowestCostArrangement(f, clamp, smallSizeMin, smallSizeMax, iArr, f4, iArr2, min, iArr3));
    }
}
