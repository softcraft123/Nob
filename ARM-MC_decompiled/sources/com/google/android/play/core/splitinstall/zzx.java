package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.splitinstall.internal.zzs;
import com.google.android.play.core.splitinstall.internal.zzu;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzx extends zzs {
    private static zzx zzc;
    private final Handler zzd = new Handler(Looper.getMainLooper());
    private final zzg zze;
    private final Set zzf = new LinkedHashSet();

    public zzx(Context context, zzg zzg) {
        super(new zzu("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.zze = zzg;
    }

    public static synchronized zzx zzg(Context context) {
        zzx zzx;
        synchronized (zzx.class) {
            if (zzc == null) {
                zzc = new zzx(context, zzo.INSTANCE);
            }
            zzx = zzc;
        }
        return zzx;
    }

    /* access modifiers changed from: protected */
    public final void zza(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState zzd2 = SplitInstallSessionState.zzd(bundleExtra);
            this.zza.zza("ListenerRegistryBroadcastReceiver.onReceive: %s", zzd2);
            zzh zza = this.zze.zza();
            if (zzd2.status() != 3 || zza == null) {
                zzk(zzd2);
            } else {
                zza.zzd(zzd2.zzc(), new zzv(this, zzd2, intent, context));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzi(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzf.add(splitInstallStateUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzj(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.zzf.remove(splitInstallStateUpdatedListener);
    }

    public final synchronized void zzk(SplitInstallSessionState splitInstallSessionState) {
        Iterator it = new LinkedHashSet(this.zzf).iterator();
        while (it.hasNext()) {
            ((SplitInstallStateUpdatedListener) it.next()).onStateUpdate(splitInstallSessionState);
        }
        super.zze(splitInstallSessionState);
    }
}
