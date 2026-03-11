package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzafh implements zzaem {
    final /* synthetic */ zzaff zza;

    zzafh(zzaff zzaff) {
        Objects.requireNonNull(zzaff);
        this.zza = zzaff;
    }

    private final void zza(zzafm zzafm) {
        this.zza.zzi.execute(new zzafn(this, zzafm));
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzaff.zza(this.zza, status);
        this.zza.zzn = authCredential;
        this.zza.zzo = str;
        this.zza.zzp = str2;
        if (this.zza.zzf != null) {
            this.zza.zzf.zza(status);
        }
        this.zza.zza(status);
    }

    public final void zza(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzu = true;
        zza((zzafm) new zzafl(this, str));
    }

    public final void zzb(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        zza((zzafm) new zzafj(this, str));
    }

    public final void zza(zzagv zzagv) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 3, "Unexpected response type " + this.zza.zza);
        this.zza.zzl = zzagv;
        zzaff.zza(this.zza);
    }

    public final void zza() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 5, "Unexpected response type " + this.zza.zza);
        zzaff.zza(this.zza);
    }

    public final void zza(zzaap zzaap) {
        zza(zzaap.zza(), zzaap.zzb(), zzaap.zzc(), zzaap.zzd());
    }

    public final void zza(zzaas zzaas) {
        this.zza.zzq = zzaas;
        this.zza.zza(zzao.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 2, "Unexpected response type " + this.zza.zza);
        zza(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        if (this.zza.zza == 8) {
            this.zza.zzu = true;
            zza((zzafm) new zzafk(this, status));
            return;
        }
        zzaff.zza(this.zza, status);
        this.zza.zza(status);
    }

    public final void zza(zzahr zzahr) throws RemoteException {
        this.zza.zzs = zzahr;
        zzaff.zza(this.zza);
    }

    public final void zza(zzahs zzahs) throws RemoteException {
        this.zza.zzr = zzahs;
        zzaff.zza(this.zza);
    }

    public final void zza(zzahv zzahv, zzahk zzahk) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 2, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzahv;
        this.zza.zzk = zzahk;
        zzaff.zza(this.zza);
    }

    public final void zza(zzaif zzaif) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 4, "Unexpected response type " + this.zza.zza);
        this.zza.zzm = zzaif;
        zzaff.zza(this.zza);
    }

    public final void zza(zzaig zzaig) throws RemoteException {
        zzaff.zza(this.zza);
    }

    public final void zzb() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 6, "Unexpected response type " + this.zza.zza);
        zzaff.zza(this.zza);
    }

    public final void zzc(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 7, "Unexpected response type " + this.zza.zza);
        zzaff.zza(this.zza);
    }

    public final void zzc() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 9, "Unexpected response type " + this.zza.zza);
        zzaff.zza(this.zza);
    }

    public final void zza(zzair zzair) throws RemoteException {
        this.zza.zzt = zzair;
        zzaff.zza(this.zza);
    }

    public final void zza(zzahv zzahv) throws RemoteException {
        boolean z = true;
        if (this.zza.zza != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzahv;
        zzaff.zza(this.zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzu = true;
        zza((zzafm) new zzafi(this, phoneAuthCredential));
    }
}
