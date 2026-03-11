package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzanh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzanh extends zzanm {
    private final /* synthetic */ zzang zza;

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzani(this.zza);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzanh(zzang zzang) {
        super(zzang);
        Objects.requireNonNull(zzang);
        this.zza = zzang;
    }
}
