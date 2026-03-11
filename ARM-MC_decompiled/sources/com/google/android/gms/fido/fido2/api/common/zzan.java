package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzan implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r0)
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
        L_0x0015:
            int r2 = r0.dataPosition()
            if (r2 >= r1) goto L_0x008e
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r0)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x0084;
                case 3: goto L_0x007a;
                case 4: goto L_0x0075;
                case 5: goto L_0x006e;
                case 6: goto L_0x0069;
                case 7: goto L_0x0062;
                case 8: goto L_0x0058;
                case 9: goto L_0x0053;
                case 10: goto L_0x0049;
                case 11: goto L_0x0044;
                case 12: goto L_0x003a;
                case 13: goto L_0x0035;
                case 14: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0015
        L_0x002a:
            android.os.Parcelable$Creator r3 = android.os.ResultReceiver.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r16 = r2
            android.os.ResultReceiver r16 = (android.os.ResultReceiver) r16
            goto L_0x0015
        L_0x0035:
            java.lang.String r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x003a:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions> r3 = com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions r14 = (com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions) r14
            goto L_0x0015
        L_0x0044:
            java.lang.String r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x0049:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.TokenBinding> r3 = com.google.android.gms.fido.fido2.api.common.TokenBinding.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.fido.fido2.api.common.TokenBinding r12 = (com.google.android.gms.fido.fido2.api.common.TokenBinding) r12
            goto L_0x0015
        L_0x0053:
            java.lang.Integer r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIntegerObject(r0, r2)
            goto L_0x0015
        L_0x0058:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria> r3 = com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria r10 = (com.google.android.gms.fido.fido2.api.common.AuthenticatorSelectionCriteria) r10
            goto L_0x0015
        L_0x0062:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor> r3 = com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialDescriptor.CREATOR
            java.util.ArrayList r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0015
        L_0x0069:
            java.lang.Double r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDoubleObject(r0, r2)
            goto L_0x0015
        L_0x006e:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters> r3 = com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialParameters.CREATOR
            java.util.ArrayList r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0015
        L_0x0075:
            byte[] r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r0, r2)
            goto L_0x0015
        L_0x007a:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity> r3 = com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r5 = r2
            com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity r5 = (com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialUserEntity) r5
            goto L_0x0015
        L_0x0084:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity> r3 = com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r4 = r2
            com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity r4 = (com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRpEntity) r4
            goto L_0x0015
        L_0x008e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions r3 = new com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.zzan.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PublicKeyCredentialCreationOptions[i];
    }
}
