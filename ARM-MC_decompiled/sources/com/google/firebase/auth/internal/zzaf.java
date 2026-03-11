package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzan;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaf extends FirebaseUser {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzae();
    private zzahv zza;
    private zzab zzb;
    private String zzc;
    private String zzd;
    private List<zzab> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private zzah zzi;
    private boolean zzj;
    private zze zzk;
    private zzbj zzl;
    private List<zzan> zzm;

    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    public final zze zzh() {
        return this.zzk;
    }

    public static FirebaseUser zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzaf zzaf = new zzaf(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzaf) {
            zzaf zzaf2 = (zzaf) firebaseUser;
            zzaf.zzg = zzaf2.zzg;
            zzaf.zzd = zzaf2.zzd;
            zzaf.zzi = (zzah) zzaf2.getMetadata();
        } else {
            zzaf.zzi = null;
        }
        if (firebaseUser.zzc() != null) {
            zzaf.zza(firebaseUser.zzc());
        }
        if (!firebaseUser.isAnonymous()) {
            zzaf.zzb();
        }
        return zzaf;
    }

    public final /* synthetic */ FirebaseUser zzb() {
        this.zzh = false;
        return this;
    }

    public final synchronized FirebaseUser zza(List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzb = (zzab) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzab) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = this.zze.get(0);
        }
        return this;
    }

    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzaj(this);
    }

    public final zzahv zzc() {
        return this.zza;
    }

    public final zzaf zza(String str) {
        this.zzg = str;
        return this;
    }

    public final String zzd() {
        return zzc().zzc();
    }

    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    public final String getEmail() {
        return this.zzb.getEmail();
    }

    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    public final String zze() {
        return this.zza.zzf();
    }

    public final String getTenantId() {
        Map map;
        zzahv zzahv = this.zza;
        if (zzahv == null || zzahv.zzc() == null || (map = (Map) zzbi.zza(this.zza.zzc()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    public final String getUid() {
        return this.zzb.getUid();
    }

    public final List<MultiFactorInfo> zzi() {
        zzbj zzbj = this.zzl;
        if (zzbj != null) {
            return zzbj.zza();
        }
        return new ArrayList();
    }

    public final List<zzan> zzf() {
        return this.zzm;
    }

    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    public final List<String> zzg() {
        return this.zzf;
    }

    public final List<zzab> zzj() {
        return this.zze;
    }

    public zzaf(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = ExifInterface.GPS_MEASUREMENT_2D;
        zza(list);
    }

    zzaf(zzahv zzahv, zzab zzab, String str, String str2, List<zzab> list, List<String> list2, String str3, Boolean bool, zzah zzah, boolean z, zze zze2, zzbj zzbj, List<zzan> list3) {
        this.zza = zzahv;
        this.zzb = zzab;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzah;
        this.zzj = z;
        this.zzk = zze2;
        this.zzl = zzbj;
        this.zzm = list3;
    }

    public final void zza(zzahv zzahv) {
        this.zza = (zzahv) Preconditions.checkNotNull(zzahv);
    }

    public final void zza(zze zze2) {
        this.zzk = zze2;
    }

    public final void zzb(List<zzan> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.zzm = list;
    }

    public final void zza(boolean z) {
        this.zzj = z;
    }

    public final void zza(zzah zzah) {
        this.zzi = zzah;
    }

    public final void zzc(List<MultiFactorInfo> list) {
        this.zzl = zzbj.zza(list);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzc(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, zzg(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getMetadata(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeTypedList(parcel, 13, zzf(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean isAnonymous() {
        GetTokenResult zza2;
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzahv zzahv = this.zza;
            String str = "";
            if (!(zzahv == null || (zza2 = zzbi.zza(zzahv.zzc())) == null)) {
                str = zza2.getSignInProvider();
            }
            boolean z = true;
            if (getProviderData().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final boolean zzk() {
        return this.zzj;
    }
}
