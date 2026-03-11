package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.zze;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.play:review@@2.0.2 */
public final class zzt {
    private static final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzi zzc;
    private final String zzd;
    /* access modifiers changed from: private */
    public final List zze = new ArrayList();
    private final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Object zzg = new Object();
    /* access modifiers changed from: private */
    public boolean zzh;
    private final Intent zzi;
    private final WeakReference zzj;
    private final IBinder.DeathRecipient zzk = new zzk(this);
    /* access modifiers changed from: private */
    public final AtomicInteger zzl = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public ServiceConnection zzm;
    /* access modifiers changed from: private */
    public IInterface zzn;

    public zzt(Context context, zzi zzi2, String str, Intent intent, zze zze2, zzo zzo) {
        this.zzb = context;
        this.zzc = zzi2;
        this.zzd = "com.google.android.finsky.inappreviewservice.InAppReviewService";
        this.zzi = intent;
        this.zzj = new WeakReference((Object) null);
    }

    public static /* synthetic */ void zzj(zzt zzt) {
        zzt.zzc.zzc("reportBinderDeath", new Object[0]);
        zzo zzo = (zzo) zzt.zzj.get();
        if (zzo != null) {
            zzt.zzc.zzc("calling onBinderDied", new Object[0]);
            zzo.zza();
        } else {
            zzt.zzc.zzc("%s : Binder has died.", zzt.zzd);
            for (zzj zzc2 : zzt.zze) {
                zzc2.zzc(zzt.zzv());
            }
            zzt.zze.clear();
        }
        synchronized (zzt.zzg) {
            zzt.zzw();
        }
    }

    static /* bridge */ /* synthetic */ void zzn(zzt zzt, TaskCompletionSource taskCompletionSource) {
        zzt.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new zzl(zzt, taskCompletionSource));
    }

    static /* bridge */ /* synthetic */ void zzq(zzt zzt) {
        zzt.zzc.zzc("linkToDeath", new Object[0]);
        try {
            zzt.zzn.asBinder().linkToDeath(zzt.zzk, 0);
        } catch (RemoteException e) {
            zzt.zzc.zzb(e, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void zzr(zzt zzt) {
        zzt.zzc.zzc("unlinkToDeath", new Object[0]);
        zzt.zzn.asBinder().unlinkToDeath(zzt.zzk, 0);
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void zzw() {
        for (TaskCompletionSource trySetException : this.zzf) {
            trySetException.trySetException(zzv());
        }
        this.zzf.clear();
    }

    public final Handler zzc() {
        Handler handler;
        Map map = zza;
        synchronized (map) {
            if (!map.containsKey(this.zzd)) {
                HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                handlerThread.start();
                map.put(this.zzd, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.zzd);
        }
        return handler;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzs(zzj zzj2, TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzm(this, zzj2.zzb(), taskCompletionSource, zzj2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    public final void zzu(TaskCompletionSource taskCompletionSource) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
        zzc().post(new zzn(this));
    }

    static /* bridge */ /* synthetic */ void zzp(zzt zzt, zzj zzj2) {
        if (zzt.zzn == null && !zzt.zzh) {
            zzt.zzc.zzc("Initiate binding to the service.", new Object[0]);
            zzt.zze.add(zzj2);
            zzr zzr = new zzr(zzt, (zzs) null);
            zzt.zzm = zzr;
            zzt.zzh = true;
            if (!zzt.zzb.bindService(zzt.zzi, zzr, 1)) {
                zzt.zzc.zzc("Failed to bind to the service.", new Object[0]);
                zzt.zzh = false;
                for (zzj zzc2 : zzt.zze) {
                    zzc2.zzc(new zzu());
                }
                zzt.zze.clear();
            }
        } else if (zzt.zzh) {
            zzt.zzc.zzc("Waiting to bind to the service.", new Object[0]);
            zzt.zze.add(zzj2);
        } else {
            zzj2.run();
        }
    }
}
