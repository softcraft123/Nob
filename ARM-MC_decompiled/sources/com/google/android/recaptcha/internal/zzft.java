package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzft implements zzfo {
    private final CoroutineScope zza;
    private final zzgf zzb;
    /* access modifiers changed from: private */
    public final zzhx zzc;
    private final Map zzd;

    public zzft(CoroutineScope coroutineScope, zzgf zzgf, zzhx zzhx, Map map) {
        this.zza = coroutineScope;
        this.zzb = zzgf;
        this.zzc = zzhx;
        this.zzd = map;
    }

    public static final /* synthetic */ void zzf(zzft zzft, zzuf zzuf, zzgd zzgd) {
        zzjh zzb2 = zzjh.zzb();
        int zza2 = zzgd.zza();
        zzgx zzgx = (zzgx) zzft.zzd.get(Integer.valueOf(zzuf.zzf()));
        if (zzgx != null) {
            int zzg = zzuf.zzg();
            zzue[] zzueArr = (zzue[]) zzuf.zzj().toArray(new zzue[0]);
            zzgx.zza(zzg, zzgd, (zzue[]) Arrays.copyOf(zzueArr, zzueArr.length));
            if (zza2 == zzgd.zza()) {
                zzgd.zzg(zzgd.zza() + 1);
            }
            zzb2.zzf();
            long zza3 = zzb2.zza(TimeUnit.MICROSECONDS);
            int i = zzbk.zza;
            int zzk = zzuf.zzk();
            if (zzk != 1) {
                zzbk.zza(zzk - 2, zza3);
                return;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        throw new zzce(5, 2, (Throwable) null);
    }

    /* access modifiers changed from: private */
    public final Object zzg(List list, zzgd zzgd, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new zzfq(zzgd, list, this, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object zzh(Exception exc, zzgd zzgd, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new zzfr(exc, zzgd, this, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final void zza(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zza, (CoroutineContext) null, (CoroutineStart) null, new zzfs(new zzgd(this.zzb), this, str, (Continuation) null), 3, (Object) null);
    }
}
