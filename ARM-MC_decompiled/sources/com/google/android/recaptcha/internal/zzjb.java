package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzjb {
    public static final Map zza() {
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(-4, zzba.zzo), TuplesKt.to(-12, zzba.zzp), TuplesKt.to(-6, zzba.zzk), TuplesKt.to(-11, zzba.zzm), TuplesKt.to(-13, zzba.zzq), TuplesKt.to(-14, zzba.zzr), TuplesKt.to(-2, zzba.zzl), TuplesKt.to(-7, zzba.zzs), TuplesKt.to(-5, zzba.zzt), TuplesKt.to(-9, zzba.zzu), TuplesKt.to(-8, zzba.zzE), TuplesKt.to(-15, zzba.zzn), TuplesKt.to(-1, zzba.zzv), TuplesKt.to(-3, zzba.zzx), TuplesKt.to(-10, zzba.zzy));
        mutableMapOf.put(-16, zzba.zzw);
        if (Build.VERSION.SDK_INT >= 27) {
            mutableMapOf.put(1, zzba.zzA);
            mutableMapOf.put(2, zzba.zzB);
            mutableMapOf.put(0, zzba.zzC);
            mutableMapOf.put(3, zzba.zzD);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            mutableMapOf.put(4, zzba.zzz);
        }
        return mutableMapOf;
    }
}
