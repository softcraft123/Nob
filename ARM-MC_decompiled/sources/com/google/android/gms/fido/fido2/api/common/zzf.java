package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzgx;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    private final zzgx zza;
    private final zzgx zzb;

    public zzf(zzgx zzgx, zzgx zzgx2) {
        this.zza = zzgx;
        this.zzb = zzgx2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzf = (zzf) obj;
        if (!Objects.equal(this.zza, zzf.zza) || !Objects.equal(this.zzb, zzf.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte[] bArr;
        zzgx zzgx = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        byte[] bArr2 = null;
        if (zzgx == null) {
            bArr = null;
        } else {
            bArr = zzgx.zzm();
        }
        SafeParcelWriter.writeByteArray(parcel, 1, bArr, false);
        zzgx zzgx2 = this.zzb;
        if (zzgx2 != null) {
            bArr2 = zzgx2.zzm();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
