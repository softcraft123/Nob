package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
class zzaf<E> extends zzai<E> {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    public zzaf<E> zza(E e) {
        zzu.zza(e);
        Object[] objArr = this.zza;
        int zza2 = zza(objArr.length, this.zzb + 1);
        if (zza2 > objArr.length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, zza2);
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr2[i] = e;
        return this;
    }

    zzaf(int i) {
        zzae.zza(4, "initialCapacity");
    }
}
