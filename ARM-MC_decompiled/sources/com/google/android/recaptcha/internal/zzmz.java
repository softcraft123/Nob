package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public class zzmz extends zzmx implements zzoj {
    protected zzmz(zzna zzna) {
        super(zzna);
    }

    /* renamed from: zze */
    public final zzna zzl() {
        if (!((zzna) this.zza).zzL()) {
            return (zzna) this.zza;
        }
        ((zzna) this.zza).zzb.zzg();
        return (zzna) super.zzl();
    }

    /* access modifiers changed from: protected */
    public final void zzo() {
        super.zzo();
        if (((zzna) this.zza).zzb != zzmt.zzd()) {
            zzna zzna = (zzna) this.zza;
            zzna.zzb = zzna.zzb.clone();
        }
    }
}
