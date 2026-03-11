package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzmq extends zzmp {
    zzmq() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj) {
        ((zzna) obj).zzb.zzg();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzpy zzpy, Map.Entry entry) throws IOException {
        zznb zznb = (zznb) entry.getKey();
        zzpw zzpw = zzpw.DOUBLE;
        switch (zznb.zzb.ordinal()) {
            case 0:
                zzpy.zzf(zznb.zza, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                zzpy.zzo(zznb.zza, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                zzpy.zzt(zznb.zza, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                zzpy.zzK(zznb.zza, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zzpy.zzr(zznb.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                zzpy.zzm(zznb.zza, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                zzpy.zzk(zznb.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                zzpy.zzb(zznb.zza, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                zzpy.zzG(zznb.zza, (String) entry.getValue());
                return;
            case 9:
                zzpy.zzq(zznb.zza, entry.getValue(), zzos.zza().zzb(entry.getValue().getClass()));
                return;
            case 10:
                zzpy.zzv(zznb.zza, entry.getValue(), zzos.zza().zzb(entry.getValue().getClass()));
                return;
            case 11:
                zzpy.zzd(zznb.zza, (zzle) entry.getValue());
                return;
            case 12:
                zzpy.zzI(zznb.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zzpy.zzr(zznb.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                zzpy.zzx(zznb.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zzpy.zzz(zznb.zza, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                zzpy.zzB(zznb.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 17:
                zzpy.zzD(zznb.zza, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }
}
