package com.google.android.recaptcha.internal;

import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzoz extends zzpe {
    zzoz() {
        super((zzpd) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                ((zzms) ((zzpa) zzg(i)).zza()).zzg();
            }
            for (Map.Entry key : zzd()) {
                ((zzms) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
