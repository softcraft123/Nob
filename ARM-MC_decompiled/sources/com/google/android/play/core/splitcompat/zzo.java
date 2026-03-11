package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.util.Log;
import com.google.android.play.core.splitinstall.zzx;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzo implements Runnable {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzo(Context context) {
        this.zza = context;
    }

    public final void run() {
        Context context = this.zza;
        int i = SplitCompat.zza;
        try {
            zzx.zzg(context).zzc(true);
        } catch (SecurityException unused) {
            Log.e("SplitCompat", "Failed to set broadcast receiver to always on.");
        }
    }
}
