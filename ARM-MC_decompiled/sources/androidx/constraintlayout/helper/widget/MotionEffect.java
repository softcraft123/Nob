package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int fadeMove = -1;
    private float motionEffectAlpha = 0.1f;
    private int motionEffectEnd = 50;
    private int motionEffectStart = 49;
    private boolean motionEffectStrictMove = true;
    private int motionEffectTranslationX = 0;
    private int motionEffectTranslationY = 0;
    private int viewTransitionId = -1;

    public boolean isDecorator() {
        return true;
    }

    public MotionEffect(Context context) {
        super(context);
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.motionEffectStart);
                    this.motionEffectStart = i2;
                    this.motionEffectStart = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.motionEffectEnd);
                    this.motionEffectEnd = i3;
                    this.motionEffectEnd = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.motionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.motionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.motionEffectAlpha = obtainStyledAttributes.getFloat(index, this.motionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.fadeMove = obtainStyledAttributes.getInt(index, this.fadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.motionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.motionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.viewTransitionId = obtainStyledAttributes.getResourceId(index, this.viewTransitionId);
                }
            }
            int i4 = this.motionEffectStart;
            int i5 = this.motionEffectEnd;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.motionEffectStart = i4 - 1;
                } else {
                    this.motionEffectEnd = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0192, code lost:
        if (r14 == 0.0f) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a7, code lost:
        if (r14 == 0.0f) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b8, code lost:
        if (r15 == 0.0f) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c9, code lost:
        if (r15 == 0.0f) goto L_0x016e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            android.view.ViewParent r2 = r0.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.getViews(r2)
            if (r2 != 0) goto L_0x002d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getLoc()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " views = null"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FadeMove"
            android.util.Log.v(r2, r1)
            return
        L_0x002d:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.setValue(r6, r5)
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.setValue(r6, r5)
            int r5 = r0.motionEffectStart
            r3.setFramePosition(r5)
            int r5 = r0.motionEffectEnd
            r4.setFramePosition(r5)
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.motionEffectStart
            r5.setFramePosition(r6)
            r6 = 0
            r5.setType(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.setValue(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.setValue(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.motionEffectEnd
            r7.setFramePosition(r10)
            r7.setType(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.setValue(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.setValue(r9, r8)
            int r8 = r0.motionEffectTranslationX
            r9 = 0
            if (r8 <= 0) goto L_0x00be
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.motionEffectTranslationX
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            r8.setFramePosition(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            int r12 = r12 - r10
            r11.setFramePosition(r12)
            goto L_0x00c0
        L_0x00be:
            r8 = r9
            r11 = r8
        L_0x00c0:
            int r12 = r0.motionEffectTranslationY
            if (r12 <= 0) goto L_0x00ec
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.motionEffectTranslationY
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            r9.setFramePosition(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            int r13 = r13 - r10
            r12.setFramePosition(r13)
            goto L_0x00ed
        L_0x00ec:
            r12 = r9
        L_0x00ed:
            int r13 = r0.fadeMove
            r16 = r6
            r6 = -1
            r17 = 0
            if (r13 != r6) goto L_0x015b
            r13 = 4
            int[] r6 = new int[r13]
            r14 = r16
            r18 = 3
            r19 = 2
        L_0x00ff:
            int r15 = r2.length
            if (r14 >= r15) goto L_0x0148
            r15 = r2[r14]
            java.lang.Object r15 = r1.get(r15)
            androidx.constraintlayout.motion.widget.MotionController r15 = (androidx.constraintlayout.motion.widget.MotionController) r15
            if (r15 != 0) goto L_0x010d
            goto L_0x0145
        L_0x010d:
            float r20 = r15.getFinalX()
            float r21 = r15.getStartX()
            float r20 = r20 - r21
            float r21 = r15.getFinalY()
            float r15 = r15.getStartY()
            float r21 = r21 - r15
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x012a
            r15 = r6[r10]
            int r15 = r15 + r10
            r6[r10] = r15
        L_0x012a:
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0133
            r15 = r6[r16]
            int r15 = r15 + r10
            r6[r16] = r15
        L_0x0133:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x013c
            r15 = r6[r18]
            int r15 = r15 + r10
            r6[r18] = r15
        L_0x013c:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0145
            r15 = r6[r19]
            int r15 = r15 + r10
            r6[r19] = r15
        L_0x0145:
            int r14 = r14 + 1
            goto L_0x00ff
        L_0x0148:
            r14 = r6[r16]
            r15 = r14
            r14 = r16
        L_0x014d:
            if (r10 >= r13) goto L_0x0159
            r13 = r6[r10]
            if (r15 >= r13) goto L_0x0155
            r14 = r10
            r15 = r13
        L_0x0155:
            int r10 = r10 + 1
            r13 = 4
            goto L_0x014d
        L_0x0159:
            r13 = r14
            goto L_0x015f
        L_0x015b:
            r18 = 3
            r19 = 2
        L_0x015f:
            r6 = r16
        L_0x0161:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x0203
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.MotionController r10 = (androidx.constraintlayout.motion.widget.MotionController) r10
            if (r10 != 0) goto L_0x0173
        L_0x016e:
            r1 = r23
            r15 = -1
            goto L_0x01f9
        L_0x0173:
            float r14 = r10.getFinalX()
            float r15 = r10.getStartX()
            float r14 = r14 - r15
            float r15 = r10.getFinalY()
            float r16 = r10.getStartY()
            float r15 = r15 - r16
            if (r13 != 0) goto L_0x019a
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0197
            boolean r15 = r0.motionEffectStrictMove
            if (r15 == 0) goto L_0x0194
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0197
        L_0x0194:
            r1 = r18
            goto L_0x01cb
        L_0x0197:
            r1 = r18
            goto L_0x01cc
        L_0x019a:
            r1 = 1
            if (r13 != r1) goto L_0x01aa
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0197
            boolean r15 = r0.motionEffectStrictMove
            if (r15 == 0) goto L_0x0194
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0197
            goto L_0x0194
        L_0x01aa:
            r1 = r19
            if (r13 != r1) goto L_0x01bb
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0197
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x0194
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0197
            goto L_0x0194
        L_0x01bb:
            r1 = r18
            if (r13 != r1) goto L_0x01cc
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01cc
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x016e
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01cc
        L_0x01cb:
            goto L_0x016e
        L_0x01cc:
            int r14 = r0.viewTransitionId
            r15 = -1
            if (r14 != r15) goto L_0x01f4
            r10.addKey(r3)
            r10.addKey(r4)
            r10.addKey(r5)
            r10.addKey(r7)
            int r14 = r0.motionEffectTranslationX
            if (r14 <= 0) goto L_0x01e7
            r10.addKey(r8)
            r10.addKey(r11)
        L_0x01e7:
            int r14 = r0.motionEffectTranslationY
            if (r14 <= 0) goto L_0x01f1
            r10.addKey(r9)
            r10.addKey(r12)
        L_0x01f1:
            r1 = r23
            goto L_0x01f9
        L_0x01f4:
            r1 = r23
            r1.applyViewTransition(r14, r10)
        L_0x01f9:
            int r6 = r6 + 1
            r1 = r24
            r18 = 3
            r19 = 2
            goto L_0x0161
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }
}
