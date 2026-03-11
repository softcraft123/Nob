package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public abstract class zzz extends zzb implements IGmsCallbacks {
    public zzz() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzc.zzf(parcel);
            onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zzb(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            zzc.zzf(parcel);
            zzb(parcel.readInt(), (Bundle) zzc.zzb(parcel, Bundle.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            zzc.zzf(parcel);
            zzc(parcel.readInt(), parcel.readStrongBinder(), (zzj) zzc.zzb(parcel, zzj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
