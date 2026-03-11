package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import java.io.File;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzbc implements zzar {
    zzbc() {
    }

    public final boolean zza(Object obj, File file, File file2) {
        try {
            if (!((Boolean) zzbk.zzf(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue()) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
