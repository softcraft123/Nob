package com.google.android.recaptcha.internal;

import android.app.Application;
import android.webkit.WebView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzja extends zze {
    public CompletableDeferred zza;
    public zzfo zzb;
    private final zzek zzc;
    /* access modifiers changed from: private */
    public final Map zzd = zzjb.zza();
    /* access modifiers changed from: private */
    public final Map zze = new LinkedHashMap();
    /* access modifiers changed from: private */
    public zzsc zzf;
    private final zzcb zzg = new zzcb(zzje.zza);
    /* access modifiers changed from: private */
    public final zzjh zzh = zzjh.zzc();
    private final zzij zzi = new zzij(this);
    /* access modifiers changed from: private */
    public final zzek zzj;
    private final Lazy zzk;
    private final Lazy zzl;
    private final Lazy zzm;
    private final Lazy zzn;
    private final Lazy zzo;
    /* access modifiers changed from: private */
    public zzen zzp;
    private final zzbi zzq;

    public zzja(zzek zzek, zzbi zzbi) {
        this.zzc = zzek;
        this.zzq = zzbi;
        zzek zza2 = zzek.zza();
        zza2.zzc(zzek.zzd());
        this.zzj = zza2;
        int i = zzav.zza;
        this.zzk = LazyKt.lazy(zzis.zza);
        this.zzl = LazyKt.lazy(zzit.zza);
        this.zzm = LazyKt.lazy(zziu.zza);
        this.zzn = LazyKt.lazy(zziv.zza);
        this.zzo = LazyKt.lazy(zziw.zza);
    }

    private final Application zzD() {
        return (Application) this.zzo.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzE(com.google.android.recaptcha.internal.zzsc r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzim
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.google.android.recaptcha.internal.zzim r0 = (com.google.android.recaptcha.internal.zzim) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzim r0 = new com.google.android.recaptcha.internal.zzim
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            com.google.android.recaptcha.internal.zzja r8 = r0.zzd
            r0 = r8
            com.google.android.recaptcha.internal.zzja r0 = (com.google.android.recaptcha.internal.zzja) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ zzbd -> 0x002e }
            goto L_0x0052
        L_0x002e:
            r0 = move-exception
            r9 = r0
            goto L_0x006f
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Lazy r9 = r7.zzn     // Catch:{ zzbd -> 0x006b }
            java.lang.Object r9 = r9.getValue()     // Catch:{ zzbd -> 0x006b }
            com.google.android.recaptcha.internal.zzff r9 = (com.google.android.recaptcha.internal.zzff) r9     // Catch:{ zzbd -> 0x006b }
            com.google.android.recaptcha.internal.zzek r2 = r7.zzj     // Catch:{ zzbd -> 0x006b }
            r0.zzd = r7     // Catch:{ zzbd -> 0x006b }
            r0.zzc = r3     // Catch:{ zzbd -> 0x006b }
            java.lang.Object r9 = r9.zzd(r8, r2, r0)     // Catch:{ zzbd -> 0x006b }
            if (r9 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r8 = r7
        L_0x0052:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ zzbd -> 0x002e }
            com.google.android.recaptcha.internal.zzbi r0 = r8.zzq     // Catch:{ zzbd -> 0x002e }
            kotlinx.coroutines.CoroutineScope r1 = r0.zzb()     // Catch:{ zzbd -> 0x002e }
            com.google.android.recaptcha.internal.zzin r0 = new com.google.android.recaptcha.internal.zzin     // Catch:{ zzbd -> 0x002e }
            r2 = 0
            r0.<init>(r8, r9, r2)     // Catch:{ zzbd -> 0x002e }
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ zzbd -> 0x002e }
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch:{ zzbd -> 0x002e }
            goto L_0x0078
        L_0x006b:
            r0 = move-exception
            r8 = r0
            r9 = r8
            r8 = r7
        L_0x006f:
            kotlinx.coroutines.CompletableDeferred r8 = r8.zzA()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.completeExceptionally(r9)
        L_0x0078:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzE(com.google.android.recaptcha.internal.zzsc, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzF(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzio
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.google.android.recaptcha.internal.zzio r0 = (com.google.android.recaptcha.internal.zzio) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzio r0 = new com.google.android.recaptcha.internal.zzio
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.String r9 = r0.zzf
            r1 = r9
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r0.zze
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.recaptcha.internal.zzja r2 = r0.zzd
            r0 = r2
            com.google.android.recaptcha.internal.zzja r0 = (com.google.android.recaptcha.internal.zzja) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x003b }
            r3 = r9
            r4 = r1
            r9 = r2
            goto L_0x0071
        L_0x003b:
            r0 = move-exception
            r9 = r0
            goto L_0x0086
        L_0x003e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r10)
            com.google.android.recaptcha.internal.zzek r10 = r8.zzj
            r2 = 26
            com.google.android.recaptcha.internal.zzen r10 = r10.zzf(r2)
            r8.zzp = r10
            kotlin.Lazy r10 = r8.zzl     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Exception -> 0x0083 }
            com.google.android.recaptcha.internal.zzbr r10 = (com.google.android.recaptcha.internal.zzbr) r10     // Catch:{ Exception -> 0x0083 }
            java.lang.String r10 = r10.zza()     // Catch:{ Exception -> 0x0083 }
            r0.zzd = r8     // Catch:{ Exception -> 0x0083 }
            r0.zze = r9     // Catch:{ Exception -> 0x0083 }
            r0.zzf = r10     // Catch:{ Exception -> 0x0083 }
            r0.zzc = r3     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r0 = r8.zzw(r0)     // Catch:{ Exception -> 0x0083 }
            if (r0 == r1) goto L_0x0082
            r4 = r9
            r3 = r10
            r10 = r0
            r9 = r8
        L_0x0071:
            r2 = r10
            android.webkit.WebView r2 = (android.webkit.WebView) r2     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "text/html"
            java.lang.String r6 = "utf-8"
            r7 = 0
            r2.loadDataWithBaseURL(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x007d }
            goto L_0x00a6
        L_0x007d:
            r0 = move-exception
            r10 = r0
            r2 = r9
            r9 = r10
            goto L_0x0086
        L_0x0082:
            return r1
        L_0x0083:
            r0 = move-exception
            r9 = r0
            r2 = r8
        L_0x0086:
            com.google.android.recaptcha.internal.zzbd r10 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r0 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r1 = com.google.android.recaptcha.internal.zzba.zzU
            java.lang.String r9 = r9.getMessage()
            r10.<init>(r0, r1, r9)
            com.google.android.recaptcha.internal.zzen r9 = r2.zzp
            if (r9 == 0) goto L_0x009a
            r9.zzb(r10)
        L_0x009a:
            r9 = 0
            r2.zzp = r9
            kotlinx.coroutines.CompletableDeferred r9 = r2.zzA()
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            r9.completeExceptionally(r10)
        L_0x00a6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzF(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzG(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.google.android.recaptcha.internal.zzix
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.google.android.recaptcha.internal.zzix r0 = (com.google.android.recaptcha.internal.zzix) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzix r0 = new com.google.android.recaptcha.internal.zzix
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.String r9 = r0.zze
            r1 = r9
            java.lang.String r1 = (java.lang.String) r1
            com.google.android.recaptcha.internal.zzja r0 = r0.zzd
            r1 = r0
            com.google.android.recaptcha.internal.zzja r1 = (com.google.android.recaptcha.internal.zzja) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008b
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            java.lang.String r9 = r0.zze
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.recaptcha.internal.zzja r2 = r0.zzd
            r5 = r2
            com.google.android.recaptcha.internal.zzja r5 = (com.google.android.recaptcha.internal.zzja) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006e
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r10)
            com.google.android.recaptcha.internal.zzcb r10 = r8.zzg
            r2 = 3
            com.google.android.recaptcha.internal.zzje[] r2 = new com.google.android.recaptcha.internal.zzje[r2]
            r5 = 0
            com.google.android.recaptcha.internal.zzje r6 = com.google.android.recaptcha.internal.zzje.zzd
            r2[r5] = r6
            com.google.android.recaptcha.internal.zzje r5 = com.google.android.recaptcha.internal.zzje.zzc
            r2[r4] = r5
            com.google.android.recaptcha.internal.zzje r5 = com.google.android.recaptcha.internal.zzje.zzb
            r2[r3] = r5
            r0.zzd = r8
            r0.zze = r9
            r0.zzc = r4
            java.lang.Object r10 = r10.zzb(r2, r0)
            if (r10 == r1) goto L_0x00b5
            r2 = r8
        L_0x006e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0079
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0079:
            com.google.android.recaptcha.internal.zzcb r10 = r2.zzg
            com.google.android.recaptcha.internal.zzje r5 = com.google.android.recaptcha.internal.zzje.zzb
            r0.zzd = r2
            r0.zze = r9
            r0.zzc = r3
            java.lang.Object r10 = r10.zzc(r5, r0)
            if (r10 != r1) goto L_0x008a
            goto L_0x00b5
        L_0x008a:
            r0 = r2
        L_0x008b:
            r10 = 0
            kotlinx.coroutines.CompletableDeferred r1 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r10, r4, r10)
            r0.zza = r1
            com.google.android.recaptcha.internal.zzek r1 = r0.zzj
            r1.zzc(r9)
            r9 = 42
            com.google.android.recaptcha.internal.zzen r9 = r1.zzf(r9)
            com.google.android.recaptcha.internal.zzbi r1 = r0.zzq
            kotlinx.coroutines.CoroutineScope r2 = r1.zza()
            com.google.android.recaptcha.internal.zziz r1 = new com.google.android.recaptcha.internal.zziz
            r1.<init>(r0, r9, r10)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00b5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzG(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ zzfk zzp(zzja zzja) {
        return (zzfk) zzja.zzm.getValue();
    }

    public final CompletableDeferred zzA() {
        CompletableDeferred completableDeferred = this.zza;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }

    public final zzft zzC(zzsc zzsc, zzcg zzcg, WebView webView) {
        zzfw zzfw = new zzfw(webView, this.zzq.zzb());
        zzhy zzhy = new zzhy();
        zzhy.zzb(CollectionsKt.toLongArray(zzsc.zzP()));
        zzfw zzfw2 = zzfw;
        zzgf zzgf = new zzgf(zzfw, zzcg, new zzbo());
        zzhz zzhz = new zzhz(zzhy, new zzhw());
        zzgf.zze(3, zzD());
        zzgf.zze(5, zzig.zza());
        zzgf.zze(6, new zzia(zzD()));
        zzgf.zze(7, new zzic());
        zzgf.zze(8, new zzii(zzD()));
        zzgf.zze(9, new zzid(zzD()));
        zzgf.zze(10, new zzib(zzD()));
        return new zzft(this.zzq.zzd(), zzgf, zzhz, zzfn.zza());
    }

    /* access modifiers changed from: protected */
    public final zzen zza(String str) {
        zzek zzek = this.zzc;
        zzek.zzc(str);
        return zzek.zzf(33);
    }

    /* access modifiers changed from: protected */
    public final zzen zzb() {
        zzek zzek = this.zzc;
        zzek.zzc(zzek.zzd());
        return zzek.zzf(32);
    }

    /* access modifiers changed from: protected */
    public final Object zzd(String str, Continuation continuation) {
        zzsh zzf2 = zzsi.zzf();
        zzf2.zze(str);
        return zzf2.zzk();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        if (r8.zzG(r4, r2) != r3) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzf(java.lang.String r18, kotlin.coroutines.Continuation r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzip
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.google.android.recaptcha.internal.zzip r2 = (com.google.android.recaptcha.internal.zzip) r2
            int r3 = r2.zzc
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.zzc = r3
            goto L_0x001c
        L_0x0017:
            com.google.android.recaptcha.internal.zzip r2 = new com.google.android.recaptcha.internal.zzip
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.zza
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.zzc
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r4 == 0) goto L_0x008f
            if (r4 == r9) goto L_0x0081
            if (r4 == r8) goto L_0x0073
            if (r4 == r7) goto L_0x0064
            if (r4 == r6) goto L_0x0050
            if (r4 != r5) goto L_0x0048
            java.lang.String r3 = r2.zze
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.recaptcha.internal.zzja r2 = r2.zzd
            r4 = r2
            com.google.android.recaptcha.internal.zzja r4 = (com.google.android.recaptcha.internal.zzja) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0143
        L_0x0045:
            r0 = move-exception
            goto L_0x017d
        L_0x0048:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0050:
            java.lang.String r4 = r2.zze
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.recaptcha.internal.zzja r6 = r2.zzd
            r7 = r6
            com.google.android.recaptcha.internal.zzja r7 = (com.google.android.recaptcha.internal.zzja) r7
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x005f }
            goto L_0x00fb
        L_0x005f:
            r0 = move-exception
            r3 = r4
            r2 = r6
            goto L_0x017d
        L_0x0064:
            java.lang.String r4 = r2.zze
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7
            com.google.android.recaptcha.internal.zzja r7 = r2.zzd
            r8 = r7
            com.google.android.recaptcha.internal.zzja r8 = (com.google.android.recaptcha.internal.zzja) r8
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00ea
        L_0x0073:
            java.lang.String r4 = r2.zze
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            com.google.android.recaptcha.internal.zzja r8 = r2.zzd
            r11 = r8
            com.google.android.recaptcha.internal.zzja r11 = (com.google.android.recaptcha.internal.zzja) r11
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00d5
        L_0x0081:
            java.lang.String r4 = r2.zze
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11
            com.google.android.recaptcha.internal.zzja r11 = r2.zzd
            r12 = r11
            com.google.android.recaptcha.internal.zzja r12 = (com.google.android.recaptcha.internal.zzja) r12
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00a6
        L_0x008f:
            kotlin.ResultKt.throwOnFailure(r0)
            com.google.android.recaptcha.internal.zzcb r0 = r1.zzg
            com.google.android.recaptcha.internal.zzje r4 = com.google.android.recaptcha.internal.zzje.zzd
            r2.zzd = r1
            r11 = r18
            r2.zze = r11
            r2.zzc = r9
            java.lang.Object r0 = r0.zza(r4, r2)
            if (r0 == r3) goto L_0x01af
            r4 = r11
            r11 = r1
        L_0x00a6:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00c4
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r2 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r3 = com.google.android.recaptcha.internal.zzba.zzav
            r0.<init>(r2, r3, r10)
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m516constructorimpl(r0)
            return r0
        L_0x00c4:
            com.google.android.recaptcha.internal.zzcb r0 = r11.zzg
            com.google.android.recaptcha.internal.zzje r12 = com.google.android.recaptcha.internal.zzje.zzc
            r2.zzd = r11
            r2.zze = r4
            r2.zzc = r8
            java.lang.Object r0 = r0.zza(r12, r2)
            if (r0 == r3) goto L_0x01af
            r8 = r11
        L_0x00d5:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00e9
            r2.zzd = r8
            r2.zze = r4
            r2.zzc = r7
            java.lang.Object r0 = r8.zzG(r4, r2)
            if (r0 == r3) goto L_0x01af
        L_0x00e9:
            r7 = r8
        L_0x00ea:
            kotlinx.coroutines.CompletableDeferred r0 = r7.zzA()     // Catch:{ Exception -> 0x017a }
            r2.zzd = r7     // Catch:{ Exception -> 0x017a }
            r2.zze = r4     // Catch:{ Exception -> 0x017a }
            r2.zzc = r6     // Catch:{ Exception -> 0x017a }
            java.lang.Object r0 = r0.await(r2)     // Catch:{ Exception -> 0x017a }
            if (r0 == r3) goto L_0x01af
            r6 = r7
        L_0x00fb:
            kotlinx.coroutines.CompletableDeferred r0 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r10, r9, r10)     // Catch:{ Exception -> 0x005f }
            java.util.Map r7 = r6.zze     // Catch:{ Exception -> 0x005f }
            r7.put(r4, r0)     // Catch:{ Exception -> 0x005f }
            com.google.android.recaptcha.internal.zztp r7 = com.google.android.recaptcha.internal.zztq.zzf()     // Catch:{ Exception -> 0x005f }
            r7.zze(r4)     // Catch:{ Exception -> 0x005f }
            com.google.android.recaptcha.internal.zznd r7 = r7.zzk()     // Catch:{ Exception -> 0x005f }
            com.google.android.recaptcha.internal.zztq r7 = (com.google.android.recaptcha.internal.zztq) r7     // Catch:{ Exception -> 0x005f }
            byte[] r7 = r7.zzd()     // Catch:{ Exception -> 0x005f }
            com.google.android.recaptcha.internal.zzkh r8 = com.google.android.recaptcha.internal.zzkh.zzh()     // Catch:{ Exception -> 0x005f }
            int r9 = r7.length     // Catch:{ Exception -> 0x005f }
            r11 = 0
            java.lang.String r7 = r8.zzi(r7, r11, r9)     // Catch:{ Exception -> 0x005f }
            com.google.android.recaptcha.internal.zzbi r8 = r6.zzq     // Catch:{ Exception -> 0x005f }
            kotlinx.coroutines.CoroutineScope r11 = r8.zzb()     // Catch:{ Exception -> 0x005f }
            com.google.android.recaptcha.internal.zziq r8 = new com.google.android.recaptcha.internal.zziq     // Catch:{ Exception -> 0x005f }
            r8.<init>(r6, r7, r10)     // Catch:{ Exception -> 0x005f }
            r14 = r8
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ Exception -> 0x005f }
            r15 = 3
            r16 = 0
            r12 = 0
            r13 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x005f }
            r2.zzd = r6     // Catch:{ Exception -> 0x005f }
            r2.zze = r4     // Catch:{ Exception -> 0x005f }
            r2.zzc = r5     // Catch:{ Exception -> 0x005f }
            java.lang.Object r0 = r0.await(r2)     // Catch:{ Exception -> 0x005f }
            if (r0 == r3) goto L_0x01af
            r3 = r4
            r2 = r6
        L_0x0143:
            com.google.android.recaptcha.internal.zzsi r0 = (com.google.android.recaptcha.internal.zzsi) r0     // Catch:{ Exception -> 0x0045 }
            com.google.android.recaptcha.internal.zzsh r4 = com.google.android.recaptcha.internal.zzsi.zzf()     // Catch:{ Exception -> 0x0045 }
            r4.zze(r3)     // Catch:{ Exception -> 0x0045 }
            com.google.android.recaptcha.internal.zzsl r5 = com.google.android.recaptcha.internal.zzsm.zzf()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r6 = r0.zzl()     // Catch:{ Exception -> 0x0045 }
            r5.zze(r6)     // Catch:{ Exception -> 0x0045 }
            r4.zzq(r5)     // Catch:{ Exception -> 0x0045 }
            com.google.android.recaptcha.internal.zzsj r5 = com.google.android.recaptcha.internal.zzsk.zzf()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r6 = r0.zzj()     // Catch:{ Exception -> 0x0045 }
            r5.zze(r6)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r0 = r0.zzM()     // Catch:{ Exception -> 0x0045 }
            r5.zzf(r0)     // Catch:{ Exception -> 0x0045 }
            r4.zzr(r5)     // Catch:{ Exception -> 0x0045 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0045 }
            com.google.android.recaptcha.internal.zznd r0 = r4.zzk()     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r0 = kotlin.Result.m516constructorimpl(r0)     // Catch:{ Exception -> 0x0045 }
            return r0
        L_0x017a:
            r0 = move-exception
            r3 = r4
            r2 = r7
        L_0x017d:
            com.google.android.recaptcha.internal.zzbd r4 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r5 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r6 = com.google.android.recaptcha.internal.zzba.zzW
            java.lang.String r7 = r0.getMessage()
            r4.<init>(r5, r6, r7)
            com.google.android.recaptcha.internal.zzbd r0 = com.google.android.recaptcha.internal.zzf.zza(r0, r4)
            java.util.Map r2 = r2.zze
            java.lang.Object r2 = r2.remove(r3)
            kotlinx.coroutines.CompletableDeferred r2 = (kotlinx.coroutines.CompletableDeferred) r2
            if (r2 == 0) goto L_0x01a2
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            boolean r2 = r2.completeExceptionally(r3)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
        L_0x01a2:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m516constructorimpl(r0)
            return r0
        L_0x01af:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzf(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final Object zzg(zzbd zzbd, Continuation continuation) {
        if (Intrinsics.areEqual((Object) zzbd.zza(), (Object) zzba.zzb)) {
            zzen zzen = this.zzp;
            if (zzen != null) {
                zzen.zzb(zzbd);
            }
            this.zzp = null;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (zzG(r6, r0) != r1) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (r6.zzc(r7, r0) == r1) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzh(com.google.android.recaptcha.internal.zzsc r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzir
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.google.android.recaptcha.internal.zzir r0 = (com.google.android.recaptcha.internal.zzir) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzir r0 = new com.google.android.recaptcha.internal.zzir
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0074
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.zzT()
            if (r7 == 0) goto L_0x0067
            boolean r7 = r6.zzR()
            if (r7 == 0) goto L_0x0067
            boolean r7 = r6.zzQ()
            if (r7 != 0) goto L_0x004e
            goto L_0x0067
        L_0x004e:
            r5.zzf = r6
            com.google.android.recaptcha.internal.zzek r6 = r5.zzc
            java.lang.String r6 = r6.zzd()
            r0.zzc = r3
            java.lang.Object r6 = r5.zzG(r6, r0)
            if (r6 == r1) goto L_0x0073
        L_0x005e:
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            java.lang.Object r6 = kotlin.Result.m516constructorimpl(r6)
            return r6
        L_0x0067:
            com.google.android.recaptcha.internal.zzcb r6 = r5.zzg
            com.google.android.recaptcha.internal.zzje r7 = com.google.android.recaptcha.internal.zzje.zzd
            r0.zzc = r4
            java.lang.Object r6 = r6.zzc(r7, r0)
            if (r6 != r1) goto L_0x0074
        L_0x0073:
            return r1
        L_0x0074:
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            com.google.android.recaptcha.internal.zzbd r6 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r7 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzav
            r1 = 0
            r6.<init>(r7, r0, r1)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m516constructorimpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzja.zzh(com.google.android.recaptcha.internal.zzsc, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final Object zzi(String str, long j, Exception exc, Continuation continuation) {
        exc.getMessage();
        CompletableDeferred completableDeferred = (CompletableDeferred) this.zze.remove(str);
        if (completableDeferred != null) {
            Boxing.boxBoolean(completableDeferred.completeExceptionally(exc));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(Exception exc, Continuation continuation) {
        Long zza2 = this.zzi.zza();
        if ((exc instanceof TimeoutCancellationException) && zza2 == null) {
            return new zzbd(zzbb.zzc, zzba.zzH, (String) null);
        }
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzV, exc.getMessage()));
    }

    public final zzcb zzm() {
        return this.zzg;
    }

    public final zzij zzq() {
        return this.zzi;
    }

    public final Object zzw(Continuation continuation) {
        return BuildersKt.withContext(this.zzq.zzb().getCoroutineContext(), new zzjc((zzjd) this.zzk.getValue(), zzD(), (Continuation) null), continuation);
    }

    public final Object zzx(Continuation continuation) {
        Object withContext = BuildersKt.withContext(this.zzq.zzb().getCoroutineContext(), new zzil(this, (Continuation) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
