package com.google.android.gms.common.util;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public interface Clock {
    long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
