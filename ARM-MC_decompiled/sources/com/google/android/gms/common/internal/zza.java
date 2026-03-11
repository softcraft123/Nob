package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
abstract class zza extends zzc {
    public final int zza;
    public final Bundle zzb;
    final /* synthetic */ BaseGmsClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zza(BaseGmsClient baseGmsClient, int i, Bundle bundle) {
        super(baseGmsClient, true);
        Objects.requireNonNull(baseGmsClient);
        this.zzc = baseGmsClient;
        this.zza = i;
        this.zzb = bundle;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza();

    /* access modifiers changed from: protected */
    public abstract void zzb(ConnectionResult connectionResult);

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzc(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            int r4 = r3.zza
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x001e
            boolean r4 = r3.zza()
            if (r4 != 0) goto L_0x001d
            com.google.android.gms.common.internal.BaseGmsClient r4 = r3.zzc
            r4.zzd(r0, r1)
            com.google.android.gms.common.ConnectionResult r4 = new com.google.android.gms.common.ConnectionResult
            r0 = 8
            r4.<init>(r0, r1)
            r3.zzb(r4)
        L_0x001d:
            return
        L_0x001e:
            com.google.android.gms.common.internal.BaseGmsClient r2 = r3.zzc
            r2.zzd(r0, r1)
            android.os.Bundle r0 = r3.zzb
            if (r0 == 0) goto L_0x0030
            java.lang.String r1 = "pendingIntent"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            r1 = r0
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1
        L_0x0030:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r0.<init>(r4, r1)
            r3.zzb(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zza.zzc(java.lang.Object):void");
    }
}
