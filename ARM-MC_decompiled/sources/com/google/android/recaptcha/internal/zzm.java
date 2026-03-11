package com.google.android.recaptcha.internal;

import android.content.ContentResolver;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzm implements zzy {
    private final zzek zza;
    private final ContentResolver zzb;

    public zzm(zzek zzek, ContentResolver contentResolver) {
        this.zza = zzek;
        this.zzb = contentResolver;
    }

    public final int zza() {
        return 17;
    }

    public final zzek zzb() {
        return this.zza;
    }

    public final Object zzc(String str, Continuation continuation) {
        zzy zzy = this;
        zzen zzb2 = zzz.zzb(zzy, str);
        String zza2 = zzap.zza(this.zzb);
        zzb2.zza();
        zztf zzf = zzti.zzf();
        zztg zzf2 = zzth.zzf();
        zzf2.zzw(zza2);
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
