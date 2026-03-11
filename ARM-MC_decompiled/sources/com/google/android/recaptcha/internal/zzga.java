package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzga extends zzfx {
    private final zzfz zza;
    private final String zzb;

    public zzga(zzfz zzfz, String str, Object obj) {
        super(obj);
        this.zza = zzfz;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!Intrinsics.areEqual((Object) method.getName(), (Object) this.zzb)) {
            return false;
        }
        zzfz zzfz = this.zza;
        if (objArr == null || (list = ArraysKt.asList((T[]) objArr)) == null) {
            list = CollectionsKt.emptyList();
        }
        zzfz.zzb(list);
        return true;
    }
}
