package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.GithubAuthCredential;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.auth.TwitterAuthCredential;
import com.google.firebase.auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzk {
    public static zzajb zza(AuthCredential authCredential, String str) {
        Preconditions.checkNotNull(authCredential);
        if (authCredential instanceof GoogleAuthCredential) {
            return GoogleAuthCredential.zza((GoogleAuthCredential) authCredential, str);
        }
        if (authCredential instanceof FacebookAuthCredential) {
            return FacebookAuthCredential.zza((FacebookAuthCredential) authCredential, str);
        }
        if (authCredential instanceof TwitterAuthCredential) {
            return TwitterAuthCredential.zza((TwitterAuthCredential) authCredential, str);
        }
        if (authCredential instanceof GithubAuthCredential) {
            return GithubAuthCredential.zza((GithubAuthCredential) authCredential, str);
        }
        if (authCredential instanceof PlayGamesAuthCredential) {
            return PlayGamesAuthCredential.zza((PlayGamesAuthCredential) authCredential, str);
        }
        if (authCredential instanceof zze) {
            return zze.zza((zze) authCredential, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
