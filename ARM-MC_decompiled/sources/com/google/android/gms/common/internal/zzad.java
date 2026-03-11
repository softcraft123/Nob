package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzr;
import com.google.android.gms.common.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public interface zzad extends IInterface {
    boolean zze(zzt zzt, IObjectWrapper iObjectWrapper) throws RemoteException;

    zzr zzf(zzp zzp) throws RemoteException;

    boolean zzg() throws RemoteException;

    zzr zzh(zzp zzp) throws RemoteException;

    boolean zzi() throws RemoteException;
}
