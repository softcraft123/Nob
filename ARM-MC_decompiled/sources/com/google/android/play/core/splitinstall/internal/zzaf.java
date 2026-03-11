package com.google.android.play.core.splitinstall.internal;

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
import com.google.android.play.core.splitinstall.zzak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzaf {
    private static final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzu zzc;
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
    private final IBinder.DeathRecipient zzk = new zzx(this);
    /* access modifiers changed from: private */
    public final AtomicInteger zzl = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public ServiceConnection zzm;
    /* access modifiers changed from: private */
    public IInterface zzn;
    private final zzak zzo;

    public zzaf(Context context, zzu zzu, String str, Intent intent, zzak zzak, zzaa zzaa) {
        this.zzb = context;
        this.zzc = zzu;
        this.zzd = "SplitInstallService";
        this.zzi = intent;
        this.zzo = zzak;
        this.zzj = new WeakReference((Object) null);
    }

    public static /* synthetic */ void zzj(zzaf zzaf) {
        zzaf.zzc.zzd("reportBinderDeath", new Object[0]);
        zzaa zzaa = (zzaa) zzaf.zzj.get();
        if (zzaa != null) {
            zzaf.zzc.zzd("calling onBinderDied", new Object[0]);
            zzaa.zza();
        } else {
            zzaf.zzc.zzd("%s : Binder has died.", zzaf.zzd);
            for (zzv zzb2 : zzaf.zze) {
                zzb2.zzb(zzaf.zzv());
            }
            zzaf.zze.clear();
        }
        synchronized (zzaf.zzg) {
            zzaf.zzw();
        }
    }

    static /* bridge */ /* synthetic */ void zzn(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        zzaf.zzf.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new zzw(zzaf, taskCompletionSource));
    }

    static /* bridge */ /* synthetic */ void zzq(zzaf zzaf) {
        zzaf.zzc.zzd("linkToDeath", new Object[0]);
        try {
            zzaf.zzn.asBinder().linkToDeath(zzaf.zzk, 0);
        } catch (RemoteException e) {
            zzaf.zzc.zzc(e, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void zzr(zzaf zzaf) {
        zzaf.zzc.zzd("unlinkToDeath", new Object[0]);
        zzaf.zzn.asBinder().unlinkToDeath(zzaf.zzk, 0);
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

    public final void zzs(zzv zzv, TaskCompletionSource taskCompletionSource) {
        zzc().post(new zzy(this, zzv.zza(), taskCompletionSource, zzv));
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
        zzc().post(new zzz(this));
    }

    private final RemoteException zzv() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    static /* bridge */ /* synthetic */ void zzp(zzaf zzaf, zzv zzv) {
        if (zzaf.zzn == null && !zzaf.zzh) {
            zzaf.zzc.zzd("Initiate binding to the service.", new Object[0]);
            zzaf.zze.add(zzv);
            zzae zzae = new zzae(zzaf, (zzad) null);
            zzaf.zzm = zzae;
            zzaf.zzh = true;
            if (!zzaf.zzb.bindService(zzaf.zzi, zzae, 1)) {
                zzaf.zzc.zzd("Failed to bind to the service.", new Object[0]);
                zzaf.zzh = false;
                for (zzv zzb2 : zzaf.zze) {
                    zzb2.zzb(new zzag());
                }
                zzaf.zze.clear();
            }
        } else if (zzaf.zzh) {
            zzaf.zzc.zzd("Waiting to bind to the service.", new Object[0]);
            zzaf.zze.add(zzv);
        } else {
            zzv.run();
        }
    }
}
