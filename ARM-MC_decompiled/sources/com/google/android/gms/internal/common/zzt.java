package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzt implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzw zzb;

    zzt(zzw zzw, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzw);
        this.zzb = zzw;
    }

    public final Iterator iterator() {
        return this.zzb.zze(this.zza);
    }

    public final String toString() {
        String str = ", ";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(zzq.zza(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append(", ");
                    sb.append(zzq.zza(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
