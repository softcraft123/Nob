package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgx;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();
    private final zzgx zza;
    private final zzgx zzb;
    private final zzgx zzc;
    private final String[] zzd;

    AuthenticatorAttestationResponse(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        byte[] bArr4 = (byte[]) Preconditions.checkNotNull(bArr);
        zzgx zzgx = zzgx.zzb;
        zzgx zzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) Preconditions.checkNotNull(bArr2);
        zzgx zzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) Preconditions.checkNotNull(bArr3);
        zzgx zzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.zza = (zzgx) Preconditions.checkNotNull(zzl);
        this.zzb = (zzgx) Preconditions.checkNotNull(zzl2);
        this.zzc = (zzgx) Preconditions.checkNotNull(zzl3);
        this.zzd = (String[]) Preconditions.checkNotNull(strArr);
    }

    public static AuthenticatorAttestationResponse deserializeFromBytes(byte[] bArr) {
        return (AuthenticatorAttestationResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        if (!Objects.equal(this.zza, authenticatorAttestationResponse.zza) || !Objects.equal(this.zzb, authenticatorAttestationResponse.zzb) || !Objects.equal(this.zzc, authenticatorAttestationResponse.zzc)) {
            return false;
        }
        return true;
    }

    public byte[] getAttestationObject() {
        return this.zzc.zzm();
    }

    public zzgx getAttestationObjectAsByteString() {
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

    public zzgx getKeyHandleAsByteString() {
        return this.zza;
    }

    public String[] getTransports() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Objects.hashCode(this.zza)), Integer.valueOf(Objects.hashCode(this.zzb)), Integer.valueOf(Objects.hashCode(this.zzc)));
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
        byte[] attestationObject = getAttestationObject();
        zza2.zzb("attestationObject", zzf3.zzg(attestationObject, 0, attestationObject.length));
        zza2.zzb("transports", Arrays.toString(this.zzd));
        return zza2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAttestationObject(), false);
        SafeParcelWriter.writeStringArray(parcel, 5, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f1 A[Catch:{ zzho -> 0x0234, IllegalArgumentException -> 0x0223, zzho -> 0x0201, JSONException -> 0x0248 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject zza() {
        /*
            r19 = this;
            r1 = r19
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0248 }
            r0.<init>()     // Catch:{ JSONException -> 0x0248 }
            com.google.android.gms.internal.fido.zzgx r2 = r1.zzb     // Catch:{ JSONException -> 0x0248 }
            if (r2 == 0) goto L_0x0018
            java.lang.String r2 = "clientDataJSON"
            byte[] r3 = r1.getClientDataJSON()     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r3)     // Catch:{ JSONException -> 0x0248 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0248 }
        L_0x0018:
            com.google.android.gms.internal.fido.zzgx r2 = r1.zzc     // Catch:{ JSONException -> 0x0248 }
            if (r2 == 0) goto L_0x0029
            java.lang.String r2 = "attestationObject"
            byte[] r3 = r1.getAttestationObject()     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r3)     // Catch:{ JSONException -> 0x0248 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0248 }
        L_0x0029:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0248 }
            r2.<init>()     // Catch:{ JSONException -> 0x0248 }
            r3 = 0
            r4 = r3
        L_0x0030:
            java.lang.String[] r5 = r1.zzd     // Catch:{ JSONException -> 0x0248 }
            int r6 = r5.length     // Catch:{ JSONException -> 0x0248 }
            if (r4 >= r6) goto L_0x0053
            r5 = r5[r4]     // Catch:{ JSONException -> 0x0248 }
            com.google.android.gms.fido.common.Transport r6 = com.google.android.gms.fido.common.Transport.HYBRID     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x0248 }
            boolean r5 = r5.equals(r6)     // Catch:{ JSONException -> 0x0248 }
            if (r5 == 0) goto L_0x0049
            java.lang.String r5 = "hybrid"
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x0248 }
            goto L_0x0050
        L_0x0049:
            java.lang.String[] r5 = r1.zzd     // Catch:{ JSONException -> 0x0248 }
            r5 = r5[r4]     // Catch:{ JSONException -> 0x0248 }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x0248 }
        L_0x0050:
            int r4 = r4 + 1
            goto L_0x0030
        L_0x0053:
            java.lang.String r4 = "transports"
            r0.put(r4, r2)     // Catch:{ JSONException -> 0x0248 }
            byte[] r2 = r1.getAttestationObject()     // Catch:{ JSONException -> 0x0248 }
            com.google.android.gms.internal.fido.zzhp r2 = com.google.android.gms.internal.fido.zzhp.zzj(r2)     // Catch:{ zzho -> 0x023f, zzhj -> 0x023d }
            com.google.android.gms.internal.fido.zzhm r2 = r2.zzh()     // Catch:{ zzho -> 0x023f, zzhj -> 0x023d }
            com.google.android.gms.internal.fido.zzcj r2 = r2.zzc()     // Catch:{ zzho -> 0x0234 }
            java.lang.String r4 = "authData"
            com.google.android.gms.internal.fido.zzhn r4 = com.google.android.gms.internal.fido.zzhp.zzi(r4)     // Catch:{ zzho -> 0x0234 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ zzho -> 0x0234 }
            com.google.android.gms.internal.fido.zzhp r2 = (com.google.android.gms.internal.fido.zzhp) r2     // Catch:{ zzho -> 0x0234 }
            if (r2 == 0) goto L_0x022c
            com.google.android.gms.internal.fido.zzhi r2 = r2.zze()     // Catch:{ zzho -> 0x0234 }
            com.google.android.gms.internal.fido.zzgx r2 = r2.zzc()     // Catch:{ zzho -> 0x0234 }
            java.nio.ByteBuffer r4 = r2.zzi()     // Catch:{ JSONException -> 0x0248 }
            int r5 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0223 }
            r6 = 32
            int r5 = r5 + r6
            r4.position(r5)     // Catch:{ IllegalArgumentException -> 0x0223 }
            byte r5 = r4.get()     // Catch:{ IllegalArgumentException -> 0x0223 }
            r5 = r5 & 64
            if (r5 == 0) goto L_0x021b
            int r5 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0223 }
            int r5 = r5 + 4
            r4.position(r5)     // Catch:{ IllegalArgumentException -> 0x0223 }
            int r5 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0223 }
            int r5 = r5 + 16
            r4.position(r5)     // Catch:{ IllegalArgumentException -> 0x0223 }
            short r5 = r4.getShort()     // Catch:{ IllegalArgumentException -> 0x0223 }
            int r7 = r4.position()     // Catch:{ IllegalArgumentException -> 0x0223 }
            int r7 = r7 + r5
            r4.position(r7)     // Catch:{ IllegalArgumentException -> 0x0223 }
            int r4 = r4.position()     // Catch:{ zzho -> 0x0212, zzhj -> 0x0210 }
            int r5 = r2.zzd()     // Catch:{ zzho -> 0x0212, zzhj -> 0x0210 }
            com.google.android.gms.internal.fido.zzgx r4 = r2.zzg(r4, r5)     // Catch:{ zzho -> 0x0212, zzhj -> 0x0210 }
            java.io.InputStream r4 = r4.zzh()     // Catch:{ zzho -> 0x0212, zzhj -> 0x0210 }
            com.google.android.gms.internal.fido.zzhp r4 = com.google.android.gms.internal.fido.zzhp.zzk(r4)     // Catch:{ zzho -> 0x0212, zzhj -> 0x0210 }
            com.google.android.gms.internal.fido.zzhm r4 = r4.zzh()     // Catch:{ zzho -> 0x0212, zzhj -> 0x0210 }
            com.google.android.gms.internal.fido.zzcj r5 = r4.zzc()     // Catch:{ JSONException -> 0x0248 }
            r7 = 3
            com.google.android.gms.internal.fido.zzhk r7 = com.google.android.gms.internal.fido.zzhp.zzg(r7)     // Catch:{ JSONException -> 0x0248 }
            java.lang.Object r5 = r5.get(r7)     // Catch:{ JSONException -> 0x0248 }
            com.google.android.gms.internal.fido.zzhp r5 = (com.google.android.gms.internal.fido.zzhp) r5     // Catch:{ JSONException -> 0x0248 }
            com.google.android.gms.internal.fido.zzcj r7 = r4.zzc()     // Catch:{ JSONException -> 0x0248 }
            r8 = 1
            com.google.android.gms.internal.fido.zzhk r10 = com.google.android.gms.internal.fido.zzhp.zzg(r8)     // Catch:{ JSONException -> 0x0248 }
            java.lang.Object r7 = r7.get(r10)     // Catch:{ JSONException -> 0x0248 }
            com.google.android.gms.internal.fido.zzhp r7 = (com.google.android.gms.internal.fido.zzhp) r7     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r10 = "COSE key missing required fields"
            if (r5 == 0) goto L_0x020a
            if (r7 == 0) goto L_0x020a
            com.google.android.gms.internal.fido.zzhk r5 = r5.zzf()     // Catch:{ zzho -> 0x0201 }
            long r11 = r5.zzc()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhk r5 = r7.zzf()     // Catch:{ zzho -> 0x0201 }
            long r13 = r5.zzc()     // Catch:{ zzho -> 0x0201 }
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            r15 = 2
            if (r5 == 0) goto L_0x010f
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x010c
            r13 = r15
            goto L_0x010f
        L_0x010c:
            r7 = 0
            goto L_0x01dd
        L_0x010f:
            com.google.android.gms.internal.fido.zzcj r5 = r4.zzc()     // Catch:{ zzho -> 0x0201 }
            r17 = -1
            com.google.android.gms.internal.fido.zzhk r7 = com.google.android.gms.internal.fido.zzhp.zzg(r17)     // Catch:{ zzho -> 0x0201 }
            java.lang.Object r5 = r5.get(r7)     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhp r5 = (com.google.android.gms.internal.fido.zzhp) r5     // Catch:{ zzho -> 0x0201 }
            if (r5 == 0) goto L_0x01fb
            com.google.android.gms.internal.fido.zzhk r5 = r5.zzf()     // Catch:{ zzho -> 0x0201 }
            long r17 = r5.zzc()     // Catch:{ zzho -> 0x0201 }
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            java.lang.String r7 = "COSE coordinates are the wrong size"
            r15 = -2
            if (r5 != 0) goto L_0x0196
            int r5 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0196
            com.google.android.gms.internal.fido.zzcj r5 = r4.zzc()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhk r8 = com.google.android.gms.internal.fido.zzhp.zzg(r15)     // Catch:{ zzho -> 0x0201 }
            java.lang.Object r5 = r5.get(r8)     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhp r5 = (com.google.android.gms.internal.fido.zzhp) r5     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzcj r4 = r4.zzc()     // Catch:{ zzho -> 0x0201 }
            r8 = -3
            com.google.android.gms.internal.fido.zzhk r8 = com.google.android.gms.internal.fido.zzhp.zzg(r8)     // Catch:{ zzho -> 0x0201 }
            java.lang.Object r4 = r4.get(r8)     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhp r4 = (com.google.android.gms.internal.fido.zzhp) r4     // Catch:{ zzho -> 0x0201 }
            if (r5 == 0) goto L_0x0190
            if (r4 == 0) goto L_0x0190
            com.google.android.gms.internal.fido.zzhi r5 = r5.zze()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzgx r5 = r5.zzc()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhi r4 = r4.zze()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzgx r4 = r4.zzc()     // Catch:{ zzho -> 0x0201 }
            int r8 = r5.zzd()     // Catch:{ zzho -> 0x0201 }
            if (r8 != r6) goto L_0x018a
            int r8 = r4.zzd()     // Catch:{ zzho -> 0x0201 }
            if (r8 != r6) goto L_0x018a
            java.lang.String r6 = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE"
            byte[] r3 = android.util.Base64.decode(r6, r3)     // Catch:{ zzho -> 0x0201 }
            byte[] r5 = r5.zzm()     // Catch:{ zzho -> 0x0201 }
            byte[] r4 = r4.zzm()     // Catch:{ zzho -> 0x0201 }
            byte[][] r3 = new byte[][]{r3, r5, r4}     // Catch:{ zzho -> 0x0201 }
            byte[] r7 = com.google.android.gms.internal.fido.zzgj.zza(r3)     // Catch:{ zzho -> 0x0201 }
            goto L_0x01dd
        L_0x018a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzho -> 0x0201 }
            r0.<init>(r7)     // Catch:{ zzho -> 0x0201 }
            throw r0     // Catch:{ zzho -> 0x0201 }
        L_0x0190:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzho -> 0x0201 }
            r0.<init>(r10)     // Catch:{ zzho -> 0x0201 }
            throw r0     // Catch:{ zzho -> 0x0201 }
        L_0x0196:
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x010c
            r8 = 6
            int r5 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x010c
            com.google.android.gms.internal.fido.zzcj r4 = r4.zzc()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhk r5 = com.google.android.gms.internal.fido.zzhp.zzg(r15)     // Catch:{ zzho -> 0x0201 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzhp r4 = (com.google.android.gms.internal.fido.zzhp) r4     // Catch:{ zzho -> 0x0201 }
            if (r4 == 0) goto L_0x01d7
            com.google.android.gms.internal.fido.zzhi r4 = r4.zze()     // Catch:{ zzho -> 0x0201 }
            com.google.android.gms.internal.fido.zzgx r4 = r4.zzc()     // Catch:{ zzho -> 0x0201 }
            int r5 = r4.zzd()     // Catch:{ zzho -> 0x0201 }
            if (r5 != r6) goto L_0x01d1
            java.lang.String r5 = "MCowBQYDK2VwAyEA"
            byte[] r3 = android.util.Base64.decode(r5, r3)     // Catch:{ zzho -> 0x0201 }
            byte[] r4 = r4.zzm()     // Catch:{ zzho -> 0x0201 }
            byte[][] r3 = new byte[][]{r3, r4}     // Catch:{ zzho -> 0x0201 }
            byte[] r7 = com.google.android.gms.internal.fido.zzgj.zza(r3)     // Catch:{ zzho -> 0x0201 }
            goto L_0x01dd
        L_0x01d1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzho -> 0x0201 }
            r0.<init>(r7)     // Catch:{ zzho -> 0x0201 }
            throw r0     // Catch:{ zzho -> 0x0201 }
        L_0x01d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzho -> 0x0201 }
            r0.<init>(r10)     // Catch:{ zzho -> 0x0201 }
            throw r0     // Catch:{ zzho -> 0x0201 }
        L_0x01dd:
            java.lang.String r3 = "authenticatorData"
            byte[] r2 = r2.zzm()     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r2 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r2)     // Catch:{ JSONException -> 0x0248 }
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r2 = "publicKeyAlgorithm"
            r0.put(r2, r11)     // Catch:{ JSONException -> 0x0248 }
            if (r7 == 0) goto L_0x01fa
            java.lang.String r2 = "publicKey"
            java.lang.String r3 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafeNoPadding(r7)     // Catch:{ JSONException -> 0x0248 }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x0248 }
        L_0x01fa:
            return r0
        L_0x01fb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzho -> 0x0201 }
            r0.<init>(r10)     // Catch:{ zzho -> 0x0201 }
            throw r0     // Catch:{ zzho -> 0x0201 }
        L_0x0201:
            r0 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = "COSE key ill-formed"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0248 }
            throw r2     // Catch:{ JSONException -> 0x0248 }
        L_0x020a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0248 }
            r0.<init>(r10)     // Catch:{ JSONException -> 0x0248 }
            throw r0     // Catch:{ JSONException -> 0x0248 }
        L_0x0210:
            r0 = move-exception
            goto L_0x0213
        L_0x0212:
            r0 = move-exception
        L_0x0213:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = "failed to parse COSE key"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0248 }
            throw r2     // Catch:{ JSONException -> 0x0248 }
        L_0x021b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0223 }
            java.lang.String r2 = "authData does not include credential data"
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0223 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0223 }
        L_0x0223:
            r0 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = "ill-formed authenticator data"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0248 }
            throw r2     // Catch:{ JSONException -> 0x0248 }
        L_0x022c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ zzho -> 0x0234 }
            java.lang.String r2 = "attestation object missing authData"
            r0.<init>(r2)     // Catch:{ zzho -> 0x0234 }
            throw r0     // Catch:{ zzho -> 0x0234 }
        L_0x0234:
            r0 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = "authData value has wrong type"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0248 }
            throw r2     // Catch:{ JSONException -> 0x0248 }
        L_0x023d:
            r0 = move-exception
            goto L_0x0240
        L_0x023f:
            r0 = move-exception
        L_0x0240:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x0248 }
            java.lang.String r3 = "failed to parse attestation object"
            r2.<init>(r3, r0)     // Catch:{ JSONException -> 0x0248 }
            throw r2     // Catch:{ JSONException -> 0x0248 }
        L_0x0248:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error encoding AuthenticatorAttestationResponse to JSON object"
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse.zza():org.json.JSONObject");
    }
}
