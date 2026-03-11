package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
final class zzcg {
    private static final zzce zza = new zzcf();
    private static final zzce zzb;

    static {
        zzce zzce;
        try {
            zzce = (zzce) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzce = null;
        }
        zzb = zzce;
    }

    static zzce zza() {
        zzce zzce = zzb;
        if (zzce != null) {
            return zzce;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzce zzb() {
        return zza;
    }
}
