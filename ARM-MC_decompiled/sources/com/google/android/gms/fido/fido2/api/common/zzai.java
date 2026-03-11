package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzhp;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    static final zzhp zza = zzhp.zzg(1);
    static final zzhp zzb = zzhp.zzg(2);
    static final zzhp zzc = zzhp.zzg(3);
    static final zzhp zzd = zzhp.zzg(4);
    private final zzgx zze;
    private final zzgx zzf;
    private final zzgx zzg;
    private final int zzh;

    zzai(zzgx zzgx, zzgx zzgx2, zzgx zzgx3, int i) {
        this.zze = zzgx;
        this.zzf = zzgx2;
        this.zzg = zzgx3;
        this.zzh = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzai = (zzai) obj;
        if (!Objects.equal(this.zze, zzai.zze) || !Objects.equal(this.zzf, zzai.zzf) || !Objects.equal(this.zzg, zzai.zzg) || this.zzh != zzai.zzh) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zze, this.zzf, this.zzg, Integer.valueOf(this.zzh));
    }

    public final String toString() {
        String encodeUrlSafeNoPadding = Base64Utils.encodeUrlSafeNoPadding(zza());
        String encodeUrlSafeNoPadding2 = Base64Utils.encodeUrlSafeNoPadding(zzc());
        String encodeUrlSafeNoPadding3 = Base64Utils.encodeUrlSafeNoPadding(zzb());
        return "HmacSecretExtension{coseKeyAgreement=" + encodeUrlSafeNoPadding + ", saltEnc=" + encodeUrlSafeNoPadding2 + ", saltAuth=" + encodeUrlSafeNoPadding3 + ", getPinUvAuthProtocol=" + this.zzh + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, zza(), false);
        SafeParcelWriter.writeByteArray(parcel, 2, zzc(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, zzb(), false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final byte[] zza() {
        zzgx zzgx = this.zze;
        if (zzgx == null) {
            return null;
        }
        return zzgx.zzm();
    }

    public final byte[] zzb() {
        zzgx zzgx = this.zzg;
        if (zzgx == null) {
            return null;
        }
        return zzgx.zzm();
    }

    public final byte[] zzc() {
        zzgx zzgx = this.zzf;
        if (zzgx == null) {
            return null;
        }
        return zzgx.zzm();
    }
}
