package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzr;
import com.google.android.gms.common.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzab extends zza implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean zze(zzt zzt, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzt);
        zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zza2 = zzc.zza(zzB);
        zzB.recycle();
        return zza2;
    }

    public final zzr zzf(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzp);
        Parcel zzB = zzB(6, zza);
        zzr zzr = (zzr) zzc.zzb(zzB, zzr.CREATOR);
        zzB.recycle();
        return zzr;
    }

    public final boolean zzg() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zza = zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }

    public final zzr zzh(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzp);
        Parcel zzB = zzB(8, zza);
        zzr zzr = (zzr) zzc.zzb(zzB, zzr.CREATOR);
        zzB.recycle();
        return zzr;
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzB = zzB(9, zza());
        boolean zza = zzc.zza(zzB);
        zzB.recycle();
        return zza;
    }
}
