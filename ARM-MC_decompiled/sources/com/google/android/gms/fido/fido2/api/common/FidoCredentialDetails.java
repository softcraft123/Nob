package com.google.android.gms.fido.fido2.api.common;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fido.zzgx;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class FidoCredentialDetails extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new zzy();
    private final String zza;
    private final String zzb;
    private final zzgx zzc;
    private final zzgx zzd;
    private final boolean zze;
    private final boolean zzf;
    private final long zzg;
    private final Account zzh;
    private final boolean zzi;

    public static FidoCredentialDetails deserializeFromBytes(byte[] bArr) {
        return (FidoCredentialDetails) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        if (!Objects.equal(this.zza, fidoCredentialDetails.zza) || !Objects.equal(this.zzb, fidoCredentialDetails.zzb) || !Objects.equal(this.zzc, fidoCredentialDetails.zzc) || !Objects.equal(this.zzd, fidoCredentialDetails.zzd) || this.zze != fidoCredentialDetails.zze || this.zzf != fidoCredentialDetails.zzf || this.zzi != fidoCredentialDetails.zzi || this.zzg != fidoCredentialDetails.zzg || !Objects.equal(this.zzh, fidoCredentialDetails.zzh)) {
            return false;
        }
        return true;
    }

    public byte[] getCredentialId() {
        return this.zzd.zzm();
    }

    public zzgx getCredentialIdAsByteString() {
        return this.zzd;
    }

    public boolean getIsDiscoverable() {
        return this.zze;
    }

    public boolean getIsPaymentCredential() {
        return this.zzf;
    }

    public long getLastUsedTime() {
        return this.zzg;
    }

    public String getUserDisplayName() {
        return this.zzb;
    }

    public byte[] getUserId() {
        zzgx zzgx = this.zzc;
        if (zzgx == null) {
            return null;
        }
        return zzgx.zzm();
    }

    public zzgx getUserIdAsByteString() {
        return this.zzc;
    }

    public String getUserName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Boolean.valueOf(this.zzi), Long.valueOf(this.zzg), this.zzh);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUserName(), false);
        SafeParcelWriter.writeString(parcel, 2, getUserDisplayName(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getUserId(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getCredentialId(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getIsDiscoverable());
        SafeParcelWriter.writeBoolean(parcel, 6, getIsPaymentCredential());
        SafeParcelWriter.writeLong(parcel, 7, getLastUsedTime());
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    FidoCredentialDetails(String str, String str2, byte[] bArr, byte[] bArr2, boolean z, boolean z2, long j, Account account, boolean z3) {
        zzgx zzgx;
        if (bArr == null) {
            zzgx = null;
        } else {
            zzgx = zzgx.zzl(bArr, 0, bArr.length);
        }
        zzgx zzgx2 = zzgx.zzb;
        zzgx zzl = zzgx.zzl(bArr2, 0, bArr2.length);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzgx;
        this.zzd = zzl;
        this.zze = z;
        this.zzf = z2;
        this.zzg = j;
        this.zzh = account;
        this.zzi = z3;
    }
}
