package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzdb {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Object obj;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            obj = ((SortedSet) iterable).comparator();
            if (obj == null) {
                obj = zzcq.zza;
            }
        } else if (!(iterable instanceof zzda)) {
            return false;
        } else {
            obj = ((zzda) iterable).comparator();
        }
        return comparator.equals(obj);
    }
}
