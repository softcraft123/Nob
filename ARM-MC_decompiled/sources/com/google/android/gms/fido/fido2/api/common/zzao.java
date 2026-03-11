package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzao implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x000e:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0064
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x005f;
                case 2: goto L_0x005a;
                case 3: goto L_0x0055;
                case 4: goto L_0x004b;
                case 5: goto L_0x0041;
                case 6: goto L_0x0037;
                case 7: goto L_0x002d;
                case 8: goto L_0x0028;
                case 9: goto L_0x0023;
                default: goto L_0x001f;
            }
        L_0x001f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000e
        L_0x0023:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x0028:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs> r2 = com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r9 = r1
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs r9 = (com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs) r9
            goto L_0x000e
        L_0x0037:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse> r2 = com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r8 = r1
            com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse r8 = (com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse) r8
            goto L_0x000e
        L_0x0041:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse> r2 = com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r7 = r1
            com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse r7 = (com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse) r7
            goto L_0x000e
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse> r2 = com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r2)
            r6 = r1
            com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse r6 = (com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse) r6
            goto L_0x000e
        L_0x0055:
            byte[] r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r13, r1)
            goto L_0x000e
        L_0x005a:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x005f:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000e
        L_0x0064:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.fido.fido2.api.common.PublicKeyCredential r2 = new com.google.android.gms.fido.fido2.api.common.PublicKeyCredential
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (byte[]) r5, (com.google.android.gms.fido.fido2.api.common.AuthenticatorAttestationResponse) r6, (com.google.android.gms.fido.fido2.api.common.AuthenticatorAssertionResponse) r7, (com.google.android.gms.fido.fido2.api.common.AuthenticatorErrorResponse) r8, (com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs) r9, (java.lang.String) r10, (java.lang.String) r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.zzao.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PublicKeyCredential[i];
    }
}
