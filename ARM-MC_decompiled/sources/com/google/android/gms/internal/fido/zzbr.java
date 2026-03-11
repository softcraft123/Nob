package com.google.android.gms.internal.fido;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzbr implements zzbp {
    private static final zzbp zza = zzbq.zza;
    private volatile zzbp zzb;

    zzbr(zzbp zzbp) {
        this.zzb = zzbp;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned null>";
        }
        String valueOf = String.valueOf(obj);
        return "Suppliers.memoize(" + valueOf + ")";
    }

    public final Object zza() {
        throw null;
    }
}
