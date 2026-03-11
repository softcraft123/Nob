package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzafb extends zzaft implements zzagn {
    private zzaev zza;
    private zzaey zzb;
    private zzafy zzc;
    private final zzafc zzd;
    private final FirebaseApp zze;
    private String zzf;
    private zzafe zzg;

    private final zzafe zzb() {
        if (this.zzg == null) {
            this.zzg = new zzafe(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    zzafb(FirebaseApp firebaseApp, zzafc zzafc) {
        this(firebaseApp, zzafc, (zzafy) null, (zzaev) null, (zzaey) null, (zzaew) null);
    }

    private zzafb(FirebaseApp firebaseApp, zzafc zzafc, zzafy zzafy, zzaev zzaev, zzaey zzaey, zzaew zzaew) {
        this.zze = firebaseApp;
        this.zzf = firebaseApp.getOptions().getApiKey();
        firebaseApp.getOptions().getProjectId();
        this.zzd = (zzafc) Preconditions.checkNotNull(zzafc);
        zza((zzafy) null, (zzaev) null, (zzaey) null, (zzaew) null);
        zzagl.zza(this.zzf, this);
    }

    public final void zza(zzags zzags, zzafv<zzagv> zzafv) {
        Preconditions.checkNotNull(zzags);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/createAuthUri", this.zzf), zzags, zzafv, zzagv.class, zzaev.zza);
    }

    public final void zza(zzagu zzagu, zzafv<Void> zzafv) {
        Preconditions.checkNotNull(zzagu);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/deleteAccount", this.zzf), zzagu, zzafv, Void.class, zzaev.zza);
    }

    public final void zza(zzagx zzagx, zzafv<zzagw> zzafv) {
        Preconditions.checkNotNull(zzagx);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/emailLinkSignin", this.zzf), zzagx, zzafv, zzagw.class, zzaev.zza);
    }

    public final void zza(zzagz zzagz, zzafv<zzagy> zzafv) {
        Preconditions.checkNotNull(zzagz);
        Preconditions.checkNotNull(zzafv);
        zzaey zzaey = this.zzb;
        zzaey.zza(zzaey.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzagz, zzafv, zzagy.class, zzaey.zza);
    }

    public final void zza(zzahb zzahb, zzafv<zzaha> zzafv) {
        Preconditions.checkNotNull(zzahb);
        Preconditions.checkNotNull(zzafv);
        zzaey zzaey = this.zzb;
        zzaey.zza(zzaey.zza("/accounts/mfaSignIn:finalize", this.zzf), zzahb, zzafv, zzaha.class, zzaey.zza);
    }

    public final void zza(zzahj zzahj, zzafv<zzahv> zzafv) {
        Preconditions.checkNotNull(zzahj);
        Preconditions.checkNotNull(zzafv);
        zzafy zzafy = this.zzc;
        zzafu.zza(zzafy.zza("/token", this.zzf), zzahj, zzafv, zzahv.class, zzafy.zza);
    }

    public final void zza(zzahi zzahi, zzafv<zzahl> zzafv) {
        Preconditions.checkNotNull(zzahi);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/getAccountInfo", this.zzf), zzahi, zzafv, zzahl.class, zzaev.zza);
    }

    public final void zza(zzahm zzahm, zzafv<zzahp> zzafv) {
        Preconditions.checkNotNull(zzahm);
        Preconditions.checkNotNull(zzafv);
        if (zzahm.zzb() != null) {
            zzb().zzb(zzahm.zzb().zze());
        }
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/getOobConfirmationCode", this.zzf), zzahm, zzafv, zzahp.class, zzaev.zza);
    }

    public final void zza(zzaho zzaho, zzafv<zzahr> zzafv) {
        Preconditions.checkNotNull(zzaho);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/getRecaptchaParam", this.zzf), zzafv, zzahr.class, zzaev.zza);
    }

    public final void zza(zzaht zzaht, zzafv<zzahs> zzafv) {
        Preconditions.checkNotNull(zzaht);
        Preconditions.checkNotNull(zzafv);
        zzaey zzaey = this.zzb;
        String str = zzaey.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzaht.zzb() + "&version=" + zzaht.zzc();
        if (!zzac.zzc(zzaht.zzd())) {
            str = str + "&tenantId=" + zzaht.zzd();
        }
        zzafu.zza(str, zzafv, zzahs.class, zzaey.zza);
    }

    public final void zza() {
        zza((zzafy) null, (zzaev) null, (zzaey) null, (zzaew) null);
    }

    public final void zza(zzaic zzaic, zzafv<zzaif> zzafv) {
        Preconditions.checkNotNull(zzaic);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/resetPassword", this.zzf), zzaic, zzafv, zzaif.class, zzaev.zza);
    }

    public final void zza(zzaie zzaie, zzafv<zzaig> zzafv) {
        Preconditions.checkNotNull(zzaie);
        Preconditions.checkNotNull(zzafv);
        zzaey zzaey = this.zzb;
        zzaey.zza(zzaey.zza("/accounts:revokeToken", this.zzf), zzaie, zzafv, zzaig.class, zzaey.zza);
    }

    public final void zza(zzaij zzaij, zzafv<zzaii> zzafv) {
        Preconditions.checkNotNull(zzaij);
        Preconditions.checkNotNull(zzafv);
        if (!TextUtils.isEmpty(zzaij.zzc())) {
            zzb().zzb(zzaij.zzc());
        }
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/sendVerificationCode", this.zzf), zzaij, zzafv, zzaii.class, zzaev.zza);
    }

    public final void zza(zzail zzail, zzafv<zzaik> zzafv) {
        Preconditions.checkNotNull(zzail);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/setAccountInfo", this.zzf), zzail, zzafv, zzaik.class, zzaev.zza);
    }

    public final void zza(String str, zzafv<Void> zzafv) {
        Preconditions.checkNotNull(zzafv);
        zzb().zza(str);
        zzafv.zza(null);
    }

    public final void zza(zzaim zzaim, zzafv<zzaip> zzafv) {
        Preconditions.checkNotNull(zzaim);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/signupNewUser", this.zzf), zzaim, zzafv, zzaip.class, zzaev.zza);
    }

    public final void zza(zzaio zzaio, zzafv<zzair> zzafv) {
        Preconditions.checkNotNull(zzaio);
        Preconditions.checkNotNull(zzafv);
        if (zzaio instanceof zzais) {
            zzais zzais = (zzais) zzaio;
            if (!TextUtils.isEmpty(zzais.zzb())) {
                zzb().zzb(zzais.zzb());
            }
        }
        zzaey zzaey = this.zzb;
        zzaey.zza(zzaey.zza("/accounts/mfaEnrollment:start", this.zzf), zzaio, zzafv, zzair.class, zzaey.zza);
    }

    public final void zza(zzaiq zzaiq, zzafv<zzait> zzafv) {
        Preconditions.checkNotNull(zzaiq);
        Preconditions.checkNotNull(zzafv);
        if (!TextUtils.isEmpty(zzaiq.zzb())) {
            zzb().zzb(zzaiq.zzb());
        }
        zzaey zzaey = this.zzb;
        zzaey.zza(zzaey.zza("/accounts/mfaSignIn:start", this.zzf), zzaiq, zzafv, zzait.class, zzaey.zza);
    }

    private final void zza(zzafy zzafy, zzaev zzaev, zzaey zzaey, zzaew zzaew) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String zza2 = zzagi.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzagl.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + zza2);
        }
        if (this.zzc == null) {
            this.zzc = new zzafy(zza2, zzb());
        }
        String zza3 = zzagi.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzagl.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + zza3);
        }
        if (this.zza == null) {
            this.zza = new zzaev(zza3, zzb());
        }
        String zza4 = zzagi.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzagl.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + zza4);
        }
        if (this.zzb == null) {
            this.zzb = new zzaey(zza4, zzb());
        }
    }

    public final void zza(zzajb zzajb, zzafv<zzajd> zzafv) {
        Preconditions.checkNotNull(zzajb);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/verifyAssertion", this.zzf), zzajb, zzafv, zzajd.class, zzaev.zza);
    }

    public final void zza(zzajc zzajc, zzafv<zzajf> zzafv) {
        Preconditions.checkNotNull(zzajc);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/verifyCustomToken", this.zzf), zzajc, zzafv, zzajf.class, zzaev.zza);
    }

    public final void zza(zzaje zzaje, zzafv<zzajh> zzafv) {
        Preconditions.checkNotNull(zzaje);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/verifyPassword", this.zzf), zzaje, zzafv, zzajh.class, zzaev.zza);
    }

    public final void zza(zzajg zzajg, zzafv<zzajj> zzafv) {
        Preconditions.checkNotNull(zzajg);
        Preconditions.checkNotNull(zzafv);
        zzaev zzaev = this.zza;
        zzafu.zza(zzaev.zza("/verifyPhoneNumber", this.zzf), zzajg, zzafv, zzajj.class, zzaev.zza);
    }

    public final void zza(zzaji zzaji, zzafv<zzajl> zzafv) {
        Preconditions.checkNotNull(zzaji);
        Preconditions.checkNotNull(zzafv);
        zzaey zzaey = this.zzb;
        zzaey.zza(zzaey.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzaji, zzafv, zzajl.class, zzaey.zza);
    }
}
