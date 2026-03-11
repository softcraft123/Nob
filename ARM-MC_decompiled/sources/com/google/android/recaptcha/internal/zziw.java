package com.google.android.recaptcha.internal;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zziw extends Lambda implements Function0 {
    public static final zziw zza = new zziw();

    public zziw() {
        super(0);
    }

    public final Object invoke() {
        int i = zzav.zza;
        Object zzb = zzau.zza().zzb(Application.class.getName().hashCode());
        if (zzb != null) {
            return (Application) zzb;
        }
        throw new zzbd(zzbb.zzb, zzba.zzax, (String) null);
    }
}
