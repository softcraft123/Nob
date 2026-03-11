package com.google.android.play.core.splitcompat;

import android.app.Application;
import android.content.Context;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public class SplitCompatApplication extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitCompat.install(this);
    }
}
