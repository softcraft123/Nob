package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzz implements AuthResult {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();
    private zzaf zza;
    private zzx zzb;
    private zze zzc;

    public final int describeContents() {
        return 0;
    }

    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    public final AuthCredential getCredential() {
        return this.zzc;
    }

    public final FirebaseUser getUser() {
        return this.zza;
    }

    public zzz(zzaf zzaf) {
        zzaf zzaf2 = (zzaf) Preconditions.checkNotNull(zzaf);
        this.zza = zzaf2;
        List<zzab> zzj = zzaf2.zzj();
        this.zzb = null;
        for (int i = 0; i < zzj.size(); i++) {
            if (!TextUtils.isEmpty(zzj.get(i).zza())) {
                this.zzb = new zzx(zzj.get(i).getProviderId(), zzj.get(i).zza(), zzaf.zzk());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzx(zzaf.zzk());
        }
        this.zzc = zzaf.zzh();
    }

    zzz(zzaf zzaf, zzx zzx, zze zze) {
        this.zza = zzaf;
        this.zzb = zzx;
        this.zzc = zze;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
