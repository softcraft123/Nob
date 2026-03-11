package androidx.core.view.insets;

import android.graphics.RectF;
import androidx.core.graphics.Insets;
import androidx.core.view.insets.SystemBarStateMonitor;
import java.util.ArrayList;
import java.util.List;

class ProtectionGroup implements SystemBarStateMonitor.Callback {
    private int mAnimationCount;
    private boolean mDisposed;
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;
    private final SystemBarStateMonitor mMonitor;
    private final ArrayList<Protection> mProtections = new ArrayList<>();

    ProtectionGroup(SystemBarStateMonitor systemBarStateMonitor, List<Protection> list) {
        addProtections(list, false);
        addProtections(list, true);
        systemBarStateMonitor.addCallback(this);
        this.mMonitor = systemBarStateMonitor;
    }

    private void addProtections(List<Protection> list, boolean z) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protection protection = list.get(i);
            if (protection.occupiesCorners() == z) {
                Object controller = protection.getController();
                if (controller == null) {
                    protection.setController(this);
                    this.mProtections.add(protection);
                } else {
                    throw new IllegalStateException(protection + " is already controlled by " + controller);
                }
            }
        }
    }

    private void updateInsets() {
        Insets insets = Insets.NONE;
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            insets = Insets.max(insets, this.mProtections.get(size).dispatchInsets(this.mInsets, this.mInsetsIgnoringVisibility, insets));
        }
    }

    public void onInsetsChanged(Insets insets, Insets insets2) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets2;
        updateInsets();
    }

    public void onColorHintChanged(int i) {
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            this.mProtections.get(size).dispatchColorHint(i);
        }
    }

    public void onAnimationStart() {
        this.mAnimationCount++;
    }

    public void onAnimationProgress(int i, Insets insets, RectF rectF) {
        Insets insets2 = this.mInsetsIgnoringVisibility;
        for (int size = this.mProtections.size() - 1; size >= 0; size--) {
            Protection protection = this.mProtections.get(size);
            int side = protection.getSide();
            if ((side & i) != 0) {
                protection.setSystemVisible(true);
                if (side == 1) {
                    if (insets2.left > 0) {
                        protection.setSystemInsetAmount(((float) insets.left) / ((float) insets2.left));
                    }
                    protection.setSystemAlpha(rectF.left);
                } else if (side == 2) {
                    if (insets2.top > 0) {
                        protection.setSystemInsetAmount(((float) insets.top) / ((float) insets2.top));
                    }
                    protection.setSystemAlpha(rectF.top);
                } else if (side == 4) {
                    if (insets2.right > 0) {
                        protection.setSystemInsetAmount(((float) insets.right) / ((float) insets2.right));
                    }
                    protection.setSystemAlpha(rectF.right);
                } else if (side == 8) {
                    if (insets2.bottom > 0) {
                        protection.setSystemInsetAmount(((float) insets.bottom) / ((float) insets2.bottom));
                    }
                    protection.setSystemAlpha(rectF.bottom);
                }
            }
        }
    }

    public void onAnimationEnd() {
        int i = this.mAnimationCount;
        boolean z = i > 0;
        int i2 = i - 1;
        this.mAnimationCount = i2;
        if (z && i2 == 0) {
            updateInsets();
        }
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.mProtections.size();
    }

    /* access modifiers changed from: package-private */
    public Protection getProtection(int i) {
        return this.mProtections.get(i);
    }

    /* access modifiers changed from: package-private */
    public void dispose() {
        if (!this.mDisposed) {
            this.mDisposed = true;
            this.mMonitor.removeCallback(this);
            for (int size = this.mProtections.size() - 1; size >= 0; size--) {
                this.mProtections.get(size).setController((Object) null);
            }
            this.mProtections.clear();
        }
    }
}
