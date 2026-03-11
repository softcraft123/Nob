package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
final class zzdy {
    private static final zzdx zza;
    private static final zzdx zzb = new zzdx();

    static {
        zzdx zzdx;
        try {
            zzdx = (zzdx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdx = null;
        }
        zza = zzdx;
    }

    static zzdx zza() {
        return zza;
    }

    static zzdx zzb() {
        return zzb;
    }
}
