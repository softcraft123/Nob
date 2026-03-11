package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzc {
    private final Map zza = Collections.synchronizedMap(new ArrayMap());
    private int zzb = 0;
    private Bundle zzc;

    zzc() {
    }

    /* access modifiers changed from: package-private */
    public final LifecycleCallback zza(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.zza.get(str));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, LifecycleCallback lifecycleCallback) {
        Map map = this.zza;
        if (!map.containsKey(str)) {
            map.put(str, lifecycleCallback);
            if (this.zzb > 0) {
                new zzg(Looper.getMainLooper()).post(new zzb(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return this.zzb > 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd() {
        return this.zzb >= 2;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Bundle bundle) {
        this.zzb = 1;
        this.zzc = bundle;
        for (Map.Entry entry : this.zza.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        this.zzb = 2;
        for (LifecycleCallback onStart : this.zza.values()) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        this.zzb = 3;
        for (LifecycleCallback onResume : this.zza.values()) {
            onResume.onResume();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i, int i2, Intent intent) {
        for (LifecycleCallback onActivityResult : this.zza.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(Bundle bundle) {
        if (bundle != null) {
            for (Map.Entry entry : this.zza.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj() {
        this.zzb = 4;
        for (LifecycleCallback onStop : this.zza.values()) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzb = 5;
        for (LifecycleCallback onDestroy : this.zza.values()) {
            onDestroy.onDestroy();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzl(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (LifecycleCallback dump : this.zza.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzm() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bundle zzn() {
        return this.zzc;
    }
}
