package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.android.gms.internal.fido.zzbl;
import com.google.android.gms.internal.fido.zzia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class PublicKeyCredentialCreationOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzan();
    private final PublicKeyCredentialRpEntity zza;
    private final PublicKeyCredentialUserEntity zzb;
    private final byte[] zzc;
    private final List zzd;
    private final Double zze;
    private final List zzf;
    private final AuthenticatorSelectionCriteria zzg;
    private final Integer zzh;
    private final TokenBinding zzi;
    private final AttestationConveyancePreference zzj;
    private final AuthenticationExtensions zzk;
    private final String zzl;
    private ResultReceiver zzm;

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    public static final class Builder {
        private PublicKeyCredentialRpEntity zza;
        private PublicKeyCredentialUserEntity zzb;
        private byte[] zzc;
        private List zzd;
        private Double zze;
        private List zzf;
        private AuthenticatorSelectionCriteria zzg;
        private Integer zzh;
        private TokenBinding zzi;
        private AttestationConveyancePreference zzj;
        private AuthenticationExtensions zzk;

        public PublicKeyCredentialCreationOptions build() {
            String str;
            PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = this.zza;
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
            byte[] bArr = this.zzc;
            List list = this.zzd;
            Double d = this.zze;
            List list2 = this.zzf;
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
            Integer num = this.zzh;
            TokenBinding tokenBinding = this.zzi;
            AttestationConveyancePreference attestationConveyancePreference = this.zzj;
            if (attestationConveyancePreference == null) {
                str = null;
            } else {
                str = attestationConveyancePreference.toString();
            }
            return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArr, list, d, list2, authenticatorSelectionCriteria, num, tokenBinding, str, this.zzk, (String) null, (ResultReceiver) null);
        }

        public Builder setAttestationConveyancePreference(AttestationConveyancePreference attestationConveyancePreference) {
            this.zzj = attestationConveyancePreference;
            return this;
        }

        public Builder setAuthenticationExtensions(AuthenticationExtensions authenticationExtensions) {
            this.zzk = authenticationExtensions;
            return this;
        }

        public Builder setAuthenticatorSelection(AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
            this.zzg = authenticatorSelectionCriteria;
            return this;
        }

        public Builder setChallenge(byte[] bArr) {
            this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        public Builder setExcludeList(List<PublicKeyCredentialDescriptor> list) {
            this.zzf = list;
            return this;
        }

        public Builder setParameters(List<PublicKeyCredentialParameters> list) {
            this.zzd = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public Builder setRequestId(Integer num) {
            this.zzh = num;
            return this;
        }

        public Builder setRp(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity) {
            this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
            return this;
        }

        public Builder setTimeoutSeconds(Double d) {
            this.zze = d;
            return this;
        }

        public Builder setTokenBinding(TokenBinding tokenBinding) {
            this.zzi = tokenBinding;
            return this;
        }

        public Builder setUser(PublicKeyCredentialUserEntity publicKeyCredentialUserEntity) {
            this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
            return this;
        }
    }

    PublicKeyCredentialCreationOptions(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, byte[] bArr, List list, Double d, List list2, AuthenticatorSelectionCriteria authenticatorSelectionCriteria, Integer num, TokenBinding tokenBinding, String str, AuthenticationExtensions authenticationExtensions, String str2, ResultReceiver resultReceiver) {
        this.zzm = resultReceiver;
        if (str2 != null) {
            try {
                PublicKeyCredentialCreationOptions zza2 = zza(new JSONObject(str2));
                this.zza = zza2.zza;
                this.zzb = zza2.zzb;
                this.zzc = zza2.zzc;
                this.zzd = zza2.zzd;
                this.zze = zza2.zze;
                this.zzf = zza2.zzf;
                this.zzg = zza2.zzg;
                this.zzh = zza2.zzh;
                this.zzi = zza2.zzi;
                this.zzj = zza2.zzj;
                this.zzk = zza2.zzk;
                this.zzl = str2;
            } catch (JSONException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
            this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
            this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
            this.zzd = (List) Preconditions.checkNotNull(list);
            this.zze = d;
            this.zzf = list2;
            this.zzg = authenticatorSelectionCriteria;
            this.zzh = num;
            this.zzi = tokenBinding;
            if (str != null) {
                try {
                    this.zzj = AttestationConveyancePreference.fromString(str);
                } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } else {
                this.zzj = null;
            }
            this.zzk = authenticationExtensions;
            this.zzl = null;
        }
    }

    public static PublicKeyCredentialCreationOptions deserializeFromBytes(byte[] bArr) {
        return (PublicKeyCredentialCreationOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public static PublicKeyCredentialCreationOptions zza(JSONObject jSONObject) throws JSONException {
        zzbl zzbl;
        Builder builder = new Builder();
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        Parcelable.Creator<PublicKeyCredentialRpEntity> creator = PublicKeyCredentialRpEntity.CREATOR;
        String str = null;
        builder.setRp(new PublicKeyCredentialRpEntity(jSONObject2.getString("id"), jSONObject2.getString("name"), jSONObject2.has("icon") ? jSONObject2.optString("icon") : null));
        JSONObject jSONObject3 = jSONObject.getJSONObject("user");
        Parcelable.Creator<PublicKeyCredentialUserEntity> creator2 = PublicKeyCredentialUserEntity.CREATOR;
        builder.setUser(new PublicKeyCredentialUserEntity(Base64Utils.decodeUrlSafeNoPadding(jSONObject3.getString("id")), jSONObject3.getString("name"), jSONObject3.has("icon") ? jSONObject3.optString("icon") : null, jSONObject3.optString("displayName")));
        builder.setChallenge(Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString(ClientData.KEY_CHALLENGE)));
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i);
            Parcelable.Creator<PublicKeyCredentialParameters> creator3 = PublicKeyCredentialParameters.CREATOR;
            try {
                zzbl = zzbl.zzd(new PublicKeyCredentialParameters(jSONObject4.getString("type"), jSONObject4.getInt("alg")));
            } catch (IllegalArgumentException unused) {
                zzbl = zzbl.zzc();
            }
            if (zzbl.zzb()) {
                arrayList.add(zzbl.zza());
            }
        }
        builder.setParameters(arrayList);
        if (jSONObject.has("timeout")) {
            builder.setTimeoutSeconds(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
        }
        if (jSONObject.has("excludeCredentials")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("excludeCredentials");
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(PublicKeyCredentialDescriptor.zza(jSONArray2.getJSONObject(i2)));
            }
            builder.setExcludeList(arrayList2);
        }
        if (jSONObject.has("authenticatorSelection")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("authenticatorSelection");
            Parcelable.Creator<AuthenticatorSelectionCriteria> creator4 = AuthenticatorSelectionCriteria.CREATOR;
            String optString = jSONObject5.has("authenticatorAttachment") ? jSONObject5.optString("authenticatorAttachment") : null;
            String optString2 = jSONObject5.has("residentKey") ? jSONObject5.optString("residentKey") : null;
            Boolean valueOf = jSONObject5.has("requireResidentKey") ? Boolean.valueOf(jSONObject5.optBoolean("requireResidentKey")) : null;
            if (jSONObject5.has("userVerification")) {
                str = jSONObject5.optString("userVerification");
            }
            builder.setAuthenticatorSelection(new AuthenticatorSelectionCriteria(optString, valueOf, str, optString2));
        }
        if (jSONObject.has("extensions")) {
            builder.setAuthenticationExtensions(AuthenticationExtensions.zza(jSONObject.getJSONObject("extensions")));
        }
        if (jSONObject.has("attestation")) {
            try {
                builder.setAttestationConveyancePreference(AttestationConveyancePreference.fromString(jSONObject.getString("attestation")));
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e) {
                Log.w("PKCCreationOptions", "Invalid AttestationConveyancePreference", e);
                builder.setAttestationConveyancePreference(AttestationConveyancePreference.NONE);
            }
        }
        return builder.build();
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        if (!Objects.equal(this.zza, publicKeyCredentialCreationOptions.zza) || !Objects.equal(this.zzb, publicKeyCredentialCreationOptions.zzb) || !Arrays.equals(this.zzc, publicKeyCredentialCreationOptions.zzc) || !Objects.equal(this.zze, publicKeyCredentialCreationOptions.zze) || !this.zzd.containsAll(publicKeyCredentialCreationOptions.zzd) || !publicKeyCredentialCreationOptions.zzd.containsAll(this.zzd) || ((((list = this.zzf) != null || publicKeyCredentialCreationOptions.zzf != null) && (list == null || (list2 = publicKeyCredentialCreationOptions.zzf) == null || !list.containsAll(list2) || !publicKeyCredentialCreationOptions.zzf.containsAll(this.zzf))) || !Objects.equal(this.zzg, publicKeyCredentialCreationOptions.zzg) || !Objects.equal(this.zzh, publicKeyCredentialCreationOptions.zzh) || !Objects.equal(this.zzi, publicKeyCredentialCreationOptions.zzi) || !Objects.equal(this.zzj, publicKeyCredentialCreationOptions.zzj) || !Objects.equal(this.zzk, publicKeyCredentialCreationOptions.zzk) || !Objects.equal(this.zzl, publicKeyCredentialCreationOptions.zzl))) {
            return false;
        }
        return true;
    }

    public AttestationConveyancePreference getAttestationConveyancePreference() {
        return this.zzj;
    }

    public String getAttestationConveyancePreferenceAsString() {
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzk;
    }

    public AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.zzg;
    }

    public byte[] getChallenge() {
        return this.zzc;
    }

    public List<PublicKeyCredentialDescriptor> getExcludeList() {
        return this.zzf;
    }

    public String getJsonString() {
        return this.zzl;
    }

    public List<PublicKeyCredentialParameters> getParameters() {
        return this.zzd;
    }

    public Integer getRequestId() {
        return this.zzh;
    }

    public PublicKeyCredentialRpEntity getRp() {
        return this.zza;
    }

    public Double getTimeoutSeconds() {
        return this.zze;
    }

    public TokenBinding getTokenBinding() {
        return this.zzi;
    }

    public PublicKeyCredentialUserEntity getUser() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
    }

    public byte[] serializeToBytes() {
        if (!zzia.zzd()) {
            return SafeParcelableSerializer.serializeToBytes(this);
        }
        Builder builder = new Builder();
        builder.setRp(this.zza);
        builder.setUser(this.zzb);
        builder.setChallenge(this.zzc);
        builder.setParameters(this.zzd);
        builder.setTimeoutSeconds(this.zze);
        builder.setExcludeList(this.zzf);
        builder.setAuthenticatorSelection(this.zzg);
        builder.setRequestId(this.zzh);
        builder.setTokenBinding(this.zzi);
        builder.setAttestationConveyancePreference(this.zzj);
        builder.setAuthenticationExtensions(this.zzk);
        return SafeParcelableSerializer.serializeToBytes(builder.build());
    }

    public final String toString() {
        AuthenticationExtensions authenticationExtensions = this.zzk;
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        TokenBinding tokenBinding = this.zzi;
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
        List list = this.zzf;
        List list2 = this.zzd;
        byte[] bArr = this.zzc;
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(publicKeyCredentialUserEntity);
        String encodeUrlSafeNoPadding = Base64Utils.encodeUrlSafeNoPadding(bArr);
        String valueOf3 = String.valueOf(list2);
        String valueOf4 = String.valueOf(list);
        String valueOf5 = String.valueOf(authenticatorSelectionCriteria);
        String valueOf6 = String.valueOf(tokenBinding);
        String valueOf7 = String.valueOf(attestationConveyancePreference);
        String valueOf8 = String.valueOf(authenticationExtensions);
        return "PublicKeyCredentialCreationOptions{\n rp=" + valueOf + ", \n user=" + valueOf2 + ", \n challenge=" + encodeUrlSafeNoPadding + ", \n parameters=" + valueOf3 + ", \n timeoutSeconds=" + this.zze + ", \n excludeList=" + valueOf4 + ", \n authenticatorSelection=" + valueOf5 + ", \n requestId=" + this.zzh + ", \n tokenBinding=" + valueOf6 + ", \n attestationConveyancePreference=" + valueOf7 + ", \n authenticationExtensions=" + valueOf8 + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getRp(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getUser(), i, false);
        SafeParcelWriter.writeByteArray(parcel, 4, getChallenge(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getParameters(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 6, getTimeoutSeconds(), false);
        SafeParcelWriter.writeTypedList(parcel, 7, getExcludeList(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getAuthenticatorSelection(), i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 9, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 10, getTokenBinding(), i, false);
        SafeParcelWriter.writeString(parcel, 11, getAttestationConveyancePreferenceAsString(), false);
        SafeParcelWriter.writeParcelable(parcel, 12, getAuthenticationExtensions(), i, false);
        SafeParcelWriter.writeString(parcel, 13, getJsonString(), false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public PublicKeyCredentialCreationOptions(String str) {
        try {
            PublicKeyCredentialCreationOptions zza2 = zza(new JSONObject(str));
            this.zza = zza2.zza;
            this.zzb = zza2.zzb;
            this.zzc = zza2.zzc;
            this.zzd = zza2.zzd;
            this.zze = zza2.zze;
            this.zzf = zza2.zzf;
            this.zzg = zza2.zzg;
            this.zzh = zza2.zzh;
            this.zzi = zza2.zzi;
            this.zzj = zza2.zzj;
            this.zzk = zza2.zzk;
            this.zzl = str;
        } catch (JSONException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
