package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
final class zzej {
    private static final zzei zza;
    private static final zzei zzb = new zzei();

    static {
        zzei zzei;
        try {
            zzei = (zzei) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzei = null;
        }
        zza = zzei;
    }

    static zzei zza() {
        return zza;
    }

    static zzei zzb() {
        return zzb;
    }
}
