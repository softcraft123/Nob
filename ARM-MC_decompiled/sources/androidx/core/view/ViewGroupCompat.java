package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;
import androidx.core.R;

public final class ViewGroupCompat {
    private static final WindowInsets CONSUMED = WindowInsetsCompat.CONSUMED.toWindowInsets();
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    static boolean sCompatInsetsDispatchInstalled = false;

    private ViewGroupCompat() {
    }

    @ReplaceWith(expression = "group.onRequestSendAccessibilityEvent(child, event)")
    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    @ReplaceWith(expression = "group.setMotionEventSplittingEnabled(split)")
    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    @ReplaceWith(expression = "group.getLayoutMode()")
    @Deprecated
    public static int getLayoutMode(ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    @ReplaceWith(expression = "group.setLayoutMode(mode)")
    @Deprecated
    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        viewGroup.setLayoutMode(i);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        Api21Impl.setTransitionGroup(viewGroup, z);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return Api21Impl.isTransitionGroup(viewGroup);
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return Api21Impl.getNestedScrollAxes(viewGroup);
    }

    public static void installCompatInsetsDispatch(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            ViewGroupCompat$$ExternalSyntheticLambda1 viewGroupCompat$$ExternalSyntheticLambda1 = new ViewGroupCompat$$ExternalSyntheticLambda1();
            view.setTag(R.id.tag_compat_insets_dispatch, viewGroupCompat$$ExternalSyntheticLambda1);
            view.setOnApplyWindowInsetsListener(viewGroupCompat$$ExternalSyntheticLambda1);
            sCompatInsetsDispatchInstalled = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.view.View$OnApplyWindowInsetsListener} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.WindowInsets dispatchApplyWindowInsets(android.view.View r5, android.view.WindowInsets r6) {
        /*
            int r0 = androidx.core.R.id.tag_on_apply_window_listener
            java.lang.Object r0 = r5.getTag(r0)
            int r1 = androidx.core.R.id.tag_window_insets_animation_callback
            java.lang.Object r1 = r5.getTag(r1)
            boolean r2 = r0 instanceof android.view.View.OnApplyWindowInsetsListener
            if (r2 == 0) goto L_0x0013
            android.view.View$OnApplyWindowInsetsListener r0 = (android.view.View.OnApplyWindowInsetsListener) r0
            goto L_0x001c
        L_0x0013:
            boolean r0 = r1 instanceof android.view.View.OnApplyWindowInsetsListener
            if (r0 == 0) goto L_0x001b
            r0 = r1
            android.view.View$OnApplyWindowInsetsListener r0 = (android.view.View.OnApplyWindowInsetsListener) r0
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r1 = 1
            android.view.WindowInsets[] r1 = new android.view.WindowInsets[r1]
            android.view.WindowInsets r2 = CONSUMED
            r3 = 0
            r1[r3] = r2
            androidx.core.view.ViewGroupCompat$$ExternalSyntheticLambda0 r2 = new androidx.core.view.ViewGroupCompat$$ExternalSyntheticLambda0
            r2.<init>(r1, r0)
            r5.setOnApplyWindowInsetsListener(r2)
            r5.dispatchApplyWindowInsets(r6)
            int r6 = androidx.core.R.id.tag_compat_insets_dispatch
            java.lang.Object r6 = r5.getTag(r6)
            boolean r2 = r6 instanceof android.view.View.OnApplyWindowInsetsListener
            if (r2 == 0) goto L_0x003c
            r0 = r6
            android.view.View$OnApplyWindowInsetsListener r0 = (android.view.View.OnApplyWindowInsetsListener) r0
        L_0x003c:
            r5.setOnApplyWindowInsetsListener(r0)
            r6 = r1[r3]
            if (r6 == 0) goto L_0x0062
            boolean r6 = r6.isConsumed()
            if (r6 != 0) goto L_0x0062
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x0062
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r6 = r5.getChildCount()
            r0 = r3
        L_0x0054:
            if (r0 >= r6) goto L_0x0062
            android.view.View r2 = r5.getChildAt(r0)
            r4 = r1[r3]
            dispatchApplyWindowInsets(r2, r4)
            int r0 = r0 + 1
            goto L_0x0054
        L_0x0062:
            r5 = r1[r3]
            if (r5 == 0) goto L_0x0067
            return r5
        L_0x0067:
            android.view.WindowInsets r5 = CONSUMED
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupCompat.dispatchApplyWindowInsets(android.view.View, android.view.WindowInsets):android.view.WindowInsets");
    }

    static /* synthetic */ WindowInsets lambda$dispatchApplyWindowInsets$1(WindowInsets[] windowInsetsArr, View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
        WindowInsets windowInsets2;
        if (onApplyWindowInsetsListener != null) {
            windowInsets2 = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        } else {
            windowInsets2 = view.onApplyWindowInsets(windowInsets);
        }
        windowInsetsArr[0] = windowInsets2;
        return CONSUMED;
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }

        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }
    }
}
