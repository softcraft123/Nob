package com.google.android.recaptcha.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzp implements zzy {
    private final zzek zza;
    private final Lazy zzb = LazyKt.lazy(zzo.zza);
    private boolean zzc = true;

    public zzp(zzek zzek) {
        this.zza = zzek;
        int i = zzav.zza;
    }

    private final zzbf zzg() {
        return (zzbf) this.zzb.getValue();
    }

    public final int zza() {
        return 25;
    }

    public final zzek zzb() {
        return this.zza;
    }

    public final Object zzc(String str, Continuation continuation) {
        zzy zzy = this;
        zzen zzb2 = zzz.zzb(zzy, str);
        String zza2 = zzg().zza();
        zzb2.zza();
        zztf zzf = zzti.zzf();
        zztg zzf2 = zzth.zzf();
        zzf2.zzw(zza2);
        zzf.zze(CollectionsKt.listOf(zzf2.zzk()));
        return zzz.zza(zzy, (zzti) zzf.zzk());
    }

    public final Object zzd(zzse zzse, Continuation continuation) {
        zzen zzc2 = zzz.zzc(this);
        if (zzse.zzl().length() == 0) {
            this.zzc = false;
            zzc2.zzb(new zzbd(zzbb.zzb, zzba.zzab, (String) null));
            return Unit.INSTANCE;
        }
        zzg().zzb(MapsKt.mapOf(TuplesKt.to("_GRECAPTCHA_KC", zzse.zzl())));
        zzc2.zza();
        return Unit.INSTANCE;
    }

    public final void zze(zzsr zzsr) {
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
