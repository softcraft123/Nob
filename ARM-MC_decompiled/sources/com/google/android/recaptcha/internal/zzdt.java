package com.google.android.recaptcha.internal;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.recaptcha.RecaptchaAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzdt {
    /* access modifiers changed from: private */
    public final String zza;
    /* access modifiers changed from: private */
    public final zzek zzb;
    private final zzl zzc;
    private final Lazy zzd = LazyKt.lazy(zzdm.zza);
    private final Lazy zze = LazyKt.lazy(zzdn.zza);
    private final Lazy zzf = LazyKt.lazy(zzdo.zza);
    private final Lazy zzg = LazyKt.lazy(zzdp.zza);
    private final Lazy zzh = LazyKt.lazy(zzdq.zza);
    private final zzbi zzi;

    public zzdt(String str, zzbi zzbi, zzek zzek, zzl zzl) {
        this.zza = str;
        this.zzi = zzbi;
        this.zzb = zzek;
        this.zzc = zzl;
        int i = zzav.zza;
    }

    public static final /* synthetic */ zzbr zzd(zzdt zzdt) {
        return (zzbr) zzdt.zze.getValue();
    }

    public static final /* synthetic */ zzff zzg(zzdt zzdt) {
        return (zzff) zzdt.zzd.getValue();
    }

    public static final /* synthetic */ zzfj zzh(zzdt zzdt) {
        return (zzfj) zzdt.zzg.getValue();
    }

    /* access modifiers changed from: private */
    public final Application zzr() {
        return (Application) this.zzh.getValue();
    }

    /* access modifiers changed from: private */
    public final zzbd zzs(Exception exc, zzbd zzbd) {
        return !zzx() ? new zzbd(zzbb.zzc, zzba.zzao, exc.getMessage()) : zzbd;
    }

    /* access modifiers changed from: private */
    public final zzbf zzt() {
        return (zzbf) this.zzf.getValue();
    }

    /* access modifiers changed from: private */
    public final zzek zzu(String str) {
        zzek zza2 = this.zzb.zza();
        zza2.zzc(str);
        return zza2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzv(com.google.android.recaptcha.internal.zzsc r10, long r11, kotlin.coroutines.Continuation r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.google.android.recaptcha.internal.zzdj
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.google.android.recaptcha.internal.zzdj r0 = (com.google.android.recaptcha.internal.zzdj) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdj r0 = new com.google.android.recaptcha.internal.zzdj
            r0.<init>(r9, r13)
        L_0x0018:
            r6 = r0
            java.lang.Object r13 = r6.zzb
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.zzd
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0048
            if (r1 == r8) goto L_0x003a
            if (r1 == r7) goto L_0x0031
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0031:
            java.lang.Object r10 = r6.zza
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00be
        L_0x003a:
            java.lang.Object r10 = r6.zza
            com.google.android.recaptcha.internal.zzdt r10 = (com.google.android.recaptcha.internal.zzdt) r10
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r11 = r13.m525unboximpl()
            goto L_0x0083
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r10.zzO()
            zzy(r13)
            java.util.List r13 = r9.zzw()
            java.util.Iterator r13 = r13.iterator()
        L_0x005a:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0071
            java.lang.Object r1 = r13.next()
            com.google.android.recaptcha.internal.zze r1 = (com.google.android.recaptcha.internal.zze) r1
            com.google.android.recaptcha.internal.zzl r2 = r9.zzc
            com.google.android.recaptcha.internal.zze[] r3 = new com.google.android.recaptcha.internal.zze[r8]
            r4 = 0
            r3[r4] = r1
            r2.zzf(r3)
            goto L_0x005a
        L_0x0071:
            com.google.android.recaptcha.internal.zzl r1 = r9.zzc
            com.google.android.recaptcha.internal.zzek r5 = r9.zzb
            r6.zza = r9
            r6.zzd = r8
            r4 = r10
            r2 = r11
            java.lang.Object r11 = r1.zzc(r2, r4, r5, r6)
            if (r11 != r0) goto L_0x0082
            goto L_0x00bc
        L_0x0082:
            r10 = r9
        L_0x0083:
            java.lang.Throwable r11 = kotlin.Result.m519exceptionOrNullimpl(r11)
            if (r11 != 0) goto L_0x008c
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x008c:
            com.google.android.recaptcha.internal.zzbi r12 = r10.zzi
            kotlinx.coroutines.CoroutineScope r12 = r12.zzd()
            kotlin.coroutines.CoroutineContext r12 = r12.getCoroutineContext()
            r13 = 0
            kotlinx.coroutines.JobKt__JobKt.cancelChildren$default((kotlin.coroutines.CoroutineContext) r12, (java.util.concurrent.CancellationException) r13, (int) r8, (java.lang.Object) r13)
            com.google.android.recaptcha.internal.zzbi r10 = r10.zzi
            kotlinx.coroutines.CoroutineScope r10 = r10.zzd()
            kotlin.coroutines.CoroutineContext r10 = r10.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.getJob(r10)
            kotlin.sequences.Sequence r10 = r10.getChildren()
            java.util.List r10 = kotlin.sequences.SequencesKt.toList(r10)
            java.util.Collection r10 = (java.util.Collection) r10
            r6.zza = r11
            r6.zzd = r7
            java.lang.Object r10 = kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r10, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r6)
            if (r10 != r0) goto L_0x00bd
        L_0x00bc:
            return r0
        L_0x00bd:
            r10 = r11
        L_0x00be:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzv(com.google.android.recaptcha.internal.zzsc, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List zzw() {
        List arrayList = new ArrayList();
        arrayList.add(new zzv(zzr(), this.zzb.zza(), this.zzi, (List) null, 8, (DefaultConstructorMarker) null));
        arrayList.add(new zzja(this.zzb, this.zzi));
        return CollectionsKt.toList(arrayList);
    }

    private final boolean zzx() {
        NetworkCapabilities networkCapabilities;
        int i = zzav.zza;
        zzbe zzbe = (zzbe) LazyKt.lazy(zzdi.zza).getValue();
        try {
            Object systemService = zzr().getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static final void zzy(String str) {
        try {
            zzrv zzj = zzrv.zzj(zzbt.zza(str));
            int i = zzav.zza;
            ((zzfu) LazyKt.lazy(zzde.zza).getValue()).zza(zzj);
        } catch (Exception e) {
            throw new zzbd(zzbb.zzl, zzba.zzan, e.getMessage());
        }
    }

    public final zzsp zzi(RecaptchaAction recaptchaAction, zzsi zzsi, zzsc zzsc) {
        zzso zzf2 = zzsp.zzf();
        zzf2.zzs(this.zza);
        zzf2.zze(recaptchaAction.getAction());
        zzf2.zzf(zzsc.zzN());
        zzf2.zzq(zzsc.zzM());
        zzf2.zzr(zzsi);
        return (zzsp) zzf2.zzk();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzl(java.lang.String r6, long r7, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzdd
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.google.android.recaptcha.internal.zzdd r0 = (com.google.android.recaptcha.internal.zzdd) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdd r0 = new com.google.android.recaptcha.internal.zzdd
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            com.google.android.recaptcha.internal.zzen r6 = r0.zzd
            r7 = r6
            com.google.android.recaptcha.internal.zzen r7 = (com.google.android.recaptcha.internal.zzen) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ zzbd -> 0x0032, TimeoutCancellationException -> 0x0030, Exception -> 0x002e }
            goto L_0x0058
        L_0x002e:
            r7 = move-exception
            goto L_0x0062
        L_0x0030:
            r7 = move-exception
            goto L_0x0076
        L_0x0032:
            r7 = move-exception
            goto L_0x008a
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r9)
            com.google.android.recaptcha.internal.zzek r9 = r5.zzu(r6)
            r2 = 27
            com.google.android.recaptcha.internal.zzen r9 = r9.zzf(r2)
            com.google.android.recaptcha.internal.zzl r2 = r5.zzc     // Catch:{ zzbd -> 0x0087, TimeoutCancellationException -> 0x0073, Exception -> 0x005f }
            r0.zzd = r9     // Catch:{ zzbd -> 0x0087, TimeoutCancellationException -> 0x0073, Exception -> 0x005f }
            r0.zzc = r3     // Catch:{ zzbd -> 0x0087, TimeoutCancellationException -> 0x0073, Exception -> 0x005f }
            java.lang.Object r6 = r2.zzb(r6, r7, r0)     // Catch:{ zzbd -> 0x0087, TimeoutCancellationException -> 0x0073, Exception -> 0x005f }
            if (r6 == r1) goto L_0x005e
            r4 = r9
            r9 = r6
            r6 = r4
        L_0x0058:
            com.google.android.recaptcha.internal.zzsi r9 = (com.google.android.recaptcha.internal.zzsi) r9     // Catch:{ zzbd -> 0x0032, TimeoutCancellationException -> 0x0030, Exception -> 0x002e }
            r6.zza()     // Catch:{ zzbd -> 0x0032, TimeoutCancellationException -> 0x0030, Exception -> 0x002e }
            return r9
        L_0x005e:
            return r1
        L_0x005f:
            r6 = move-exception
            r7 = r6
            r6 = r9
        L_0x0062:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzaa
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            throw r8
        L_0x0073:
            r6 = move-exception
            r7 = r6
            r6 = r9
        L_0x0076:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            throw r8
        L_0x0087:
            r6 = move-exception
            r7 = r6
            r6 = r9
        L_0x008a:
            r6.zzb(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzl(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zzm(zzsp zzsp, String str, long j, Continuation continuation) {
        return BuildersKt.withContext(this.zzi.zza().getCoroutineContext(), new zzdg(this, str, j, zzsp, (Continuation) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzn(com.google.android.recaptcha.internal.zzsc r11, long r12, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzdk
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.google.android.recaptcha.internal.zzdk r0 = (com.google.android.recaptcha.internal.zzdk) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdk r0 = new com.google.android.recaptcha.internal.zzdk
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ zzbd -> 0x002f, TimeoutCancellationException -> 0x002c, Exception -> 0x0029 }
            goto L_0x0051
        L_0x0029:
            r0 = move-exception
            r11 = r0
            goto L_0x0054
        L_0x002c:
            r0 = move-exception
            r11 = r0
            goto L_0x0062
        L_0x002f:
            r0 = move-exception
            r11 = r0
            goto L_0x0070
        L_0x0032:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.android.recaptcha.internal.zzdl r4 = new com.google.android.recaptcha.internal.zzdl     // Catch:{ zzbd -> 0x002f, TimeoutCancellationException -> 0x002c, Exception -> 0x0029 }
            r9 = 0
            r5 = r10
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r9)     // Catch:{ zzbd -> 0x002f, TimeoutCancellationException -> 0x002c, Exception -> 0x0029 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ zzbd -> 0x002f, TimeoutCancellationException -> 0x002c, Exception -> 0x0029 }
            r0.zzc = r3     // Catch:{ zzbd -> 0x002f, TimeoutCancellationException -> 0x002c, Exception -> 0x0029 }
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.withTimeout(r7, r4, r0)     // Catch:{ zzbd -> 0x002f, TimeoutCancellationException -> 0x002c, Exception -> 0x0029 }
            if (r11 != r1) goto L_0x0051
            return r1
        L_0x0051:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0054:
            com.google.android.recaptcha.internal.zzbd r12 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r13 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzap
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r13, r14, r11)
            throw r12
        L_0x0062:
            com.google.android.recaptcha.internal.zzbd r12 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r13 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r13, r14, r11)
            throw r12
        L_0x0070:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzn(com.google.android.recaptcha.internal.zzsc, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzo(long r6, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzdr
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.android.recaptcha.internal.zzdr r0 = (com.google.android.recaptcha.internal.zzdr) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdr r0 = new com.google.android.recaptcha.internal.zzdr
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            com.google.android.recaptcha.internal.zzen r6 = r0.zze
            r7 = r6
            com.google.android.recaptcha.internal.zzen r7 = (com.google.android.recaptcha.internal.zzen) r7
            com.google.android.recaptcha.internal.zzdt r7 = r0.zzd
            r0 = r7
            com.google.android.recaptcha.internal.zzdt r0 = (com.google.android.recaptcha.internal.zzdt) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ zzbd -> 0x0037, TimeoutCancellationException -> 0x0035, Exception -> 0x0033 }
            goto L_0x0065
        L_0x0033:
            r8 = move-exception
            goto L_0x006e
        L_0x0035:
            r8 = move-exception
            goto L_0x0088
        L_0x0037:
            r8 = move-exception
            goto L_0x00a5
        L_0x003a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.android.recaptcha.internal.zzek r8 = r5.zzb
            r2 = 22
            com.google.android.recaptcha.internal.zzen r8 = r8.zzf(r2)
            com.google.android.recaptcha.internal.zzds r2 = new com.google.android.recaptcha.internal.zzds     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            r4 = 0
            r2.<init>(r5, r8, r4)     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            r0.zzd = r5     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            r0.zze = r8     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            r0.zzc = r3     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.withTimeout(r6, r2, r0)     // Catch:{ zzbd -> 0x00a0, TimeoutCancellationException -> 0x0083, Exception -> 0x0069 }
            if (r6 == r1) goto L_0x0068
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L_0x0065:
            com.google.android.recaptcha.internal.zzsc r8 = (com.google.android.recaptcha.internal.zzsc) r8     // Catch:{ zzbd -> 0x0037, TimeoutCancellationException -> 0x0035, Exception -> 0x0033 }
            return r8
        L_0x0068:
            return r1
        L_0x0069:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L_0x006e:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r2 = com.google.android.recaptcha.internal.zzba.zzaw
            java.lang.String r3 = r8.getMessage()
            r0.<init>(r1, r2, r3)
            com.google.android.recaptcha.internal.zzbd r7 = r7.zzs(r8, r0)
            r6.zzb(r7)
            throw r7
        L_0x0083:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L_0x0088:
            r0 = r8
            java.lang.Exception r0 = (java.lang.Exception) r0
            com.google.android.recaptcha.internal.zzbd r1 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r2 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r3 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r8 = r8.getMessage()
            r1.<init>(r2, r3, r8)
            com.google.android.recaptcha.internal.zzbd r7 = r7.zzs(r0, r1)
            r6.zzb(r7)
            throw r7
        L_0x00a0:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L_0x00a5:
            com.google.android.recaptcha.internal.zzbb r0 = r8.zzb()
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00b8
            r0 = r8
            java.lang.Exception r0 = (java.lang.Exception) r0
            com.google.android.recaptcha.internal.zzbd r8 = r7.zzs(r0, r8)
        L_0x00b8:
            r6.zzb(r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void zzq(String str, zzsr zzsr) {
        zzen zzf2 = zzu(str).zzf(29);
        try {
            Iterable<zzst> zzk = zzsr.zzk();
            Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(zzk, 10)), 16));
            for (zzst zzst : zzk) {
                Pair pair = TuplesKt.to(zzst.zzg(), zzst.zzi());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            zzt().zzb(linkedHashMap);
            this.zzc.zzg(zzsr);
            zzf2.zza();
        } catch (zzbd e) {
            zzf2.zzb(e);
        } catch (Exception e2) {
            zzf2.zzb(new zzbd(zzbb.zzb, zzba.zzas, e2.getMessage()));
        }
    }
}
