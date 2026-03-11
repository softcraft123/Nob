package com.google.android.recaptcha.internal;

import android.content.Context;
import java.nio.charset.StandardCharsets;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzae implements zzy {
    private final zzek zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzan zzc;
    private boolean zzd = true;
    /* access modifiers changed from: private */
    public String zze = "";
    private final zzbs zzf;

    public zzae(zzek zzek, Context context, CoroutineScope coroutineScope, zzan zzan, zzbs zzbs) {
        this.zza = zzek;
        this.zzb = context;
        this.zzc = zzan;
        this.zzf = zzbs;
    }

    private static final String zzi(zzle zzle) {
        zzkh zzg = zzkh.zzg();
        byte[] zzl = zzle.zzl();
        byte[] zzd2 = zzjz.zza().zza(zzg.zzi(zzl, 0, zzl.length), StandardCharsets.UTF_8).zzd();
        zzle zzk = zzle.zzk(zzd2, 0, zzd2.length);
        zzkh zzh = zzkh.zzh();
        byte[] zzl2 = zzk.zzl();
        return zzh.zzi(zzl2, 0, zzl2.length);
    }

    public final int zza() {
        return 2;
    }

    public final zzek zzb() {
        return this.zza;
    }

    public final Object zzc(String str, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new zzac(this, str, (Continuation) null), continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (r12.zze(r0) != r1) goto L_0x0093;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(com.google.android.recaptcha.internal.zzse r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.google.android.recaptcha.internal.zzad
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.google.android.recaptcha.internal.zzad r0 = (com.google.android.recaptcha.internal.zzad) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzad r0 = new com.google.android.recaptcha.internal.zzad
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r5) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            java.lang.Object r11 = r0.zza
            com.google.android.recaptcha.internal.zzen r11 = (com.google.android.recaptcha.internal.zzen) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0093
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            com.google.android.recaptcha.internal.zzen r11 = r0.zze
            r2 = r11
            com.google.android.recaptcha.internal.zzen r2 = (com.google.android.recaptcha.internal.zzen) r2
            java.lang.Object r2 = r0.zza
            com.google.android.recaptcha.internal.zzae r2 = (com.google.android.recaptcha.internal.zzae) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0084
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r10
            com.google.android.recaptcha.internal.zzy r12 = (com.google.android.recaptcha.internal.zzy) r12
            com.google.android.recaptcha.internal.zzen r12 = com.google.android.recaptcha.internal.zzz.zzc(r12)
            com.google.android.recaptcha.internal.zzbs r2 = r10.zzf
            android.content.Context r6 = r10.zzb
            int r2 = r2.zza(r6)
            r6 = 3
            if (r2 != r6) goto L_0x009a
            long r6 = r11.zzf()
            r8 = 0
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0066
            goto L_0x009a
        L_0x0066:
            com.google.android.recaptcha.internal.zzle r2 = r11.zzg()
            java.lang.String r2 = zzi(r2)
            r10.zze = r2
            com.google.android.recaptcha.internal.zzan r2 = r10.zzc
            long r6 = r11.zzf()
            r0.zza = r10
            r0.zze = r12
            r0.zzd = r5
            java.lang.Object r11 = r2.zzd(r6, r0)
            if (r11 == r1) goto L_0x0099
            r2 = r10
            r11 = r12
        L_0x0084:
            com.google.android.recaptcha.internal.zzan r12 = r2.zzc
            r0.zza = r11
            r0.zze = r3
            r0.zzd = r4
            java.lang.Object r12 = r12.zze(r0)
            if (r12 != r1) goto L_0x0093
            goto L_0x0099
        L_0x0093:
            r11.zza()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0099:
            return r1
        L_0x009a:
            r11 = 0
            r10.zzd = r11
            com.google.android.recaptcha.internal.zzbd r11 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r0 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r1 = com.google.android.recaptcha.internal.zzba.zzab
            r11.<init>(r0, r1, r3)
            r12.zzb(r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzae.zzd(com.google.android.recaptcha.internal.zzse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void zze(zzsr zzsr) {
        this.zze = zzi(zzsr.zzf());
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
