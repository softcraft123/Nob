package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgx;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class AuthenticatorAssertionResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorAssertionResponse> CREATOR = new zzj();
    private final zzgx zza;
    private final zzgx zzb;
    private final zzgx zzc;
    private final zzgx zzd;
    private final zzgx zze;

    AuthenticatorAssertionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        zzgx zzgx;
        byte[] bArr6 = (byte[]) Preconditions.checkNotNull(bArr);
        zzgx zzgx2 = zzgx.zzb;
        zzgx zzl = zzgx.zzl(bArr6, 0, bArr6.length);
        byte[] bArr7 = (byte[]) Preconditions.checkNotNull(bArr2);
        zzgx zzl2 = zzgx.zzl(bArr7, 0, bArr7.length);
        byte[] bArr8 = (byte[]) Preconditions.checkNotNull(bArr3);
        zzgx zzl3 = zzgx.zzl(bArr8, 0, bArr8.length);
        byte[] bArr9 = (byte[]) Preconditions.checkNotNull(bArr4);
        zzgx zzl4 = zzgx.zzl(bArr9, 0, bArr9.length);
        if (bArr5 == null) {
            zzgx = null;
        } else {
            zzgx = zzgx.zzl(bArr5, 0, bArr5.length);
        }
        this.zza = (zzgx) Preconditions.checkNotNull(zzl);
        this.zzb = (zzgx) Preconditions.checkNotNull(zzl2);
        this.zzc = (zzgx) Preconditions.checkNotNull(zzl3);
        this.zzd = (zzgx) Preconditions.checkNotNull(zzl4);
        this.zze = zzgx;
    }

    public static AuthenticatorAssertionResponse deserializeFromBytes(byte[] bArr) {
        return (AuthenticatorAssertionResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAssertionResponse)) {
            return false;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) obj;
        if (!Objects.equal(this.zza, authenticatorAssertionResponse.zza) || !Objects.equal(this.zzb, authenticatorAssertionResponse.zzb) || !Objects.equal(this.zzc, authenticatorAssertionResponse.zzc) || !Objects.equal(this.zzd, authenticatorAssertionResponse.zzd) || !Objects.equal(this.zze, authenticatorAssertionResponse.zze)) {
            return false;
        }
        return true;
    }

    public byte[] getAuthenticatorData() {
        return this.zzc.zzm();
    }

    public zzgx getAuthenticatorDataAsByteString() {
        return this.zzc;
    }

    public byte[] getClientDataJSON() {
        return this.zzb.zzm();
    }

    public zzgx getClientDataJSONAsByteString() {
        return this.zzb;
    }

    @Deprecated
    public byte[] getKeyHandle() {
        return this.zza.zzm();
    }

    @Deprecated
    public zzgx getKeyHandleAsByteString() {
        return this.zza;
    }

    public byte[] getSignature() {
        return this.zzd.zzm();
    }

    public zzgx getSignatureAsByteString() {
        return this.zzd;
    }

    public byte[] getUserHandle() {
        zzgx zzgx = this.zze;
        if (zzgx == null) {
            return null;
        }
        return zzgx.zzm();
    }

    public zzgx getUserHandleAsByteString() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Objects.hashCode(this.zza)), Integer.valueOf(Objects.hashCode(this.zzb)), Integer.valueOf(Objects.hashCode(this.zzc)), Integer.valueOf(Objects.hashCode(this.zzd)), Integer.valueOf(Objects.hashCode(this.zze)));
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public String toString() {
        zzbi zza2 = zzbj.zza(this);
        zzgf zzf = zzgf.zzf();
        byte[] keyHandle = getKeyHandle();
        zza2.zzb(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, zzf.zzg(keyHandle, 0, keyHandle.length));
        zzgf zzf2 = zzgf.zzf();
        byte[] clientDataJSON = getClientDataJSON();
        zza2.zzb("clientDataJSON", zzf2.zzg(clientDataJSON, 0, clientDataJSON.length));
        zzgf zzf3 = zzgf.zzf();
        byte[] authenticatorData = getAuthenticatorData();
        zza2.zzb("authenticatorData", zzf3.zzg(authenticatorData, 0, authenticatorData.length));
        zzgf zzf4 = zzgf.zzf();
        byte[] signature = getSignature();
        zza2.zzb("signature", zzf4.zzg(signature, 0, signature.length));
        byte[] userHandle = getUserHandle();
        if (userHandle != null) {
            zza2.zzb("userHandle", zzgf.zzf().zzg(userHandle, 0, userHandle.length));
        }
        return zza2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAuthenticatorData(), false);
        SafeParcelWriter.writeByteArray(parcel, 5, getSignature(), false);
        SafeParcelWriter.writeByteArray(parcel, 6, getUserHandle(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientDataJSON", Base64Utils.encodeUrlSafeNoPadding(getClientDataJSON()));
            jSONObject.put("authenticatorData", Base64Utils.encodeUrlSafeNoPadding(getAuthenticatorData()));
            jSONObject.put("signature", Base64Utils.encodeUrlSafeNoPadding(getSignature()));
            if (this.zze != null) {
                jSONObject.put("userHandle", Base64Utils.encodeUrlSafeNoPadding(getUserHandle()));
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding AuthenticatorAssertionResponse to JSON object", e);
        }
    }
}
