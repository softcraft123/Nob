package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzd implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v10, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v11, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v12, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v13, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v14, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r17) {
        /*
            r16 = this;
            r0 = r17
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
        L_0x0013:
            int r2 = r0.dataPosition()
            if (r2 >= r1) goto L_0x00a2
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r0)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x0097;
                case 3: goto L_0x008c;
                case 4: goto L_0x0082;
                case 5: goto L_0x0078;
                case 6: goto L_0x006e;
                case 7: goto L_0x0064;
                case 8: goto L_0x005a;
                case 9: goto L_0x0050;
                case 10: goto L_0x0046;
                case 11: goto L_0x003c;
                case 12: goto L_0x0032;
                case 13: goto L_0x0028;
                default: goto L_0x0024;
            }
        L_0x0024:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0013
        L_0x0028:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzai> r3 = com.google.android.gms.fido.fido2.api.common.zzai.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r15 = r2
            com.google.android.gms.fido.fido2.api.common.zzai r15 = (com.google.android.gms.fido.fido2.api.common.zzai) r15
            goto L_0x0013
        L_0x0032:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzaw> r3 = com.google.android.gms.fido.fido2.api.common.zzaw.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            com.google.android.gms.fido.fido2.api.common.zzaw r14 = (com.google.android.gms.fido.fido2.api.common.zzaw) r14
            goto L_0x0013
        L_0x003c:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzak> r3 = com.google.android.gms.fido.fido2.api.common.zzak.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r13 = r2
            com.google.android.gms.fido.fido2.api.common.zzak r13 = (com.google.android.gms.fido.fido2.api.common.zzak) r13
            goto L_0x0013
        L_0x0046:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension> r3 = com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension r12 = (com.google.android.gms.fido.fido2.api.common.GoogleThirdPartyPaymentExtension) r12
            goto L_0x0013
        L_0x0050:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzag> r3 = com.google.android.gms.fido.fido2.api.common.zzag.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r11 = r2
            com.google.android.gms.fido.fido2.api.common.zzag r11 = (com.google.android.gms.fido.fido2.api.common.zzag) r11
            goto L_0x0013
        L_0x005a:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzu> r3 = com.google.android.gms.fido.fido2.api.common.zzu.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            com.google.android.gms.fido.fido2.api.common.zzu r10 = (com.google.android.gms.fido.fido2.api.common.zzu) r10
            goto L_0x0013
        L_0x0064:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzad> r3 = com.google.android.gms.fido.fido2.api.common.zzad.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r9 = r2
            com.google.android.gms.fido.fido2.api.common.zzad r9 = (com.google.android.gms.fido.fido2.api.common.zzad) r9
            goto L_0x0013
        L_0x006e:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzab> r3 = com.google.android.gms.fido.fido2.api.common.zzab.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r8 = r2
            com.google.android.gms.fido.fido2.api.common.zzab r8 = (com.google.android.gms.fido.fido2.api.common.zzab) r8
            goto L_0x0013
        L_0x0078:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzz> r3 = com.google.android.gms.fido.fido2.api.common.zzz.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r7 = r2
            com.google.android.gms.fido.fido2.api.common.zzz r7 = (com.google.android.gms.fido.fido2.api.common.zzz) r7
            goto L_0x0013
        L_0x0082:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension> r3 = com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r6 = r2
            com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension r6 = (com.google.android.gms.fido.fido2.api.common.UserVerificationMethodExtension) r6
            goto L_0x0013
        L_0x008c:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzs> r3 = com.google.android.gms.fido.fido2.api.common.zzs.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r5 = r2
            com.google.android.gms.fido.fido2.api.common.zzs r5 = (com.google.android.gms.fido.fido2.api.common.zzs) r5
            goto L_0x0013
        L_0x0097:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension> r3 = com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r4 = r2
            com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension r4 = (com.google.android.gms.fido.fido2.api.common.FidoAppIdExtension) r4
            goto L_0x0013
        L_0x00a2:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions r3 = new com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.zzd.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthenticationExtensions[i];
    }
}
