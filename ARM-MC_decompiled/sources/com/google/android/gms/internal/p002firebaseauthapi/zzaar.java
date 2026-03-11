package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaar  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaar {
    /* access modifiers changed from: private */
    public final zzaft zza;

    static /* synthetic */ void zza(zzaar zzaar, zzajd zzajd, zzael zzael, zzafs zzafs) {
        Status status;
        if (zzajd.zzo()) {
            zze zzb = zzajd.zzb();
            String zzc = zzajd.zzc();
            String zzj = zzajd.zzj();
            if (zzajd.zzm()) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                status = zzao.zza(zzajd.zzd());
            }
            zzael.zza(new zzaap(status, zzb, zzc, zzj));
            return;
        }
        zzaar.zza(new zzahv(zzajd.zzi(), zzajd.zze(), Long.valueOf(zzajd.zza()), "Bearer"), zzajd.zzh(), zzajd.zzg(), Boolean.valueOf(zzajd.zzn()), zzajd.zzb(), zzael, zzafs);
    }

    static /* synthetic */ void zza(zzaar zzaar, zzael zzael, zzaim zzaim, zzafs zzafs) {
        Preconditions.checkNotNull(zzael);
        Preconditions.checkNotNull(zzaim);
        Preconditions.checkNotNull(zzafs);
        zzaar.zza.zza(zzaim, (zzafv<zzaip>) new zzabk(zzaar, zzael, zzafs));
    }

    static /* synthetic */ void zza(zzaar zzaar, zzael zzael, zzahv zzahv, zzail zzail, zzafs zzafs) {
        Preconditions.checkNotNull(zzael);
        Preconditions.checkNotNull(zzahv);
        Preconditions.checkNotNull(zzail);
        Preconditions.checkNotNull(zzafs);
        zzaar.zza.zza(new zzahi(zzahv.zzc()), (zzafv<zzahl>) new zzaax(zzaar, zzafs, zzael, zzahv, zzail));
    }

    static /* synthetic */ void zza(zzaar zzaar, zzael zzael, zzahv zzahv, zzahk zzahk, zzail zzail, zzafs zzafs) {
        Preconditions.checkNotNull(zzael);
        Preconditions.checkNotNull(zzahv);
        Preconditions.checkNotNull(zzahk);
        Preconditions.checkNotNull(zzail);
        Preconditions.checkNotNull(zzafs);
        zzail zzail2 = zzail;
        zzaar.zza.zza(zzail2, (zzafv<zzaik>) new zzaba(zzaar, zzail2, zzahk, zzael, zzahv, zzafs));
    }

    public zzaar(zzaft zzaft) {
        this.zza = (zzaft) Preconditions.checkNotNull(zzaft);
    }

    public final void zza(String str, String str2, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        zzail zzail = new zzail();
        zzail.zze(str);
        zzail.zzh(str2);
        this.zza.zza(zzail, (zzafv<zzaik>) new zzacl(this, zzael));
    }

    public final void zzb(String str, String str2, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzacj(this, str2, zzael));
    }

    public final void zzc(String str, String str2, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzacm(this, str2, zzael));
    }

    public final void zzd(String str, String str2, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(new zzaic(str, (String) null, str2), (zzafv<zzaif>) new zzabe(this, zzael));
    }

    public final void zza(zzaic zzaic, zzael zzael) {
        Preconditions.checkNotEmpty(zzaic.zzb());
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzaic, (zzafv<zzaif>) new zzabg(this, zzael));
    }

    public final void zza(String str, String str2, String str3, String str4, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(new zzaim(str, str2, (String) null, str3, str4, (String) null), (zzafv<zzaip>) new zzaat(this, zzael));
    }

    public final void zza(String str, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzace(this, zzael));
    }

    private final void zza(String str, zzafv<zzahv> zzafv) {
        Preconditions.checkNotNull(zzafv);
        Preconditions.checkNotEmpty(str);
        zzahv zzb = zzahv.zzb(str);
        if (zzb.zzg()) {
            zzafv.zza(zzb);
            return;
        }
        this.zza.zza(new zzahj(zzb.zzd()), (zzafv<zzahv>) new zzaco(this, zzafv));
    }

    public final void zza(zzagz zzagz, String str, zzael zzael) {
        Preconditions.checkNotNull(zzagz);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzabw(this, zzagz, zzael));
    }

    public final void zza(zzahb zzahb, zzael zzael) {
        Preconditions.checkNotNull(zzahb);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzahb, (zzafv<zzaha>) new zzaby(this, zzael));
    }

    /* access modifiers changed from: private */
    public final void zza(zzagx zzagx, zzael zzael) {
        Preconditions.checkNotNull(zzagx);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzagx, (zzafv<zzagw>) new zzaay(this, zzael));
    }

    public final void zzb(String str, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(new zzahj(str), (zzafv<zzahv>) new zzaau(this, zzael));
    }

    /* access modifiers changed from: private */
    public final void zza(zzahv zzahv, String str, String str2, Boolean bool, zze zze, zzael zzael, zzafs zzafs) {
        Preconditions.checkNotNull(zzahv);
        Preconditions.checkNotNull(zzafs);
        Preconditions.checkNotNull(zzael);
        String str3 = str2;
        zzafs zzafs2 = zzafs;
        this.zza.zza(new zzahi(zzahv.zzc()), (zzafv<zzahl>) new zzaaz(this, zzafs2, str3, str, bool, zze, zzael, zzahv));
    }

    private final void zzd(zzahm zzahm, zzael zzael) {
        Preconditions.checkNotNull(zzahm);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzahm, (zzafv<zzahp>) new zzacf(this, zzael));
    }

    public final void zza(zzaho zzaho, zzael zzael) {
        Preconditions.checkNotNull(zzaho);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzaho, (zzafv<zzahr>) new zzabz(this, zzael));
    }

    public final void zze(String str, String str2, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(new zzags(str, str2), (zzafv<zzagv>) new zzabc(this, zzael));
    }

    public final void zza(zzaht zzaht, zzael zzael) {
        Preconditions.checkNotNull(zzaht);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzaht, (zzafv<zzahs>) new zzaca(this, zzael));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzael);
        zza(str3, (zzafv<zzahv>) new zzabh(this, str, str2, str4, str5, zzael));
    }

    public final void zza(String str, zzajb zzajb, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajb);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzabl(this, zzajb, zzael));
    }

    public final void zza(String str, zzajg zzajg, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajg);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzabj(this, zzajg, zzael));
    }

    public final void zzc(String str, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzacc(this, zzael));
    }

    public final void zza(zzaie zzaie, zzael zzael) {
        this.zza.zza(zzaie, (zzafv<zzaig>) new zzach(this, zzael));
    }

    public final void zza(zzahm zzahm, zzael zzael) {
        Preconditions.checkNotEmpty(zzahm.zzd());
        Preconditions.checkNotNull(zzael);
        zzd(zzahm, zzael);
    }

    public final void zzb(zzahm zzahm, zzael zzael) {
        Preconditions.checkNotEmpty(zzahm.zzc());
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzahm, (zzafv<zzahp>) new zzabb(this, zzael));
    }

    public final void zza(zzaij zzaij, zzael zzael) {
        Preconditions.checkNotEmpty(zzaij.zzd());
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzaij, (zzafv<zzaii>) new zzabf(this, zzael));
    }

    public final void zzd(String str, zzael zzael) {
        Preconditions.checkNotNull(zzael);
        this.zza.zza(str, (zzafv<Void>) new zzacg(this, zzael));
    }

    public final void zze(String str, zzael zzael) {
        Preconditions.checkNotNull(zzael);
        this.zza.zza(new zzaim(str), (zzafv<zzaip>) new zzaci(this, zzael));
    }

    public final void zza(zzajb zzajb, zzael zzael) {
        Preconditions.checkNotNull(zzajb);
        Preconditions.checkNotNull(zzael);
        zzajb.zzb(true);
        this.zza.zza(zzajb, (zzafv<zzajd>) new zzabu(this, zzael));
    }

    public final void zza(zzajc zzajc, zzael zzael) {
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzajc, (zzafv<zzajf>) new zzabd(this, zzael));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(new zzaje(str, str2, str3, str4), (zzafv<zzajh>) new zzaaw(this, zzael));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, String str, zzael zzael) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzael);
        if (emailAuthCredential.zzg()) {
            zza(emailAuthCredential.zzb(), (zzafv<zzahv>) new zzaav(this, emailAuthCredential, str, zzael));
        } else {
            zza(new zzagx(emailAuthCredential, (String) null, str), zzael);
        }
    }

    public final void zza(zzajg zzajg, zzael zzael) {
        Preconditions.checkNotNull(zzajg);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzajg, (zzafv<zzajj>) new zzabi(this, zzael));
    }

    public final void zza(zzaio zzaio, zzael zzael) {
        Preconditions.checkNotNull(zzaio);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzaio, (zzafv<zzair>) new zzabt(this, zzaio, zzael));
    }

    public final void zza(zzaiq zzaiq, zzael zzael) {
        Preconditions.checkNotNull(zzaiq);
        Preconditions.checkNotNull(zzael);
        this.zza.zza(zzaiq, (zzafv<zzait>) new zzabx(this, zzael));
    }

    public final void zza(String str, String str2, String str3, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzabs(this, str2, str3, zzael));
    }

    public final void zzf(String str, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzabn(this, zzael));
    }

    public final void zzf(String str, String str2, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzael);
        zza(str2, (zzafv<zzahv>) new zzabq(this, str, zzael));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzael zzael) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzael);
        zza(str, (zzafv<zzahv>) new zzack(this, userProfileChangeRequest, zzael));
    }

    public final void zzc(zzahm zzahm, zzael zzael) {
        zzd(zzahm, zzael);
    }
}
