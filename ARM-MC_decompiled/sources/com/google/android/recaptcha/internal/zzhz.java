package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzhz implements zzhx {
    private final zzhy zza;

    public zzhz(zzhy zzhy, zzhw zzhw) {
        this.zza = zzhy;
    }

    private final zztz zzb(String str, List list) throws zzce {
        CharSequence charSequence = str;
        if (charSequence.length() != 0) {
            try {
                zzhv zzhv = new zzhv(this.zza.zza(CollectionsKt.toLongArray(list)), 255, zzhv.zza);
                StringBuilder sb = new StringBuilder(str.length());
                for (int i = 0; i < charSequence.length(); i++) {
                    sb.append((char) UInt.m611constructorimpl(UInt.m611constructorimpl(charSequence.charAt(i)) ^ UInt.m611constructorimpl((int) zzhv.zza())));
                }
                return zztz.zzg(zzkh.zzh().zzj(sb.toString()));
            } catch (Exception e) {
                throw new zzce(3, 18, e);
            }
        } else {
            throw new zzce(3, 17, (Throwable) null);
        }
    }

    public final zztz zza(zzub zzub) throws zzce {
        zzjh zzb = zzjh.zzb();
        zztz zzb2 = zzb(zzub.zzj(), zzub.zzk());
        zzb.zzf();
        long zza2 = zzb.zza(TimeUnit.MICROSECONDS);
        int i = zzbk.zza;
        zzbk.zza(zzbl.zzh.zza(), zza2);
        return zzb2;
    }
}
