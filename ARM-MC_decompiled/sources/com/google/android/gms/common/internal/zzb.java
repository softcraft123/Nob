package com.google.android.gms.common.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.common.zzg;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzb extends zzg {
    final /* synthetic */ BaseGmsClient zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        Objects.requireNonNull(baseGmsClient);
        this.zza = baseGmsClient;
    }

    private static final void zza(Message message) {
        zzc zzc = (zzc) message.obj;
        if (zzc != null) {
            zzc.zze();
        }
    }

    private static final boolean zzb(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.app.PendingIntent} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r9) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.BaseGmsClient r0 = r8.zza
            java.util.concurrent.atomic.AtomicInteger r1 = r0.zzd
            int r1 = r1.get()
            int r2 = r9.arg1
            if (r1 == r2) goto L_0x0016
            boolean r0 = zzb(r9)
            if (r0 == 0) goto L_0x0015
            zza(r9)
        L_0x0015:
            return
        L_0x0016:
            int r1 = r9.what
            r2 = 4
            r3 = 1
            r4 = 5
            if (r1 == r3) goto L_0x0030
            int r1 = r9.what
            r5 = 7
            if (r1 == r5) goto L_0x0030
            int r1 = r9.what
            if (r1 != r2) goto L_0x002c
            boolean r1 = r0.enableLocalFallback()
            if (r1 == 0) goto L_0x0030
        L_0x002c:
            int r1 = r9.what
            if (r1 != r4) goto L_0x0036
        L_0x0030:
            boolean r1 = r0.isConnecting()
            if (r1 == 0) goto L_0x0114
        L_0x0036:
            int r1 = r9.what
            r5 = 8
            r6 = 3
            r7 = 0
            if (r1 != r2) goto L_0x0072
            com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
            int r9 = r9.arg2
            r1.<init>(r9)
            r0.zzn(r1)
            boolean r9 = r0.zzg()
            if (r9 == 0) goto L_0x0059
            boolean r9 = r0.zzo()
            if (r9 == 0) goto L_0x0055
            goto L_0x0059
        L_0x0055:
            r0.zzd(r6, r7)
            return
        L_0x0059:
            com.google.android.gms.common.ConnectionResult r9 = r0.zzm()
            if (r9 == 0) goto L_0x0064
            com.google.android.gms.common.ConnectionResult r9 = r0.zzm()
            goto L_0x0069
        L_0x0064:
            com.google.android.gms.common.ConnectionResult r9 = new com.google.android.gms.common.ConnectionResult
            r9.<init>(r5)
        L_0x0069:
            com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks r1 = r0.zzc
            r1.onReportServiceBinding(r9)
            r0.onConnectionFailed(r9)
            return
        L_0x0072:
            int r1 = r9.what
            if (r1 != r4) goto L_0x008f
            com.google.android.gms.common.ConnectionResult r9 = r0.zzm()
            if (r9 == 0) goto L_0x0081
            com.google.android.gms.common.ConnectionResult r9 = r0.zzm()
            goto L_0x0086
        L_0x0081:
            com.google.android.gms.common.ConnectionResult r9 = new com.google.android.gms.common.ConnectionResult
            r9.<init>(r5)
        L_0x0086:
            com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks r1 = r0.zzc
            r1.onReportServiceBinding(r9)
            r0.onConnectionFailed(r9)
            return
        L_0x008f:
            int r1 = r9.what
            if (r1 != r6) goto L_0x00ae
            java.lang.Object r1 = r9.obj
            boolean r1 = r1 instanceof android.app.PendingIntent
            if (r1 == 0) goto L_0x009e
            java.lang.Object r1 = r9.obj
            r7 = r1
            android.app.PendingIntent r7 = (android.app.PendingIntent) r7
        L_0x009e:
            com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
            int r9 = r9.arg2
            r1.<init>(r9, r7)
            com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks r9 = r0.zzc
            r9.onReportServiceBinding(r1)
            r0.onConnectionFailed(r1)
            return
        L_0x00ae:
            int r1 = r9.what
            r2 = 6
            if (r1 != r2) goto L_0x00ce
            r0.zzd(r4, r7)
            com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks r1 = r0.zzk()
            if (r1 == 0) goto L_0x00c5
            int r1 = r9.arg2
            com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks r2 = r0.zzk()
            r2.onConnectionSuspended(r1)
        L_0x00c5:
            int r9 = r9.arg2
            r0.onConnectionSuspended(r9)
            r0.zze(r4, r3, r7)
            return
        L_0x00ce:
            int r1 = r9.what
            r2 = 2
            if (r1 != r2) goto L_0x00de
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x00da
            goto L_0x00de
        L_0x00da:
            zza(r9)
            return
        L_0x00de:
            boolean r0 = zzb(r9)
            if (r0 == 0) goto L_0x00ec
            java.lang.Object r9 = r9.obj
            com.google.android.gms.common.internal.zzc r9 = (com.google.android.gms.common.internal.zzc) r9
            r9.zzd()
            return
        L_0x00ec:
            int r9 = r9.what
            java.lang.String r0 = java.lang.String.valueOf(r9)
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 34
            r1.<init>(r0)
            java.lang.String r0 = "Don't know how to handle message: "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            java.lang.String r1 = "GmsClient"
            android.util.Log.wtf(r1, r9, r0)
            return
        L_0x0114:
            zza(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzb.handleMessage(android.os.Message):void");
    }
}
