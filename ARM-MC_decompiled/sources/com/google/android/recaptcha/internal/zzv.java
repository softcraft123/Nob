package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzv extends zze {
    private final zzek zza;
    /* access modifiers changed from: private */
    public final List zzb;
    /* access modifiers changed from: private */
    public zzle zzc;
    private final Map zzd = new LinkedHashMap();

    public /* synthetic */ zzv(Context context, zzek zzek, zzbi zzbi, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        zzek zza2 = zzek.zza();
        CoroutineScope zzc2 = zzbi.zzc();
        zzek zzek2 = zza2;
        Context context2 = context;
        zzek zzek3 = zzek2;
        zzan zzan = new zzan(context2, zzc2, zzek2, IntegrityManagerFactory.createStandard(context), 28800000);
        zzbs zzbs = new zzbs(GoogleApiAvailabilityLight.getInstance());
        zzbs zzbs2 = zzbs;
        List listOf = CollectionsKt.listOf(new zzab(zzek.zza()), new zzp(zzek.zza()), new zzm(zzek.zza(), context.getContentResolver()), new zzn(zzek.zza()), new zzae(zzek3, context2, zzc2, zzan, zzbs));
        this.zza = zzek;
        this.zzb = listOf;
    }

    /* access modifiers changed from: private */
    public final zzsi zzq(String str) {
        Map map;
        List list = (List) this.zzd.remove(str);
        if (list != null) {
            Iterable<zzaa> iterable = list;
            map = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (zzaa zzaa : iterable) {
                map.put(Integer.valueOf(zzaa.zzb()), zzaa);
            }
        } else {
            map = MapsKt.emptyMap();
        }
        zzsz zzs = zzs(map, str);
        zzsh zzf = zzsi.zzf();
        zzf.zze(str);
        zzsf zzf2 = zzsg.zzf();
        byte[] zzd2 = zzs.zzd();
        zzf2.zze(zzkh.zzh().zzi(zzd2, 0, zzd2.length));
        zzf.zzf(zzf2);
        return (zzsi) zzf.zzk();
    }

    private final zzsx zzr(zzaa zzaa) {
        zzsv zzf = zzsx.zzf();
        zzf.zzq(3);
        zzle zzle = null;
        if (zzaa instanceof zzx) {
            zzti zza2 = ((zzx) zzaa).zza();
            zzle zzle2 = this.zzc;
            if (zzle2 != null) {
                zzle = zzle2;
            }
            byte[] zzd2 = zza2.zzd();
            zzf.zzf(zzcf.zza(zzkh.zzh().zzi(zzd2, 0, zzd2.length), zzle));
        } else if (zzaa instanceof zzw) {
            zzte zza3 = ((zzw) zzaa).zza();
            zzle zzle3 = this.zzc;
            if (zzle3 != null) {
                zzle = zzle3;
            }
            byte[] zzd3 = zza3.zzd();
            zzf.zze(zzcf.zza(zzkh.zzh().zzi(zzd3, 0, zzd3.length), zzle));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return (zzsx) zzf.zzk();
    }

    private final zzsz zzs(Map map, String str) {
        zzsy zzf = zzsz.zzf();
        zzf.zzq(str);
        Collection arrayList = new ArrayList();
        for (Object next : this.zzb) {
            if (((zzy) next).zzf()) {
                arrayList.add(next);
            }
        }
        for (zzy zzy : (List) arrayList) {
            if (!map.containsKey(Integer.valueOf(zzy.zza()))) {
                int zza2 = zzy.zza();
                zztd zzf2 = zzte.zzf();
                zzf2.zzf(zza2);
                zzf2.zzr(13);
                zzf2.zzq(27);
                zzf.zzf(zzr(new zzw(zza2, (zzte) zzf2.zzk())));
            }
        }
        Iterable<zzaa> values = map.values();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (zzaa zzr : values) {
            arrayList2.add(zzr(zzr));
        }
        zzf.zze((List) arrayList2);
        return (zzsz) zzf.zzk();
    }

    /* access modifiers changed from: protected */
    public final zzen zza(String str) {
        zzek zzek = this.zza;
        zzek.zzc(str);
        return zzek.zzf(35);
    }

    /* access modifiers changed from: protected */
    public final zzen zzb() {
        zzek zzek = this.zza;
        zzek.zzc(zzek.zzd());
        return zzek.zzf(34);
    }

    /* access modifiers changed from: protected */
    public final Object zzd(String str, Continuation continuation) {
        return zzq(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzf(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzq
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.recaptcha.internal.zzq r0 = (com.google.android.recaptcha.internal.zzq) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzq r0 = new com.google.android.recaptcha.internal.zzq
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzs r6 = new com.google.android.recaptcha.internal.zzs
            r2 = 0
            r6.<init>(r4, r5, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r0.zzc = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m525unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzv.zzf(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzh(com.google.android.recaptcha.internal.zzsc r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzt
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.recaptcha.internal.zzt r0 = (com.google.android.recaptcha.internal.zzt) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzt r0 = new com.google.android.recaptcha.internal.zzt
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzu r6 = new com.google.android.recaptcha.internal.zzu
            r2 = 0
            r6.<init>(r5, r4, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r0.zzc = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m525unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzv.zzh(com.google.android.recaptcha.internal.zzsc, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void zzk(zzsr zzsr) {
        for (zzy zze : this.zzb) {
            zze.zze(zzsr);
        }
    }

    public final Map zzo() {
        return this.zzd;
    }
}
