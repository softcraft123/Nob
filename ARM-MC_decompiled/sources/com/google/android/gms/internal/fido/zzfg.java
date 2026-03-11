package com.google.android.gms.internal.fido;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzfg extends AbstractMap {
    /* access modifiers changed from: private */
    public static final Comparator zza = new zzfd();
    /* access modifiers changed from: private */
    public final Object[] zzb;
    /* access modifiers changed from: private */
    public final int[] zzc;
    private final Set zzd = new zzff(this, -1);
    private Integer zze = null;
    private String zzf = null;

    zzfg(List list) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            int size = list.size();
            Object[] objArr = new Object[size];
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                int[] iArr = {0};
                if (size > 16 && size * 9 > 0) {
                    objArr = Arrays.copyOf(objArr, 0);
                }
                this.zzb = objArr;
                this.zzc = iArr;
                return;
            }
            String unused = ((zzfc) it2.next()).zza;
            throw null;
        }
        String unused2 = ((zzfc) it.next()).zza;
        throw null;
    }

    public final Set entrySet() {
        return this.zzd;
    }

    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }
}
