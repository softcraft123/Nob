package com.google.android.recaptcha.internal;

import android.os.Build;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzn implements zzy {
    private final zzek zza;

    public zzn(zzek zzek) {
        this.zza = zzek;
    }

    private static final zzth zzg(String str) {
        zztg zzf = zzth.zzf();
        zzf.zzw(str);
        return (zzth) zzf.zzk();
    }

    public final int zza() {
        return 11;
    }

    public final zzek zzb() {
        return this.zza;
    }

    public final Object zzc(String str, Continuation continuation) {
        zzy zzy = this;
        zzen zzb = zzz.zzb(zzy, str);
        zztf zzf = zzti.zzf();
        long j = Build.TIME;
        zztg zzf2 = zzth.zzf();
        zzf2.zzv(j);
        zzf.zze(CollectionsKt.listOf(zzg(Build.MANUFACTURER), zzg(Build.MODEL), zzg(Build.DEVICE), zzg(Build.HARDWARE), zzg(Build.FINGERPRINT), zzg(Build.PRODUCT), zzg(Build.BOARD), zzg(Build.BRAND), zzg(ArraysKt.joinToString$default((Object[]) Build.SUPPORTED_ABIS, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null)), (zzth) zzf2.zzk(), zzg(Build.ID), zzg(Build.BOOTLOADER), zzg(Build.DISPLAY), zzg(Build.TYPE), zzg(Build.TAGS)));
        zzb.zza();
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
