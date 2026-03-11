package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzgx;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new zzau();
    private final zzgx zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public PublicKeyCredentialUserEntity(zzgx zzgx, String str, String str2, String str3) {
        this.zza = (zzgx) Preconditions.checkNotNull(zzgx);
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zzc = str2;
        this.zzd = (String) Preconditions.checkNotNull(str3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        if (!Objects.equal(this.zza, publicKeyCredentialUserEntity.zza) || !Objects.equal(this.zzb, publicKeyCredentialUserEntity.zzb) || !Objects.equal(this.zzc, publicKeyCredentialUserEntity.zzc) || !Objects.equal(this.zzd, publicKeyCredentialUserEntity.zzd)) {
            return false;
        }
        return true;
    }

    public String getDisplayName() {
        return this.zzd;
    }

    public String getIcon() {
        return this.zzc;
    }

    public byte[] getId() {
        return this.zza.zzm();
    }

    public zzgx getIdAsByteString() {
        return this.zza;
    }

    public String getName() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final String toString() {
        String encodeUrlSafeNoPadding = Base64Utils.encodeUrlSafeNoPadding(this.zza.zzm());
        return "PublicKeyCredentialUserEntity{\n id=" + encodeUrlSafeNoPadding + ", \n name='" + this.zzb + "', \n icon='" + this.zzc + "', \n displayName='" + this.zzd + "'}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIcon(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PublicKeyCredentialUserEntity(byte[] r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = (byte[]) r3
            com.google.android.gms.internal.fido.zzgx r0 = com.google.android.gms.internal.fido.zzgx.zzb
            int r0 = r3.length
            r1 = 0
            com.google.android.gms.internal.fido.zzgx r3 = com.google.android.gms.internal.fido.zzgx.zzl(r3, r1, r0)
            r2.<init>((com.google.android.gms.internal.fido.zzgx) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity.<init>(byte[], java.lang.String, java.lang.String, java.lang.String):void");
    }
}
