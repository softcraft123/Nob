package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public abstract class zzs {
    /* access modifiers changed from: protected */
    public final zzu zza;
    protected final Set zzb = new HashSet();
    private final IntentFilter zzc;
    private final Context zzd;
    private zzr zze = null;
    private volatile boolean zzf = false;

    protected zzs(zzu zzu, IntentFilter intentFilter, Context context) {
        this.zza = zzu;
        this.zzc = intentFilter;
        this.zzd = zzbr.zza(context);
    }

    private final void zzf() {
        zzr zzr;
        if ((this.zzf || !this.zzb.isEmpty()) && this.zze == null) {
            this.zze = new zzr(this, (zzq) null);
            if (Build.VERSION.SDK_INT >= 33) {
                this.zzd.registerReceiver(this.zze, this.zzc, 2);
            } else {
                this.zzd.registerReceiver(this.zze, this.zzc);
            }
        }
        if (!this.zzf && this.zzb.isEmpty() && (zzr = this.zze) != null) {
            this.zzd.unregisterReceiver(zzr);
            this.zze = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, Intent intent);

    public final synchronized void zzb(StateUpdatedListener stateUpdatedListener) {
        this.zza.zzd("registerListener", new Object[0]);
        zzbv.zza(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.zzb.add(stateUpdatedListener);
        zzf();
    }

    public final synchronized void zzc(boolean z) {
        this.zzf = true;
        zzf();
    }

    public final synchronized void zzd(StateUpdatedListener stateUpdatedListener) {
        this.zza.zzd("unregisterListener", new Object[0]);
        zzbv.zza(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.zzb.remove(stateUpdatedListener);
        zzf();
    }

    public final synchronized void zze(Object obj) {
        Iterator it = new HashSet(this.zzb).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(obj);
        }
    }
}
