package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzg;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzq extends GmsClientSupervisor {
    private final HashMap zzb = new HashMap();
    private final Context zzc;
    private volatile Handler zzd;
    private final zzp zze;
    private final ConnectionTracker zzf;
    private final long zzg;
    private final long zzh;
    private volatile Executor zzi;

    zzq(Context context, Looper looper, Executor executor) {
        zzp zzp = new zzp(this, (byte[]) null);
        this.zze = zzp;
        this.zzc = context.getApplicationContext();
        this.zzd = new zzg(looper, zzp);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000;
        this.zzh = 300000;
        this.zzi = executor;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.common.ConnectionResult zza(com.google.android.gms.common.internal.zzn r6, android.content.ServiceConnection r7, java.lang.String r8, java.util.concurrent.Executor r9) {
        /*
            r5 = this;
            java.lang.String r0 = "ServiceConnection must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7, r0)
            java.util.HashMap r0 = r5.zzb
            java.lang.String r1 = "Trying to bind a GmsServiceConnection that was already connected before.  config="
            monitor-enter(r0)
            java.lang.Object r2 = r0.get(r6)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.common.internal.zzo r2 = (com.google.android.gms.common.internal.zzo) r2     // Catch:{ all -> 0x0086 }
            if (r9 != 0) goto L_0x0014
            java.util.concurrent.Executor r9 = r5.zzi     // Catch:{ all -> 0x0086 }
        L_0x0014:
            if (r2 != 0) goto L_0x0026
            com.google.android.gms.common.internal.zzo r2 = new com.google.android.gms.common.internal.zzo     // Catch:{ all -> 0x0086 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0086 }
            r2.zzb(r7, r7, r8)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.common.ConnectionResult r7 = r2.zzj(r8, r9)     // Catch:{ all -> 0x0086 }
            r0.put(r6, r2)     // Catch:{ all -> 0x0086 }
            goto L_0x0053
        L_0x0026:
            android.os.Handler r3 = r5.zzd     // Catch:{ all -> 0x0086 }
            r4 = 0
            r3.removeMessages(r4, r6)     // Catch:{ all -> 0x0086 }
            boolean r3 = r2.zzf(r7)     // Catch:{ all -> 0x0086 }
            if (r3 != 0) goto L_0x0067
            r2.zzb(r7, r7, r8)     // Catch:{ all -> 0x0086 }
            int r6 = r2.zze()     // Catch:{ all -> 0x0086 }
            r1 = 1
            r3 = 0
            if (r6 == r1) goto L_0x0047
            r7 = 2
            if (r6 == r7) goto L_0x0042
        L_0x0040:
            r7 = r3
            goto L_0x0053
        L_0x0042:
            com.google.android.gms.common.ConnectionResult r7 = r2.zzj(r8, r9)     // Catch:{ all -> 0x0086 }
            goto L_0x0053
        L_0x0047:
            android.content.ComponentName r6 = r2.zzi()     // Catch:{ all -> 0x0086 }
            android.os.IBinder r8 = r2.zzh()     // Catch:{ all -> 0x0086 }
            r7.onServiceConnected(r6, r8)     // Catch:{ all -> 0x0086 }
            goto L_0x0040
        L_0x0053:
            boolean r6 = r2.zzd()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x005d
            com.google.android.gms.common.ConnectionResult r6 = com.google.android.gms.common.ConnectionResult.RESULT_SUCCESS     // Catch:{ all -> 0x0086 }
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            return r6
        L_0x005d:
            if (r7 != 0) goto L_0x0065
            com.google.android.gms.common.ConnectionResult r7 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x0086 }
            r6 = -1
            r7.<init>(r6)     // Catch:{ all -> 0x0086 }
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            return r7
        L_0x0067:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0086 }
            int r8 = r6.length()     // Catch:{ all -> 0x0086 }
            int r8 = r8 + 81
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r9.<init>(r8)     // Catch:{ all -> 0x0086 }
            r9.append(r1)     // Catch:{ all -> 0x0086 }
            r9.append(r6)     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0086 }
            r7.<init>(r6)     // Catch:{ all -> 0x0086 }
            throw r7     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzq.zza(com.google.android.gms.common.internal.zzn, android.content.ServiceConnection, java.lang.String, java.util.concurrent.Executor):com.google.android.gms.common.ConnectionResult");
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzn zzn, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        HashMap hashMap = this.zzb;
        synchronized (hashMap) {
            zzo zzo = (zzo) hashMap.get(zzn);
            if (zzo == null) {
                String obj = zzn.toString();
                StringBuilder sb = new StringBuilder(obj.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString());
            } else if (zzo.zzf(serviceConnection)) {
                zzo.zzc(serviceConnection, str);
                if (zzo.zzg()) {
                    this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzn), this.zzg);
                }
            } else {
                String obj2 = zzn.toString();
                StringBuilder sb2 = new StringBuilder(obj2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(obj2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new zzg(looper, this.zze);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ HashMap zzf() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Context zzg() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Handler zzh() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ConnectionTracker zzi() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ long zzj() {
        return this.zzh;
    }
}
