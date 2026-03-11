package com.google.android.recaptcha.internal;

import android.app.Application;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.recaptcha.RecaptchaException;
import java.util.List;
import java.util.UUID;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzcv {
    private final Application zza;
    private final Mutex zzb = MutexKt.Mutex$default(false, 1, (Object) null);
    /* access modifiers changed from: private */
    public zzdc zzc;
    private final String zzd = UUID.randomUUID().toString();
    private final zzl zze;
    private zzbi zzf;

    public zzcv(Application application) {
        this.zza = application;
        zzbi zzbi = new zzbi();
        zzbi zzbi2 = zzbi;
        this.zzf = zzbi;
        this.zze = new zzl((List) null, 1, (DefaultConstructorMarker) null);
        int i = zzav.zza;
        zzaz zzaz = new zzaz((List) null, 1, (DefaultConstructorMarker) null);
        Class<zzaz> cls = zzaz.class;
        zzfu zzfu = new zzfu();
        Class<zzfu> cls2 = zzfu.class;
        zzbe zzbe = new zzbe();
        Class<zzbe> cls3 = zzbe.class;
        zzjd zzjd = new zzjd();
        Class<zzjd> cls4 = zzjd.class;
        zzbr zzbr = new zzbr("https://www.recaptcha.net/recaptcha/api3");
        Class<zzbr> cls5 = zzbr.class;
        zzex zzex = new zzex((zzfm) null, 1, (DefaultConstructorMarker) null);
        Class<zzex> cls6 = zzex.class;
        zzfk zzfk = new zzfk(true);
        Class<zzfk> cls7 = zzfk.class;
        Context context = application;
        zzbf zzbf = new zzbf(context);
        Class<zzbf> cls8 = zzbf.class;
        zzfj zzfj = new zzfj();
        Class<zzfj> cls9 = zzfj.class;
        zzbm zzbm = new zzbm(context);
        Class<zzaq> cls10 = zzaq.class;
        Class<zzey> cls11 = zzey.class;
        Class<zzff> cls12 = zzff.class;
        zzaw[] zzawArr = {new zzaw("com.google.android.recaptcha.internal.zzaz".hashCode(), zzaz), new zzaw("com.google.android.recaptcha.internal.zzfu".hashCode(), zzfu), new zzaw("com.google.android.recaptcha.internal.zzbe".hashCode(), zzbe), new zzaw("com.google.android.recaptcha.internal.zzjd".hashCode(), zzjd), new zzaw("com.google.android.recaptcha.internal.zzbr".hashCode(), zzbr), new zzaw("com.google.android.recaptcha.internal.zzex".hashCode(), zzex), new zzaw("com.google.android.recaptcha.internal.zzfk".hashCode(), zzfk), new zzaw(Application.class.getName().hashCode(), application), new zzaw("com.google.android.recaptcha.internal.zzbf".hashCode(), zzbf), new zzaw("com.google.android.recaptcha.internal.zzfj".hashCode(), zzfj), new zzaw("com.google.android.recaptcha.internal.zzaq".hashCode(), zzbm), new zzaw("com.google.android.recaptcha.internal.zzey".hashCode(), new zzfa()), new zzaw("com.google.android.recaptcha.internal.zzff".hashCode(), new zzff())};
        for (int i2 = 0; i2 < 13; i2++) {
            zzaw zzaw = zzawArr[i2];
            if (!zzav.zzc.containsKey(Integer.valueOf(zzaw.zza()))) {
                zzav.zzc.put(Integer.valueOf(zzaw.zza()), zzaw);
            }
        }
    }

    public static final /* synthetic */ zzdc zza(zzcv zzcv, String str) {
        zzdc zzdc = zzcv.zzc;
        if (zzdc == null) {
            return null;
        }
        if (Intrinsics.areEqual((Object) zzdc.zzd(), (Object) str)) {
            return zzdc;
        }
        throw new zzbd(zzbb.zzd, zzba.zzam, (String) null);
    }

    public static final /* synthetic */ void zzc(zzcv zzcv, long j) {
        if (j < 5000) {
            throw new zzbd(zzbb.zzj, zzba.zzI, (String) null);
        } else if (ContextCompat.checkSelfPermission(zzcv.zza, "android.permission.INTERNET") != 0) {
            throw new zzbd(zzbb.zzc, zzba.zzao, (String) null);
        }
    }

    public static final /* synthetic */ zzcn zze(zzcv zzcv, String str, zzbi zzbi, zzch zzch, zzek zzek) {
        zzdt zzdt = new zzdt(str, zzbi, zzek, zzcv.zze);
        if (Intrinsics.areEqual((Object) zzch, (Object) zzch.zza)) {
            return new zzef(zzdt);
        }
        return new zzec(zzdt, zzbi, zzek, new zzbo());
    }

    public static /* synthetic */ Object zzh(zzcv zzcv, String str, long j, zzcn zzcn, zzbi zzbi, zzch zzch, Continuation continuation, int i, Object obj) throws TimeoutCancellationException, ApiException, RecaptchaException {
        if ((i & 8) != 0) {
            zzbi = zzcv.zzf;
        }
        zzbi zzbi2 = zzbi;
        if ((i & 16) != 0) {
            zzch = zzch.zza;
        }
        zzch zzch2 = zzch;
        if ((i & 2) != 0) {
            j = 10000;
        }
        return zzcv.zzg(str, j, (zzcn) null, zzbi2, zzch2, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzj(java.lang.String r6, int r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzcu
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.google.android.recaptcha.internal.zzcu r0 = (com.google.android.recaptcha.internal.zzcu) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzcu r0 = new com.google.android.recaptcha.internal.zzcu
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            com.google.android.recaptcha.internal.zzen r6 = r0.zzd
            r7 = r6
            com.google.android.recaptcha.internal.zzen r7 = (com.google.android.recaptcha.internal.zzen) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            goto L_0x0053
        L_0x002e:
            r7 = move-exception
            goto L_0x005c
        L_0x0030:
            r7 = move-exception
            goto L_0x0075
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.google.android.recaptcha.internal.zzbi r9 = r5.zzf
            com.google.android.recaptcha.internal.zzek r6 = r5.zzk(r6, r9, r7)
            r7 = 6
            com.google.android.recaptcha.internal.zzen r7 = r6.zzf(r7)
            r0.zzd = r7     // Catch:{ zzbd -> 0x0071, Exception -> 0x0058 }
            r0.zzc = r3     // Catch:{ zzbd -> 0x0071, Exception -> 0x0058 }
            java.lang.Object r9 = r8.invoke(r6, r0)     // Catch:{ zzbd -> 0x0071, Exception -> 0x0058 }
            if (r9 == r1) goto L_0x0057
            r6 = r7
        L_0x0053:
            r6.zza()     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            return r9
        L_0x0057:
            return r1
        L_0x0058:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x005c:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zza
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            com.google.android.recaptcha.RecaptchaException r6 = r8.zzc()
            throw r6
        L_0x0071:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0075:
            r6.zzb(r7)
            com.google.android.recaptcha.RecaptchaException r6 = r7.zzc()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcv.zzj(java.lang.String, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final zzek zzk(String str, zzbi zzbi, int i) {
        String uuid = UUID.randomUUID().toString();
        int i2 = zzav.zza;
        zzes zzes = new zzes(this.zza, new zzeu(((zzbr) LazyKt.lazy(zzcr.zza).getValue()).zzc()), zzbi.zza());
        String str2 = str;
        zzek zzek = new zzek(str2, this.zzd, uuid, i, this.zza, zzes, (DefaultConstructorMarker) null);
        zzek.zzc(uuid);
        return zzek;
    }

    public final zzbi zzd() {
        return this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzg(java.lang.String r17, long r18, com.google.android.recaptcha.internal.zzcn r20, com.google.android.recaptcha.internal.zzbi r21, com.google.android.recaptcha.internal.zzch r22, kotlin.coroutines.Continuation r23) throws kotlinx.coroutines.TimeoutCancellationException, com.google.android.gms.common.api.ApiException, com.google.android.recaptcha.RecaptchaException {
        /*
            r16 = this;
            r1 = r16
            r0 = r23
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzcs
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.google.android.recaptcha.internal.zzcs r2 = (com.google.android.recaptcha.internal.zzcs) r2
            int r3 = r2.zzg
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.zzg = r3
            goto L_0x001c
        L_0x0017:
            com.google.android.recaptcha.internal.zzcs r2 = new com.google.android.recaptcha.internal.zzcs
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.zze
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.zzg
            r5 = 1
            r6 = 2
            r12 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 == r5) goto L_0x0041
            if (r4 != r6) goto L_0x0039
            java.lang.Object r2 = r2.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0036 }
            goto L_0x00c4
        L_0x0036:
            r0 = move-exception
            goto L_0x00cc
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            long r4 = r2.zzd
            java.lang.Object r7 = r2.zzc
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            com.google.android.recaptcha.internal.zzch r8 = r2.zzi
            r9 = r8
            com.google.android.recaptcha.internal.zzch r9 = (com.google.android.recaptcha.internal.zzch) r9
            com.google.android.recaptcha.internal.zzbi r9 = r2.zzj
            r10 = r9
            com.google.android.recaptcha.internal.zzbi r10 = (com.google.android.recaptcha.internal.zzbi) r10
            java.lang.Object r10 = r2.zzb
            r10 = r12
            com.google.android.recaptcha.internal.zzcn r10 = (com.google.android.recaptcha.internal.zzcn) r10
            java.lang.String r10 = r2.zzh
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r2.zza
            com.google.android.recaptcha.internal.zzcv r11 = (com.google.android.recaptcha.internal.zzcv) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r8
            r13 = r9
            r9 = r10
            r8 = r11
            r10 = r4
            r4 = r7
            goto L_0x0092
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.zzb
            r2.zza = r1
            r4 = r17
            r2.zzh = r4
            r2.zzb = r12
            r7 = r21
            r2.zzj = r7
            r8 = r22
            r2.zzi = r8
            r2.zzc = r0
            r9 = r18
            r2.zzd = r9
            r2.zzg = r5
            java.lang.Object r5 = r0.lock(r12, r2)
            if (r5 == r3) goto L_0x00d0
            r13 = r7
            r14 = r8
            r10 = r9
            r8 = r1
            r9 = r4
            r4 = r0
        L_0x0092:
            com.google.android.recaptcha.internal.zzch r0 = com.google.android.recaptcha.internal.zzch.zza     // Catch:{ all -> 0x00ca }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x009c
            r0 = 3
            goto L_0x00a7
        L_0x009c:
            com.google.android.recaptcha.internal.zzch r0 = com.google.android.recaptcha.internal.zzch.zzb     // Catch:{ all -> 0x00ca }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r0)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x00a6
            r0 = 4
            goto L_0x00a7
        L_0x00a6:
            r0 = r6
        L_0x00a7:
            com.google.android.recaptcha.internal.zzct r7 = new com.google.android.recaptcha.internal.zzct     // Catch:{ all -> 0x00ca }
            r15 = 0
            r7.<init>(r8, r9, r10, r12, r13, r14, r15)     // Catch:{ all -> 0x00ca }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ all -> 0x00ca }
            r2.zza = r4     // Catch:{ all -> 0x00ca }
            r2.zzh = r12     // Catch:{ all -> 0x00ca }
            r2.zzb = r12     // Catch:{ all -> 0x00ca }
            r2.zzj = r12     // Catch:{ all -> 0x00ca }
            r2.zzi = r12     // Catch:{ all -> 0x00ca }
            r2.zzc = r12     // Catch:{ all -> 0x00ca }
            r2.zzg = r6     // Catch:{ all -> 0x00ca }
            java.lang.Object r0 = r8.zzj(r9, r0, r7, r2)     // Catch:{ all -> 0x00ca }
            if (r0 == r3) goto L_0x00d0
            r2 = r4
        L_0x00c4:
            com.google.android.recaptcha.internal.zzdc r0 = (com.google.android.recaptcha.internal.zzdc) r0     // Catch:{ all -> 0x0036 }
            r2.unlock(r12)
            return r0
        L_0x00ca:
            r0 = move-exception
            r2 = r4
        L_0x00cc:
            r2.unlock(r12)
            throw r0
        L_0x00d0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcv.zzg(java.lang.String, long, com.google.android.recaptcha.internal.zzcn, com.google.android.recaptcha.internal.zzbi, com.google.android.recaptcha.internal.zzch, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
