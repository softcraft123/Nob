package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class AuthenticationExtensions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticationExtensions> CREATOR = new zzd();
    private final FidoAppIdExtension zza;
    private final zzs zzb;
    private final UserVerificationMethodExtension zzc;
    private final zzz zzd;
    private final zzab zze;
    private final zzad zzf;
    private final zzu zzg;
    private final zzag zzh;
    private final GoogleThirdPartyPaymentExtension zzi;
    private final zzak zzj;
    private final zzaw zzk;
    private final zzai zzl;

    /* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
    public static final class Builder {
        private FidoAppIdExtension zza;
        private UserVerificationMethodExtension zzb;
        private zzs zzc;
        private zzz zzd;
        private zzab zze;
        private zzad zzf;
        private zzu zzg;
        private zzag zzh;
        private GoogleThirdPartyPaymentExtension zzi;
        private zzak zzj;
        private zzaw zzk;
        private zzai zzl;

        public Builder() {
        }

        public Builder(AuthenticationExtensions authenticationExtensions) {
            if (authenticationExtensions != null) {
                this.zza = authenticationExtensions.getFidoAppIdExtension();
                this.zzb = authenticationExtensions.getUserVerificationMethodExtension();
                this.zzc = authenticationExtensions.zzb();
                this.zzd = authenticationExtensions.zzd();
                this.zze = authenticationExtensions.zze();
                this.zzf = authenticationExtensions.zzf();
                this.zzg = authenticationExtensions.zzc();
                this.zzh = authenticationExtensions.zzh();
                this.zzi = authenticationExtensions.zzg();
                this.zzj = authenticationExtensions.zzj();
                this.zzk = authenticationExtensions.zzk();
                this.zzl = authenticationExtensions.zzi();
            }
        }

        public AuthenticationExtensions build() {
            return new AuthenticationExtensions(this.zza, this.zzc, this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
        }

        public Builder setFido2Extension(FidoAppIdExtension fidoAppIdExtension) {
            this.zza = fidoAppIdExtension;
            return this;
        }

        public Builder setGoogleThirdPartyPaymentExtension(GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension) {
            this.zzi = googleThirdPartyPaymentExtension;
            return this;
        }

        public Builder setUserVerificationMethodExtension(UserVerificationMethodExtension userVerificationMethodExtension) {
            this.zzb = userVerificationMethodExtension;
            return this;
        }

        public final Builder zza(zzs zzs) {
            this.zzc = zzs;
            return this;
        }

        public final Builder zzb(zzu zzu) {
            this.zzg = zzu;
            return this;
        }

        public final Builder zzc(zzz zzz) {
            this.zzd = zzz;
            return this;
        }

        public final Builder zzd(zzab zzab) {
            this.zze = zzab;
            return this;
        }

        public final Builder zze(zzad zzad) {
            this.zzf = zzad;
            return this;
        }

        public final Builder zzf(zzag zzag) {
            this.zzh = zzag;
            return this;
        }

        public final Builder zzg(zzak zzak) {
            this.zzj = zzak;
            return this;
        }

        public final Builder zzh(zzaw zzaw) {
            this.zzk = zzaw;
            return this;
        }
    }

    AuthenticationExtensions(FidoAppIdExtension fidoAppIdExtension, zzs zzs, UserVerificationMethodExtension userVerificationMethodExtension, zzz zzz, zzab zzab, zzad zzad, zzu zzu, zzag zzag, GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension, zzak zzak, zzaw zzaw, zzai zzai) {
        this.zza = fidoAppIdExtension;
        this.zzc = userVerificationMethodExtension;
        this.zzb = zzs;
        this.zzd = zzz;
        this.zze = zzab;
        this.zzf = zzad;
        this.zzg = zzu;
        this.zzh = zzag;
        this.zzi = googleThirdPartyPaymentExtension;
        this.zzj = zzak;
        this.zzk = zzaw;
        this.zzl = zzai;
    }

    public static AuthenticationExtensions zza(JSONObject jSONObject) throws JSONException {
        Builder builder = new Builder();
        if (jSONObject.has("fidoAppIdExtension")) {
            builder.setFido2Extension(new FidoAppIdExtension(jSONObject.getJSONObject("fidoAppIdExtension").getString("appid")));
        }
        if (jSONObject.has("appid")) {
            builder.setFido2Extension(new FidoAppIdExtension(jSONObject.getString("appid")));
        }
        if (jSONObject.has("prf")) {
            if (!jSONObject.has("prfAlreadyHashed")) {
                builder.zzg(zzak.zza(jSONObject.getJSONObject("prf"), false));
            } else {
                throw new JSONException("both prf and prfAlreadyHashed extensions found");
            }
        } else if (jSONObject.has("prfAlreadyHashed")) {
            builder.zzg(zzak.zza(jSONObject.getJSONObject("prfAlreadyHashed"), true));
        }
        if (jSONObject.has("cableAuthenticationExtension")) {
            JSONArray jSONArray = jSONObject.getJSONArray("cableAuthenticationExtension");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new zzq(jSONObject2.getLong("version"), Base64.decode(jSONObject2.getString("clientEid"), 11), Base64.decode(jSONObject2.getString("authenticatorEid"), 11), Base64.decode(jSONObject2.getString("sessionPreKey"), 11)));
            }
            builder.zza(new zzs(arrayList));
        }
        if (jSONObject.has("userVerificationMethodExtension")) {
            builder.setUserVerificationMethodExtension(new UserVerificationMethodExtension(jSONObject.getJSONObject("userVerificationMethodExtension").getBoolean("uvm")));
        }
        if (jSONObject.has("google_multiAssertionExtension")) {
            builder.zzc(new zzz(jSONObject.getJSONObject("google_multiAssertionExtension").getBoolean("requestForMultiAssertion")));
        }
        if (jSONObject.has("google_sessionIdExtension")) {
            builder.zzd(new zzab((long) jSONObject.getJSONObject("google_sessionIdExtension").getInt("sessionId")));
        }
        if (jSONObject.has("google_silentVerificationExtension")) {
            builder.zze(new zzad(jSONObject.getJSONObject("google_silentVerificationExtension").getBoolean("silentVerification")));
        }
        if (jSONObject.has("devicePublicKeyExtension")) {
            builder.zzb(new zzu(jSONObject.getJSONObject("devicePublicKeyExtension").getBoolean("devicePublicKey")));
        }
        if (jSONObject.has("google_tunnelServerIdExtension")) {
            builder.zzf(new zzag(jSONObject.getJSONObject("google_tunnelServerIdExtension").getString("tunnelServerId")));
        }
        if (jSONObject.has("google_thirdPartyPaymentExtension")) {
            builder.setGoogleThirdPartyPaymentExtension(new GoogleThirdPartyPaymentExtension(jSONObject.getJSONObject("google_thirdPartyPaymentExtension").getBoolean("thirdPartyPayment")));
        }
        if (jSONObject.has("txAuthSimple")) {
            builder.zzh(new zzaw(jSONObject.getString("txAuthSimple")));
        }
        return builder.build();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensions)) {
            return false;
        }
        AuthenticationExtensions authenticationExtensions = (AuthenticationExtensions) obj;
        if (!Objects.equal(this.zza, authenticationExtensions.zza) || !Objects.equal(this.zzb, authenticationExtensions.zzb) || !Objects.equal(this.zzc, authenticationExtensions.zzc) || !Objects.equal(this.zzd, authenticationExtensions.zzd) || !Objects.equal(this.zze, authenticationExtensions.zze) || !Objects.equal(this.zzf, authenticationExtensions.zzf) || !Objects.equal(this.zzg, authenticationExtensions.zzg) || !Objects.equal(this.zzh, authenticationExtensions.zzh) || !Objects.equal(this.zzi, authenticationExtensions.zzi) || !Objects.equal(this.zzj, authenticationExtensions.zzj) || !Objects.equal(this.zzk, authenticationExtensions.zzk) || !Objects.equal(this.zzl, authenticationExtensions.zzl)) {
            return false;
        }
        return true;
    }

    public FidoAppIdExtension getFidoAppIdExtension() {
        return this.zza;
    }

    public UserVerificationMethodExtension getUserVerificationMethodExtension() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
    }

    public final String toString() {
        zzaw zzaw = this.zzk;
        zzak zzak = this.zzj;
        GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension = this.zzi;
        zzag zzag = this.zzh;
        zzu zzu = this.zzg;
        zzad zzad = this.zzf;
        zzab zzab = this.zze;
        zzz zzz = this.zzd;
        UserVerificationMethodExtension userVerificationMethodExtension = this.zzc;
        zzs zzs = this.zzb;
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(zzs);
        String valueOf3 = String.valueOf(userVerificationMethodExtension);
        String valueOf4 = String.valueOf(zzz);
        String valueOf5 = String.valueOf(zzab);
        String valueOf6 = String.valueOf(zzad);
        String valueOf7 = String.valueOf(zzu);
        String valueOf8 = String.valueOf(zzag);
        String valueOf9 = String.valueOf(googleThirdPartyPaymentExtension);
        String valueOf10 = String.valueOf(zzak);
        String valueOf11 = String.valueOf(zzaw);
        return "AuthenticationExtensions{\n fidoAppIdExtension=" + valueOf + ", \n cableAuthenticationExtension=" + valueOf2 + ", \n userVerificationMethodExtension=" + valueOf3 + ", \n googleMultiAssertionExtension=" + valueOf4 + ", \n googleSessionIdExtension=" + valueOf5 + ", \n googleSilentVerificationExtension=" + valueOf6 + ", \n devicePublicKeyExtension=" + valueOf7 + ", \n googleTunnelServerIdExtension=" + valueOf8 + ", \n googleThirdPartyPaymentExtension=" + valueOf9 + ", \n prfExtension=" + valueOf10 + ", \n simpleTransactionAuthorizationExtension=" + valueOf11 + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getFidoAppIdExtension(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getUserVerificationMethodExtension(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzs zzb() {
        return this.zzb;
    }

    public final zzu zzc() {
        return this.zzg;
    }

    public final zzz zzd() {
        return this.zzd;
    }

    public final zzab zze() {
        return this.zze;
    }

    public final zzad zzf() {
        return this.zzf;
    }

    public final GoogleThirdPartyPaymentExtension zzg() {
        return this.zzi;
    }

    public final zzag zzh() {
        return this.zzh;
    }

    public final zzai zzi() {
        return this.zzl;
    }

    public final zzak zzj() {
        return this.zzj;
    }

    public final zzaw zzk() {
        return this.zzk;
    }
}
