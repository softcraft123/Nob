package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzes implements zzeo {
    /* access modifiers changed from: private */
    public static Timer zza;
    private final Context zzb;
    private final zzet zzc;
    /* access modifiers changed from: private */
    public final CoroutineScope zzd;
    /* access modifiers changed from: private */
    public final zzei zze;

    public zzes(Context context, zzet zzet, CoroutineScope coroutineScope) {
        this.zzb = context;
        this.zzc = zzet;
        this.zzd = coroutineScope;
        zzeg zzeg = zzei.zza;
        zzei zzei = null;
        try {
            zzei zzc2 = zzei.zzd;
            zzc2 = zzc2 == null ? new zzei(context, (DefaultConstructorMarker) null) : zzc2;
            zzei.zzd = zzc2;
            zzei = zzc2;
        } catch (Exception unused) {
        }
        this.zze = zzei;
        zzh();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        zzei zzei;
        zzei zzei2 = this.zze;
        if (zzei2 != null) {
            for (List<zzej> it : CollectionsKt.windowed(zzei2.zzd(), 20, 20, true)) {
                zzrd zzi = zzrf.zzi();
                List arrayList = new ArrayList();
                for (zzej zzej : it) {
                    try {
                        zztx zzk = zztx.zzk(zzkh.zzg().zzj(zzej.zzc()));
                        int zzN = zzk.zzN();
                        int i = zzN - 1;
                        if (zzN != 0) {
                            if (i == 0) {
                                zzi.zzq(zzk.zzf());
                            } else if (i == 1) {
                                zzi.zzr(zzk.zzg());
                            } else if (i == 2) {
                                Unit unit = Unit.INSTANCE;
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            arrayList.add(zzej);
                        } else {
                            throw null;
                        }
                    } catch (Exception unused) {
                        zzei zzei3 = this.zze;
                        if (zzei3 != null) {
                            zzei3.zzf(zzej);
                        }
                    }
                }
                if (zzi.zze() + zzi.zzf() != 0) {
                    if (this.zzc.zza(((zzrf) zzi.zzk()).zzd()) && (zzei = this.zze) != null) {
                        zzei.zza(arrayList);
                    }
                }
            }
        }
    }

    private final void zzh() {
        if (zza == null) {
            Timer timer = new Timer();
            zza = timer;
            timer.schedule(new zzep(this), 120000, 120000);
        }
    }

    public final void zza(zztx zztx) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzer(this, zztx, (Continuation) null), 3, (Object) null);
        zzh();
    }
}
