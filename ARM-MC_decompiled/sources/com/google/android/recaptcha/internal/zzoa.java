package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzoa implements zzox {
    private static final zzog zza = new zzny();
    private final zzog zzb;

    public zzoa() {
        zzog zzog = zza;
        int i = zzos.zza;
        zznz zznz = new zznz(zzmw.zza(), zzog);
        byte[] bArr = zznl.zzb;
        this.zzb = zznz;
    }

    public final zzow zza(Class cls) {
        int i = zzoy.zza;
        if (!zznd.class.isAssignableFrom(cls)) {
            int i2 = zzos.zza;
        }
        zzof zzb2 = this.zzb.zzb(cls);
        if (!zzb2.zzb()) {
            int i3 = zzos.zza;
            return zzol.zzm(cls, zzb2, zzop.zza(), zznw.zza(), zzoy.zzm(), zzb2.zzc() + -1 != 1 ? zzmr.zza() : null, zzoe.zza());
        }
        int i4 = zzos.zza;
        return zzom.zzc(zzoy.zzm(), zzmr.zza(), zzb2.zza());
    }
}
