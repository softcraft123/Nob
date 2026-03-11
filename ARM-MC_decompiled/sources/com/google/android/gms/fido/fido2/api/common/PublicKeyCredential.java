package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzia;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class PublicKeyCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new zzao();
    private final String zza;
    private final String zzb;
    private final zzgx zzc;
    private final AuthenticatorAttestationResponse zzd;
    private final AuthenticatorAssertionResponse zze;
    private final AuthenticatorErrorResponse zzf;
    private final AuthenticationExtensionsClientOutputs zzg;
    private final String zzh;
    private String zzi;

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    public static class Builder {
        private String zza;
        private zzgx zzb;
        private AuthenticatorResponse zzc;
        private AuthenticationExtensionsClientOutputs zzd;
        private String zze;

        public PublicKeyCredential build() {
            AuthenticatorResponse authenticatorResponse = this.zzc;
            AuthenticatorErrorResponse authenticatorErrorResponse = null;
            AuthenticatorAttestationResponse authenticatorAttestationResponse = authenticatorResponse instanceof AuthenticatorAttestationResponse ? (AuthenticatorAttestationResponse) authenticatorResponse : null;
            AuthenticatorAssertionResponse authenticatorAssertionResponse = authenticatorResponse instanceof AuthenticatorAssertionResponse ? (AuthenticatorAssertionResponse) authenticatorResponse : null;
            if (authenticatorResponse instanceof AuthenticatorErrorResponse) {
                authenticatorErrorResponse = (AuthenticatorErrorResponse) authenticatorResponse;
            }
            return new PublicKeyCredential(this.zza, PublicKeyCredentialType.PUBLIC_KEY.toString(), this.zzb, authenticatorAttestationResponse, authenticatorAssertionResponse, authenticatorErrorResponse, this.zzd, this.zze, (String) null, (zzam) null);
        }

        public Builder setAuthenticationExtensionsClientOutputs(AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs) {
            this.zzd = authenticationExtensionsClientOutputs;
            return this;
        }

        public Builder setAuthenticatorAttachment(String str) {
            this.zze = str;
            return this;
        }

        public Builder setId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setRawId(zzgx zzgx) {
            this.zzb = zzgx;
            return this;
        }

        public Builder setRawId(byte[] bArr) {
            this.zzb = bArr == null ? null : zzgx.zzl(bArr, 0, bArr.length);
            return this;
        }

        public Builder setResponse(AuthenticatorResponse authenticatorResponse) {
            this.zzc = authenticatorResponse;
            return this;
        }
    }

    private PublicKeyCredential(String str, String str2, zzgx zzgx, AuthenticatorAttestationResponse authenticatorAttestationResponse, AuthenticatorAssertionResponse authenticatorAssertionResponse, AuthenticatorErrorResponse authenticatorErrorResponse, AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, String str3, String str4) {
        boolean z = true;
        Preconditions.checkArgument((authenticatorAttestationResponse != null && authenticatorAssertionResponse == null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse != null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse == null && authenticatorErrorResponse != null), "Must provide a response object.");
        if (authenticatorErrorResponse == null && (str == null || zzgx == null)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Must provide id and rawId if not an error response.");
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzgx;
        this.zzd = authenticatorAttestationResponse;
        this.zze = authenticatorAssertionResponse;
        this.zzf = authenticatorErrorResponse;
        this.zzg = authenticationExtensionsClientOutputs;
        this.zzh = str3;
        this.zzi = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ PublicKeyCredential(java.lang.String r1, java.lang.String r2, com.google.android.gms.internal.fido.zzgx r3, com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse r4, com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse r5, com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse r6, com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs r7, java.lang.String r8, java.lang.String r9, com.google.android.gms.fido.fido2.api.common.zzam r10) {
        /*
            r0 = this;
            r10 = 0
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (com.google.android.gms.internal.fido.zzgx) r4, (com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse) r5, (com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse) r6, (com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse) r7, (com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs) r8, (java.lang.String) r9, (java.lang.String) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.PublicKeyCredential.<init>(java.lang.String, java.lang.String, com.google.android.gms.internal.fido.zzgx, com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse, com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse, com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse, com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs, java.lang.String, java.lang.String, com.google.android.gms.fido.fido2.api.common.zzam):void");
    }

    public static PublicKeyCredential deserializeFromBytes(byte[] bArr) {
        return (PublicKeyCredential) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredential)) {
            return false;
        }
        PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
        if (!Objects.equal(this.zza, publicKeyCredential.zza) || !Objects.equal(this.zzb, publicKeyCredential.zzb) || !Objects.equal(this.zzc, publicKeyCredential.zzc) || !Objects.equal(this.zzd, publicKeyCredential.zzd) || !Objects.equal(this.zze, publicKeyCredential.zze) || !Objects.equal(this.zzf, publicKeyCredential.zzf) || !Objects.equal(this.zzg, publicKeyCredential.zzg) || !Objects.equal(this.zzh, publicKeyCredential.zzh)) {
            return false;
        }
        return true;
    }

    public String getAuthenticatorAttachment() {
        return this.zzh;
    }

    public AuthenticationExtensionsClientOutputs getClientExtensionResults() {
        return this.zzg;
    }

    public String getId() {
        return this.zza;
    }

    public byte[] getRawId() {
        zzgx zzgx = this.zzc;
        if (zzgx == null) {
            return null;
        }
        return zzgx.zzm();
    }

    public zzgx getRawIdAsByteString() {
        return this.zzc;
    }

    public AuthenticatorResponse getResponse() {
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.zzd;
        if (authenticatorAttestationResponse != null) {
            return authenticatorAttestationResponse;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.zze;
        if (authenticatorAssertionResponse != null) {
            return authenticatorAssertionResponse;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = this.zzf;
        if (authenticatorErrorResponse != null) {
            return authenticatorErrorResponse;
        }
        throw new IllegalStateException("No response set.");
    }

    public String getType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zze, this.zzd, this.zzf, this.zzg, this.zzh);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public String toJson() {
        return zza().toString();
    }

    public final String toString() {
        zzgx zzgx = this.zzc;
        byte[] zzm = zzgx == null ? null : zzgx.zzm();
        String str = this.zzb;
        String str2 = this.zza;
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.zzd;
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.zze;
        AuthenticatorErrorResponse authenticatorErrorResponse = this.zzf;
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = this.zzg;
        String str3 = this.zzh;
        String encodeUrlSafeNoPadding = Base64Utils.encodeUrlSafeNoPadding(zzm);
        String valueOf = String.valueOf(authenticatorAttestationResponse);
        String valueOf2 = String.valueOf(authenticatorAssertionResponse);
        String valueOf3 = String.valueOf(authenticatorErrorResponse);
        String valueOf4 = String.valueOf(authenticationExtensionsClientOutputs);
        return "PublicKeyCredential{\n id='" + str2 + "', \n type='" + str + "', \n rawId=" + encodeUrlSafeNoPadding + ", \n registerResponse=" + valueOf + ", \n signResponse=" + valueOf2 + ", \n errorResponse=" + valueOf3 + ", \n extensionsClientOutputs=" + valueOf4 + ", \n authenticatorAttachment='" + str3 + "'}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (zzia.zzc()) {
            this.zzi = zza().toString();
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getRawId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getClientExtensionResults(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getAuthenticatorAttachment(), false);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        this.zzi = null;
    }

    public final JSONObject zza() {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            zzgx zzgx = this.zzc;
            if (zzgx != null && zzgx.zzm().length > 0) {
                jSONObject2.put("rawId", Base64Utils.encodeUrlSafeNoPadding(this.zzc.zzm()));
            }
            String str = this.zzh;
            if (str != null) {
                jSONObject2.put("authenticatorAttachment", str);
            }
            String str2 = this.zzb;
            if (str2 != null && this.zzf == null) {
                jSONObject2.put("type", str2);
            }
            String str3 = this.zza;
            if (str3 != null) {
                jSONObject2.put("id", str3);
            }
            String str4 = "response";
            AuthenticatorAssertionResponse authenticatorAssertionResponse = this.zze;
            boolean z = true;
            if (authenticatorAssertionResponse != null) {
                jSONObject = authenticatorAssertionResponse.zza();
            } else {
                AuthenticatorAttestationResponse authenticatorAttestationResponse = this.zzd;
                if (authenticatorAttestationResponse != null) {
                    jSONObject = authenticatorAttestationResponse.zza();
                } else {
                    AuthenticatorErrorResponse authenticatorErrorResponse = this.zzf;
                    z = false;
                    if (authenticatorErrorResponse != null) {
                        jSONObject = authenticatorErrorResponse.zza();
                        str4 = "error";
                    } else {
                        jSONObject = null;
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.put(str4, jSONObject);
            }
            AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = this.zzg;
            if (authenticationExtensionsClientOutputs != null) {
                jSONObject2.put("clientExtensionResults", authenticationExtensionsClientOutputs.zza());
                return jSONObject2;
            }
            if (z) {
                jSONObject2.put("clientExtensionResults", new JSONObject());
            }
            return jSONObject2;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding PublicKeyCredential to JSON object", e);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PublicKeyCredential(java.lang.String r11, java.lang.String r12, byte[] r13, com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse r14, com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse r15, com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse r16, com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs r17, java.lang.String r18, java.lang.String r19) {
        /*
            r10 = this;
            if (r13 != 0) goto L_0x0004
            r13 = 0
            goto L_0x000a
        L_0x0004:
            r0 = 0
            int r1 = r13.length
            com.google.android.gms.internal.fido.zzgx r13 = com.google.android.gms.internal.fido.zzgx.zzl(r13, r0, r1)
        L_0x000a:
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.fido.zzgx) r3, (com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse) r4, (com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse) r5, (com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse) r6, (com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs) r7, (java.lang.String) r8, (java.lang.String) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.PublicKeyCredential.<init>(java.lang.String, java.lang.String, byte[], com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse, com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse, com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse, com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs, java.lang.String, java.lang.String):void");
    }
}
