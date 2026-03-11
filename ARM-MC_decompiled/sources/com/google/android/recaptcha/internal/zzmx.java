package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzmx;
import com.google.android.recaptcha.internal.zznd;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public class zzmx<MessageType extends zznd<MessageType, BuilderType>, BuilderType extends zzmx<MessageType, BuilderType>> extends zzkn<MessageType, BuilderType> {
    protected zznd zza;
    private final zznd zzb;

    protected zzmx(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzL()) {
            this.zza = messagetype.zzv();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zze(Object obj, Object obj2) {
        zzos.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzkn zzb(zzko zzko) {
        zzh((zznd) zzko);
        return this;
    }

    /* renamed from: zzg */
    public final zzmx zza() {
        zzmx zzmx = (zzmx) this.zzb.zzh(5, (Object) null, (Object) null);
        zzmx.zza = zzl();
        return zzmx;
    }

    public final zzmx zzh(zznd zznd) {
        if (!this.zzb.equals(zznd)) {
            if (!this.zza.zzL()) {
                zzo();
            }
            zze(this.zza, zznd);
        }
        return this;
    }

    /* renamed from: zzi */
    public final MessageType zzk() {
        MessageType zzj = zzl();
        if (zznd.zzK(zzj, true)) {
            return zzj;
        }
        throw new zzpk(zzj);
    }

    /* renamed from: zzj */
    public MessageType zzl() {
        if (!this.zza.zzL()) {
            return this.zza;
        }
        this.zza.zzG();
        return this.zza;
    }

    public final /* synthetic */ zzoi zzm() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzn() {
        if (!this.zza.zzL()) {
            zzo();
        }
    }

    /* access modifiers changed from: protected */
    public void zzo() {
        zznd zzv = this.zzb.zzv();
        zze(zzv, this.zza);
        this.zza = zzv;
    }

    public final boolean zzp() {
        return zznd.zzK(this.zza, false);
    }
}
