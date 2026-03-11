package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzgx;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    private final long zza;
    private final zzgx zzb;
    private final zzgx zzc;
    private final zzgx zzd;

    zzq(long j, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = (byte[]) Preconditions.checkNotNull(bArr);
        zzgx zzgx = zzgx.zzb;
        zzgx zzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) Preconditions.checkNotNull(bArr2);
        zzgx zzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) Preconditions.checkNotNull(bArr3);
        zzgx zzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.zza = j;
        this.zzb = (zzgx) Preconditions.checkNotNull(zzl);
        this.zzc = (zzgx) Preconditions.checkNotNull(zzl2);
        this.zzd = (zzgx) Preconditions.checkNotNull(zzl3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzq = (zzq) obj;
        if (this.zza != zzq.zza || !Objects.equal(this.zzb, zzq.zzb) || !Objects.equal(this.zzc, zzq.zzc) || !Objects.equal(this.zzd, zzq.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        long j = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb.zzm(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc.zzm(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd.zzm(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
