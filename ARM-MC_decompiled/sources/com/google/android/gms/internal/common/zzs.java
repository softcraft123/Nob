package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzs extends zzv {
    final /* synthetic */ zzp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzw zzw, CharSequence charSequence, zzp zzp) {
        super(zzw, charSequence);
        this.zza = zzp;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzr.zzc(i, length, "index");
        while (i < length) {
            if (this.zza.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        return i + 1;
    }
}
