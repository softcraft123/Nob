package com.google.android.recaptcha.internal;

import android.os.Build;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzab implements zzy {
    private final zzek zza;

    public zzab(zzek zzek) {
        this.zza = zzek;
    }

    public final int zza() {
        return 10;
    }

    public final zzek zzb() {
        return this.zza;
    }

    public final Object zzc(String str, Continuation continuation) {
        zzy zzy = this;
        zzen zzb = zzz.zzb(zzy, str);
        int i = Build.VERSION.SDK_INT;
        zzb.zza();
        zztf zzf = zzti.zzf();
        zztg zzf2 = zzth.zzf();
        zzf2.zzw(String.valueOf(i));
        zzf.zze(CollectionsKt.listOf(zzf2.zzk()));
        return zzz.zza(zzy, (zzti) zzf.zzk());
    }

    public final Object zzd(zzse zzse, Continuation continuation) {
        zzz.zzc(this).zza();
        return Unit.INSTANCE;
    }

    public final void zze(zzsr zzsr) {
    }

    public final boolean zzf() {
        return true;
    }
}
