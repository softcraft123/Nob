package com.google.android.recaptcha.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzav {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static zzav zzb;
    /* access modifiers changed from: private */
    public static final Map zzc = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final Function0 zzd = zzat.zza;
    private final Map zze;

    public /* synthetic */ zzav(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this.zze = map;
    }

    public final Object zzb(int i) {
        return this.zze.get(Integer.valueOf(i));
    }
}
