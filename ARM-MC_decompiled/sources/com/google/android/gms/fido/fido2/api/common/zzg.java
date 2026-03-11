package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.fido.zzgx;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzg implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzgx zzgx;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzgx zzgx2 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                bArr = SafeParcelReader.createByteArray(parcel, readHeader);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        if (bArr == null) {
            zzgx = null;
        } else {
            zzgx = zzgx.zzl(bArr, 0, bArr.length);
        }
        if (bArr2 != null) {
            zzgx2 = zzgx.zzl(bArr2, 0, bArr2.length);
        }
        return new zzf(zzgx, zzgx2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }
}
