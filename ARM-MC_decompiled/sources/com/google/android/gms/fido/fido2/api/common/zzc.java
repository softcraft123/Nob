package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzc implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x000a:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0058
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r8 = 1
            if (r2 == r8) goto L_0x004e
            r8 = 2
            if (r2 == r8) goto L_0x0044
            r8 = 3
            if (r2 == r8) goto L_0x003a
            r8 = 4
            if (r2 == r8) goto L_0x0030
            r8 = 5
            if (r2 == r8) goto L_0x002b
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x000a
        L_0x002b:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r10, r1)
            goto L_0x000a
        L_0x0030:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzh> r2 = com.google.android.gms.fido.fido2.api.common.zzh.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r6 = r1
            com.google.android.gms.fido.fido2.api.common.zzh r6 = (com.google.android.gms.fido.fido2.api.common.zzh) r6
            goto L_0x000a
        L_0x003a:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsCredPropsOutputs> r2 = com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsCredPropsOutputs.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r5 = r1
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsCredPropsOutputs r5 = (com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsCredPropsOutputs) r5
            goto L_0x000a
        L_0x0044:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.zzf> r2 = com.google.android.gms.fido.fido2.api.common.zzf.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r4 = r1
            com.google.android.gms.fido.fido2.api.common.zzf r4 = (com.google.android.gms.fido.fido2.api.common.zzf) r4
            goto L_0x000a
        L_0x004e:
            android.os.Parcelable$Creator<com.google.android.gms.fido.fido2.api.common.UvmEntries> r2 = com.google.android.gms.fido.fido2.api.common.UvmEntries.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r2)
            r3 = r1
            com.google.android.gms.fido.fido2.api.common.UvmEntries r3 = (com.google.android.gms.fido.fido2.api.common.UvmEntries) r3
            goto L_0x000a
        L_0x0058:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs r2 = new com.google.android.gms.fido.fido2.api.common.AuthenticationExtensionsClientOutputs
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.zzc.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthenticationExtensionsClientOutputs[i];
    }
}
