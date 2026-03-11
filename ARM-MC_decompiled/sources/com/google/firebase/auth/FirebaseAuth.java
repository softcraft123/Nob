package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzacq;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeu;
import com.google.android.gms.internal.p002firebaseauthapi.zzafd;
import com.google.android.gms.internal.p002firebaseauthapi.zzagb;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahr;
import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.android.gms.internal.p002firebaseauthapi.zzaij;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzac;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbl;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzca;
import com.google.firebase.auth.internal.zzcb;
import com.google.firebase.auth.internal.zzcf;
import com.google.firebase.auth.internal.zzcg;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class FirebaseAuth implements InternalAuthProvider {
    protected final List<IdTokenListener> zza;
    private final Executor zzaa;
    private String zzab;
    protected final List<AuthStateListener> zzb;
    protected final List<com.google.firebase.auth.internal.IdTokenListener> zzc;
    protected final zzacq zzd;
    protected final Executor zze;
    /* access modifiers changed from: private */
    public final FirebaseApp zzf;
    /* access modifiers changed from: private */
    public FirebaseUser zzg;
    /* access modifiers changed from: private */
    public final zzac zzh;
    private final Object zzi;
    /* access modifiers changed from: private */
    public String zzj;
    private final Object zzk;
    /* access modifiers changed from: private */
    public String zzl;
    private zzbx zzm;
    private final RecaptchaAction zzn;
    private final RecaptchaAction zzo;
    private final RecaptchaAction zzp;
    private final RecaptchaAction zzq;
    private final RecaptchaAction zzr;
    private final RecaptchaAction zzs;
    private final zzcb zzt;
    private final zzcg zzu;
    private final com.google.firebase.auth.internal.zzb zzv;
    private final Provider<InteropAppCheckTokenProvider> zzw;
    private final Provider<HeartBeatController> zzx;
    private zzca zzy;
    private final Executor zzz;

    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    class zza implements zzl {
        private final /* synthetic */ FirebaseAuth zza;

        zza(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.zza = firebaseAuth;
        }

        public final void zza(zzahv zzahv, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzahv);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzahv);
            this.zza.zza(firebaseUser, zzahv, true);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    class zzb implements zzau, zzl {
        private final /* synthetic */ FirebaseAuth zza;

        zzb(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.zza = firebaseAuth;
        }

        public final void zza(zzahv zzahv, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzahv);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzahv);
            this.zza.zza(firebaseUser, zzahv, true, true);
        }

        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
                this.zza.signOut();
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    class zzc extends zza implements zzau, zzl {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        zzc(FirebaseAuth firebaseAuth) {
            super(firebaseAuth);
            Objects.requireNonNull(firebaseAuth);
        }

        public final void zza(Status status) {
        }
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zza(this.zzf, str, this.zzl);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzb(this.zzf, str, this.zzl);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzd.zza(this.zzf, str, str2, this.zzl);
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzn(this, str, str2).zza(this, this.zzl, this.zzp, "EMAIL_PASSWORD_PROVIDER");
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzd.zza(this.zzf, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, (zzl) new zza(this));
        }
        FirebaseUser firebaseUser2 = firebaseUser;
        String str2 = str;
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zzd.zza(this.zzf, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser2, str2, this.zzl, (zzl) new zza(this));
        }
        return Tasks.forException(zzaen.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    @Deprecated
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzc(this.zzf, str, this.zzl);
    }

    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzg, z);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.zzx, com.google.firebase.auth.internal.zzcf] */
    public final Task<GetTokenResult> zza(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaen.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzahv zzc2 = firebaseUser.zzc();
        if (!zzc2.zzg() || z) {
            return this.zzd.zza(this.zzf, firebaseUser, zzc2.zzd(), (zzcf) new zzx(this));
        }
        return Tasks.forResult(zzbi.zza(zzc2.zzc()));
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzu.zza();
    }

    public final Task<zzahr> zza() {
        return this.zzd.zza();
    }

    public final Task<zzahs> zza(String str) {
        return this.zzd.zza(this.zzl, str);
    }

    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzm == null) {
            this.zzm = new zzbx(this.zzf, this);
        }
        return this.zzm.zza(this.zzl, false).continueWithTask(new zzaa(this));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<AuthResult> zza(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        if (authCredential instanceof EmailAuthCredential) {
            return new zzo(this, firebaseUser, (EmailAuthCredential) authCredential.zza()).zza(this, firebaseUser.getTenantId(), this.zzp, "EMAIL_PASSWORD_PROVIDER");
        }
        return this.zzd.zza(this.zzf, firebaseUser, authCredential.zza(), (String) null, (zzcf) new zzb(this));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r9v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zzb(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(firebaseUser, emailAuthCredential, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaen.zza(new Status(17072)));
            }
            return zza(firebaseUser, emailAuthCredential, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzd.zza(this.zzf, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, (zzcf) new zzb(this));
        } else {
            FirebaseUser firebaseUser2 = firebaseUser;
            return this.zzd.zzb(this.zzf, firebaseUser2, zza2, firebaseUser2.getTenantId(), (zzcf) new zzb(this));
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r5v1, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<AuthResult> zzc(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zza(emailAuthCredential.zzc(), Preconditions.checkNotEmpty(emailAuthCredential.zzd()), firebaseUser.getTenantId(), firebaseUser, true);
            }
            FirebaseUser firebaseUser2 = firebaseUser;
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaen.zza(new Status(17072)));
            }
            return zza(emailAuthCredential, firebaseUser2, true);
        }
        FirebaseUser firebaseUser3 = firebaseUser;
        if (zza2 instanceof PhoneAuthCredential) {
            return this.zzd.zzb(this.zzf, firebaseUser3, (PhoneAuthCredential) zza2, this.zzl, (zzcf) new zzb(this));
        }
        return this.zzd.zzc(this.zzf, firebaseUser3, zza2, firebaseUser3.getTenantId(), new zzb(this));
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, zzcf zzcf) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzd.zza(this.zzf, firebaseUser, zzcf);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zza(FirebaseUser firebaseUser) {
        return zza(firebaseUser, (zzcf) new zzb(this));
    }

    public final Task<AuthResult> zza(MultiFactorAssertion multiFactorAssertion, zzam zzam, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzam);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzd.zza(this.zzf, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzam.zzc()), (zzl) new zza(this));
        }
        FirebaseUser firebaseUser2 = firebaseUser;
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zzd.zza(this.zzf, firebaseUser2, (TotpMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzam.zzc()), this.zzl, (zzl) new zza(this));
        }
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    public Task<Void> revokeAccessToken(String str) {
        Preconditions.checkNotEmpty(str);
        FirebaseUser currentUser = getCurrentUser();
        Preconditions.checkNotNull(currentUser);
        return currentUser.getIdToken(false).continueWithTask(new zzw(this, str));
    }

    public final Task<Void> zza(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzj != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zza(this.zzj);
        }
        return this.zzd.zza(this.zzf, actionCodeSettings, str);
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzj;
        if (str2 != null) {
            actionCodeSettings.zza(str2);
        }
        actionCodeSettings.zza(1);
        return new zzq(this, str, actionCodeSettings).zza(this, this.zzl, this.zzn, "EMAIL_PASSWORD_PROVIDER");
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzj;
            if (str2 != null) {
                actionCodeSettings.zza(str2);
            }
            return new zzp(this, str, actionCodeSettings).zza(this, this.zzl, this.zzn, "EMAIL_PASSWORD_PROVIDER");
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zzd.zza(str);
    }

    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zzd.zza(this.zzf, (zzl) new zza(this), this.zzl);
        }
        zzaf zzaf = (zzaf) this.zzg;
        zzaf.zza(false);
        return Tasks.forResult(new zzz(zzaf));
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzf()) {
                return zza(emailAuthCredential.zzc(), (String) Preconditions.checkNotNull(emailAuthCredential.zzd()), this.zzl, (FirebaseUser) null, false);
            }
            if (zzb(Preconditions.checkNotEmpty(emailAuthCredential.zze()))) {
                return Tasks.forException(zzaen.zza(new Status(17072)));
            }
            return zza(emailAuthCredential, (FirebaseUser) null, false);
        }
        if (!(zza2 instanceof PhoneAuthCredential)) {
            return this.zzd.zza(this.zzf, zza2, this.zzl, (zzl) new zza(this));
        }
        return this.zzd.zza(this.zzf, (PhoneAuthCredential) zza2, this.zzl, (zzl) new zza(this));
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zza(this.zzf, str, this.zzl, (zzl) new zza(this));
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return zza(str, str2, this.zzl, (FirebaseUser) null, false);
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public final Task<AuthResult> zza(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzu.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaen.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<AuthResult> zzb(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzu.zza(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaen.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public Task<AuthResult> startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzu.zza(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaen.zza(new Status(17057)));
        }
        zzbl.zza(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    public final Task<TotpSecret> zza(zzam zzam) {
        Preconditions.checkNotNull(zzam);
        return this.zzd.zza(zzam, this.zzl).continueWithTask(new zzt(this));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zza(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzd.zza(this.zzf, firebaseUser, str, this.zzl, (zzcf) new zzb(this)).continueWithTask(new zzs(this));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<AuthResult> zzb(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzd.zzb(this.zzf, firebaseUser, str, new zzb(this));
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzc] */
    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.zzl)) || ((str = this.zzl) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzaen.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.zzf.getOptions().getApiKey();
            if (!firebaseUser.zzc().zzg() || !apiKey2.equals(apiKey)) {
                return zza(firebaseUser, (zzcf) new zzc(this));
            }
            zza(zzaf.zza(this.zzf, firebaseUser), firebaseUser.zzc(), true);
            return Tasks.forResult(null);
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zzc(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzc(this.zzf, firebaseUser, str, new zzb(this));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zzd(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzd(this.zzf, firebaseUser, str, new zzb(this));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zza(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzd.zza(this.zzf, firebaseUser, (PhoneAuthCredential) phoneAuthCredential.zza(), (zzcf) new zzb(this));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zza(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzd.zza(this.zzf, firebaseUser, userProfileChangeRequest, (zzcf) new zzb(this));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzj;
        if (str3 != null) {
            actionCodeSettings.zza(str3);
        }
        return this.zzd.zza(str, str2, actionCodeSettings);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzd.zzd(this.zzf, str, this.zzl);
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z) {
        return new zzab(this, z, firebaseUser, emailAuthCredential).zza(this, this.zzl, z ? this.zzn : this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z) {
        String str4 = str3;
        return new zzz(this, str, z, firebaseUser, str2, str4).zza(this, str4, this.zzo, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task<AuthResult> zza(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z) {
        return new zzac(this, z, firebaseUser, emailAuthCredential).zza(this, this.zzl, this.zzn, "EMAIL_PASSWORD_PROVIDER");
    }

    public FirebaseApp getApp() {
        return this.zzf;
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzh;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzj zzj2) {
        if (phoneAuthOptions.zzj()) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzl(this, phoneAuthOptions, zzj2, onVerificationStateChangedCallbacks);
    }

    /* access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (!this.zzh.zzd() || str == null || !str.equals(this.zzh.zza())) ? onVerificationStateChangedCallbacks : new zzm(this, onVerificationStateChangedCallbacks);
    }

    public final synchronized zzbx zzb() {
        return this.zzm;
    }

    private final synchronized zzca zzi() {
        return zzf(this);
    }

    private static zzca zzf(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzy == null) {
            firebaseAuth.zzy = new zzca((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zzf));
        }
        return firebaseAuth.zzy;
    }

    public final Provider<InteropAppCheckTokenProvider> zzc() {
        return this.zzw;
    }

    public final Provider<HeartBeatController> zzd() {
        return this.zzx;
    }

    public String getCustomAuthDomain() {
        return this.zzab;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzi) {
            str = this.zzj;
        }
        return str;
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzk) {
            str = this.zzl;
        }
        return str;
    }

    public String getUid() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public final Executor zze() {
        return this.zzz;
    }

    public final Executor zzf() {
        return this.zzaa;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FirebaseAuth(com.google.firebase.FirebaseApp r13, com.google.firebase.inject.Provider<com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider> r14, com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatController> r15, java.util.concurrent.Executor r16, java.util.concurrent.Executor r17, java.util.concurrent.Executor r18, java.util.concurrent.ScheduledExecutorService r19, java.util.concurrent.Executor r20) {
        /*
            r12 = this;
            com.google.android.gms.internal.firebase-auth-api.zzacq r2 = new com.google.android.gms.internal.firebase-auth-api.zzacq
            r9 = r17
            r0 = r19
            r2.<init>(r13, r9, r0)
            com.google.firebase.auth.internal.zzcb r3 = new com.google.firebase.auth.internal.zzcb
            android.content.Context r0 = r13.getApplicationContext()
            java.lang.String r1 = r13.getPersistenceKey()
            r3.<init>(r0, r1)
            com.google.firebase.auth.internal.zzcg r4 = com.google.firebase.auth.internal.zzcg.zzc()
            com.google.firebase.auth.internal.zzb r5 = com.google.firebase.auth.internal.zzb.zza()
            r0 = r12
            r1 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r10 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.<init>(com.google.firebase.FirebaseApp, com.google.firebase.inject.Provider, com.google.firebase.inject.Provider, java.util.concurrent.Executor, java.util.concurrent.Executor, java.util.concurrent.Executor, java.util.concurrent.ScheduledExecutorService, java.util.concurrent.Executor):void");
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzacq zzacq, zzcb zzcb, zzcg zzcg, com.google.firebase.auth.internal.zzb zzb2, Provider<InteropAppCheckTokenProvider> provider, Provider<HeartBeatController> provider2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzahv zza2;
        this.zza = new CopyOnWriteArrayList();
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzi = new Object();
        this.zzk = new Object();
        this.zzn = RecaptchaAction.custom("getOobCode");
        this.zzo = RecaptchaAction.custom("signInWithPassword");
        this.zzp = RecaptchaAction.custom("signUpPassword");
        this.zzq = RecaptchaAction.custom("sendVerificationCode");
        this.zzr = RecaptchaAction.custom("mfaSmsEnrollment");
        this.zzs = RecaptchaAction.custom("mfaSmsSignIn");
        this.zzf = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzd = (zzacq) Preconditions.checkNotNull(zzacq);
        zzcb zzcb2 = (zzcb) Preconditions.checkNotNull(zzcb);
        this.zzt = zzcb2;
        this.zzh = new zzac();
        zzcg zzcg2 = (zzcg) Preconditions.checkNotNull(zzcg);
        this.zzu = zzcg2;
        this.zzv = (com.google.firebase.auth.internal.zzb) Preconditions.checkNotNull(zzb2);
        this.zzw = provider;
        this.zzx = provider2;
        this.zzz = executor2;
        this.zzaa = executor3;
        this.zze = executor4;
        FirebaseUser zza3 = zzcb2.zza();
        this.zzg = zza3;
        if (!(zza3 == null || (zza2 = zzcb2.zza(zza3)) == null)) {
            zza(this, this.zzg, zza2, false, false);
        }
        zzcg2.zza(this);
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzb.add(authStateListener);
        this.zze.execute(new zzu(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zza.add(idTokenListener);
        this.zze.execute(new zzh(this, idTokenListener));
    }

    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzi().zza(this.zzc.size());
    }

    public final void zzg() {
        Preconditions.checkNotNull(this.zzt);
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser != null) {
            this.zzt.zzb(firebaseUser);
            this.zzg = null;
        }
        this.zzt.zzb();
        zzb(this, (FirebaseUser) null);
        zza(this, (FirebaseUser) null);
    }

    public static void zza(FirebaseException firebaseException, PhoneAuthOptions phoneAuthOptions, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        phoneAuthOptions.zzi().execute(new zzi(zzagb.zza(str, phoneAuthOptions.zze(), (zzaff) null), firebaseException));
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzb.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zza.remove(idTokenListener);
    }

    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzi().zza(this.zzc.size());
    }

    public void setCustomAuthDomain(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.startsWith("chrome-extension://")) {
            this.zzab = str;
            return;
        }
        try {
            this.zzab = (String) Preconditions.checkNotNull(new URI(str.contains("://") ? str : "http://" + str).getHost());
        } catch (URISyntaxException e) {
            if (Log.isLoggable("FirebaseAuth", 4)) {
                Log.i("FirebaseAuth", "Error parsing URL: '" + str + "', " + e.getMessage());
            }
            this.zzab = str;
        }
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzi) {
            this.zzj = str;
        }
    }

    public final synchronized void zza(zzbx zzbx) {
        this.zzm = zzbx;
    }

    public void setTenantId(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzk) {
            this.zzl = str;
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzahv zzahv, boolean z) {
        zza(firebaseUser, zzahv, true, false);
    }

    /* access modifiers changed from: package-private */
    public final void zza(FirebaseUser firebaseUser, zzahv zzahv, boolean z, boolean z2) {
        zza(this, firebaseUser, zzahv, true, z2);
    }

    public void signOut() {
        zzg();
        zzca zzca = this.zzy;
        if (zzca != null) {
            zzca.zza();
        }
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying auth state listeners about user ( " + firebaseUser.getUid() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.zze.execute(new zzy(firebaseAuth));
    }

    private static void zzb(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + firebaseUser.getUid() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        firebaseAuth.zze.execute(new zzv(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzd() : null)));
    }

    private static void zza(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzahv zzahv, boolean z, boolean z2) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzahv);
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = firebaseAuth.zzg != null && firebaseUser.getUid().equals(firebaseAuth.zzg.getUid());
        if (z5 || !z2) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzg;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z6 = !z5 || !firebaseUser2.zzc().zzc().equals(zzahv.zzc());
                if (!z5) {
                    z3 = true;
                }
                z4 = z6;
            }
            Preconditions.checkNotNull(firebaseUser);
            if (firebaseAuth.zzg == null || !firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzg = firebaseUser;
            } else {
                firebaseAuth.zzg.zza(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzg.zzb();
                }
                List<MultiFactorInfo> enrolledFactors = firebaseUser.getMultiFactor().getEnrolledFactors();
                List<zzan> zzf2 = firebaseUser.zzf();
                firebaseAuth.zzg.zzc(enrolledFactors);
                firebaseAuth.zzg.zzb(zzf2);
            }
            if (z) {
                firebaseAuth.zzt.zzc(firebaseAuth.zzg);
            }
            if (z4) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzg;
                if (firebaseUser3 != null) {
                    firebaseUser3.zza(zzahv);
                }
                zzb(firebaseAuth, firebaseAuth.zzg);
            }
            if (z3) {
                zza(firebaseAuth, firebaseAuth.zzg);
            }
            if (z) {
                firebaseAuth.zzt.zza(firebaseUser, zzahv);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzg;
            if (firebaseUser4 != null) {
                zzf(firebaseAuth).zza(firebaseUser4.zzc());
            }
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzi) {
            this.zzj = zzafd.zza();
        }
    }

    public void useEmulator(String str, int i) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(i >= 0 && i <= 65535, "Port number must be in the range 0-65535");
        zzagl.zza(this.zzf, str, i);
    }

    public static void zza(PhoneAuthOptions phoneAuthOptions) {
        String str;
        String str2;
        PhoneAuthOptions phoneAuthOptions2 = phoneAuthOptions;
        if (phoneAuthOptions2.zzm()) {
            FirebaseAuth zzb2 = phoneAuthOptions2.zzb();
            zzam zzam = (zzam) Preconditions.checkNotNull(phoneAuthOptions2.zzc());
            if (zzam.zzd()) {
                str2 = Preconditions.checkNotEmpty(phoneAuthOptions2.zzh());
                str = str2;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions2.zzf());
                str = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                str2 = phoneMultiFactorInfo.getPhoneNumber();
            }
            if (phoneAuthOptions2.zzd() == null || !zzagb.zza(str, phoneAuthOptions2.zze(), phoneAuthOptions2.zza(), phoneAuthOptions2.zzi())) {
                zzb2.zzv.zza(zzb2, str2, phoneAuthOptions2.zza(), zzb2.zzh(), phoneAuthOptions2.zzj(), phoneAuthOptions2.zzl(), zzam.zzd() ? zzb2.zzr : zzb2.zzs).addOnCompleteListener(new zzj(zzb2, phoneAuthOptions2, str));
                return;
            }
            return;
        }
        FirebaseAuth zzb3 = phoneAuthOptions2.zzb();
        String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions2.zzh());
        if (phoneAuthOptions2.zzd() != null || !zzagb.zza(checkNotEmpty, phoneAuthOptions2.zze(), phoneAuthOptions2.zza(), phoneAuthOptions2.zzi())) {
            zzb3.zzv.zza(zzb3, checkNotEmpty, phoneAuthOptions2.zza(), zzb3.zzh(), phoneAuthOptions2.zzj(), phoneAuthOptions2.zzl(), zzb3.zzq).addOnCompleteListener(new zzk(zzb3, phoneAuthOptions2, checkNotEmpty));
        }
    }

    public final void zza(PhoneAuthOptions phoneAuthOptions, zzj zzj2) {
        PhoneAuthOptions phoneAuthOptions2;
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue < 0 || longValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        String zzc2 = zzj2.zzc();
        String zzb2 = zzj2.zzb();
        String zzd2 = zzj2.zzd();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(zzc2) && zzb() != null && zzb().zza("PHONE_PROVIDER")) {
            zzc2 = "NO_RECAPTCHA";
        }
        String str = zzc2;
        zzaij zzaij = new zzaij(checkNotEmpty, longValue, phoneAuthOptions.zzd() != null, this.zzj, this.zzl, zzd2, zzb2, str, zzh());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zza(checkNotEmpty, phoneAuthOptions.zze());
        if (TextUtils.isEmpty(zzj2.zzd())) {
            phoneAuthOptions2 = phoneAuthOptions;
            zza2 = zza(phoneAuthOptions2, zza2, zzj.zza().zzc(zzd2).zzb(str).zza(zzb2).zza());
        } else {
            phoneAuthOptions2 = phoneAuthOptions;
        }
        this.zzd.zza(this.zzf, zzaij, zza2, phoneAuthOptions2.zza(), phoneAuthOptions2.zzi());
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return zzaeu.zza(getApp().getApplicationContext());
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zza(str);
    }

    private final boolean zzb(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        return parseLink != null && !TextUtils.equals(this.zzl, parseLink.zza());
    }
}
