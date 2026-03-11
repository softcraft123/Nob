package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzo implements ServiceConnection, zzr {
    final /* synthetic */ zzq zza;
    private final Map zzb = new HashMap();
    private int zzc = 2;
    private boolean zzd;
    private IBinder zze;
    private final zzn zzf;
    private ComponentName zzg;

    public zzo(zzq zzq, zzn zzn) {
        Objects.requireNonNull(zzq);
        this.zza = zzq;
        this.zzf = zzn;
    }

    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzq zzq = this.zza;
        synchronized (zzq.zzf()) {
            zzq.zzh().removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            for (ServiceConnection onServiceConnected : this.zzb.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzq zzq = this.zza;
        synchronized (zzq.zzf()) {
            zzq.zzh().removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzb.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final void zza(String str) {
        zzn zzn = this.zzf;
        zzq zzq = this.zza;
        zzq.zzh().removeMessages(1, zzn);
        zzq.zzi().unbindService(zzq.zzg(), this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final void zzb(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zzc(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zzc;
    }

    public final boolean zzf(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzg() {
        return this.zzb.isEmpty();
    }

    public final IBinder zzh() {
        return this.zze;
    }

    public final ComponentName zzi() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:12|13|14|15|16|17|18|19|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.common.ConnectionResult zzj(java.lang.String r11, java.util.concurrent.Executor r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.zzq r0 = r10.zza     // Catch:{ zzaf -> 0x0068 }
            android.content.Context r0 = r0.zzg()     // Catch:{ zzaf -> 0x0068 }
            com.google.android.gms.common.internal.zzn r1 = r10.zzf     // Catch:{ zzaf -> 0x0068 }
            android.content.Intent r5 = com.google.android.gms.common.internal.zzah.zza(r0, r1)     // Catch:{ zzaf -> 0x0068 }
            r0 = 3
            r10.zzc = r0
            android.os.StrictMode$VmPolicy r1 = com.google.android.gms.common.util.zzd.zza()
            com.google.android.gms.common.internal.zzq r0 = r10.zza     // Catch:{ all -> 0x0061 }
            com.google.android.gms.common.stats.ConnectionTracker r2 = r0.zzi()     // Catch:{ all -> 0x0061 }
            android.content.Context r3 = r0.zzg()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.common.internal.zzn r9 = r10.zzf     // Catch:{ all -> 0x0061 }
            r7 = 4225(0x1081, float:5.92E-42)
            r6 = r10
            r4 = r11
            r8 = r12
            boolean r11 = r2.zza(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005f }
            r6.zzd = r11     // Catch:{ all -> 0x005f }
            if (r11 == 0) goto L_0x0046
            android.os.Handler r11 = r0.zzh()     // Catch:{ all -> 0x005f }
            r12 = 1
            android.os.Message r11 = r11.obtainMessage(r12, r9)     // Catch:{ all -> 0x005f }
            android.os.Handler r12 = r0.zzh()     // Catch:{ all -> 0x005f }
            long r2 = r0.zzj()     // Catch:{ all -> 0x005f }
            r12.sendMessageDelayed(r11, r2)     // Catch:{ all -> 0x005f }
            com.google.android.gms.common.ConnectionResult r11 = com.google.android.gms.common.ConnectionResult.RESULT_SUCCESS     // Catch:{ all -> 0x005f }
            android.os.StrictMode.setVmPolicy(r1)
            return r11
        L_0x0046:
            r11 = 2
            r6.zzc = r11     // Catch:{ all -> 0x005f }
            com.google.android.gms.common.stats.ConnectionTracker r11 = r0.zzi()     // Catch:{ IllegalArgumentException -> 0x0054 }
            android.content.Context r12 = r0.zzg()     // Catch:{ IllegalArgumentException -> 0x0054 }
            r11.unbindService(r12, r10)     // Catch:{ IllegalArgumentException -> 0x0054 }
        L_0x0054:
            com.google.android.gms.common.ConnectionResult r11 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x005f }
            r12 = 16
            r11.<init>(r12)     // Catch:{ all -> 0x005f }
            android.os.StrictMode.setVmPolicy(r1)
            goto L_0x006d
        L_0x005f:
            r0 = move-exception
            goto L_0x0063
        L_0x0061:
            r0 = move-exception
            r6 = r10
        L_0x0063:
            r11 = r0
            android.os.StrictMode.setVmPolicy(r1)
            throw r11
        L_0x0068:
            r0 = move-exception
            r6 = r10
            r11 = r0
            com.google.android.gms.common.ConnectionResult r11 = r11.zza
        L_0x006d:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzo.zzj(java.lang.String, java.util.concurrent.Executor):com.google.android.gms.common.ConnectionResult");
    }
}
