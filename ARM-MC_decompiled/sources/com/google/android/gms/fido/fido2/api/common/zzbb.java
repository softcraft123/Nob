package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzbb implements Parcelable.Creator {
    zzbb() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return UserVerificationRequirement.fromString(parcel.readString());
        } catch (zzbc e) {
            throw new RuntimeException(e);
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new UserVerificationRequirement[i];
    }
}
