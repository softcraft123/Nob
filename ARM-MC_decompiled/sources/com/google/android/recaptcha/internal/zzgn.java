package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzgn implements zzgx {
    public static final zzgn zza = new zzgn();

    private zzgn() {
    }

    private static final boolean zzb(List list) {
        Iterable<zzue> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (zzue zzR : iterable) {
            arrayList.add(Boolean.valueOf(zzR.zzR()));
        }
        if (!((List) arrayList).contains(false)) {
            return true;
        }
        return false;
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        if (zzb(ArraysKt.toList((T[]) zzueArr))) {
            for (zzue zzi : zzueArr) {
                zzgd.zzc().zzb(zzi.zzi());
            }
            return;
        }
        throw new zzce(4, 5, (Throwable) null);
    }
}
