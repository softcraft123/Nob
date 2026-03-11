package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import com.google.android.gms.internal.fido.zzcf;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzh;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class PublicKeyCredentialDescriptor extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredentialDescriptor> CREATOR = new zzap();
    private static final zzcf zza = zzcf.zzm(zzh.zza, zzh.zzb);
    private final PublicKeyCredentialType zzb;
    private final zzgx zzc;
    private final List zzd;

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    public static class UnsupportedPubKeyCredDescriptorException extends Exception {
        public UnsupportedPubKeyCredDescriptorException(String str) {
            super(str);
        }

        public UnsupportedPubKeyCredDescriptorException(String str, Throwable th) {
            super(str, th);
        }
    }

    public PublicKeyCredentialDescriptor(String str, zzgx zzgx, List<Transport> list) {
        Preconditions.checkNotNull(str);
        try {
            this.zzb = PublicKeyCredentialType.fromString(str);
            this.zzc = (zzgx) Preconditions.checkNotNull(zzgx);
            this.zzd = list;
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static PublicKeyCredentialDescriptor zza(JSONObject jSONObject) throws JSONException {
        return new PublicKeyCredentialDescriptor(jSONObject.getString("type"), Base64.decode(jSONObject.getString("id"), 11), jSONObject.has("transports") ? Transport.parseTransports(jSONObject.getJSONArray("transports")) : null);
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        if (!this.zzb.equals(publicKeyCredentialDescriptor.zzb) || !Objects.equal(this.zzc, publicKeyCredentialDescriptor.zzc)) {
            return false;
        }
        List list2 = this.zzd;
        if (list2 == null && publicKeyCredentialDescriptor.zzd == null) {
            return true;
        }
        if (list2 == null || (list = publicKeyCredentialDescriptor.zzd) == null || !list2.containsAll(list) || !publicKeyCredentialDescriptor.zzd.containsAll(this.zzd)) {
            return false;
        }
        return true;
    }

    public byte[] getId() {
        return this.zzc.zzm();
    }

    public zzgx getIdAsByteString() {
        return this.zzc;
    }

    public List<Transport> getTransports() {
        return this.zzd;
    }

    public PublicKeyCredentialType getType() {
        return this.zzb;
    }

    public String getTypeAsString() {
        return this.zzb.toString();
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, this.zzd);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        String encodeUrlSafeNoPadding = Base64Utils.encodeUrlSafeNoPadding(getId());
        String valueOf2 = String.valueOf(this.zzd);
        return "PublicKeyCredentialDescriptor{\n type=" + valueOf + ", \n id=" + encodeUrlSafeNoPadding + ", \n transports=" + valueOf2 + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getTypeAsString(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getId(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PublicKeyCredentialDescriptor(String str, byte[] bArr, List<Transport> list) {
        this(str, zzgx.zzl(bArr, 0, bArr.length), list);
        zzgx zzgx = zzgx.zzb;
    }
}
