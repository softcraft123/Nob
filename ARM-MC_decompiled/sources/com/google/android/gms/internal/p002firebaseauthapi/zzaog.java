package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaog  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public enum zzaog {
    DOUBLE(zzaoj.DOUBLE, 1),
    FLOAT(zzaoj.FLOAT, 5),
    INT64(zzaoj.LONG, 0),
    UINT64(zzaoj.LONG, 0),
    INT32(zzaoj.INT, 0),
    FIXED64(zzaoj.LONG, 1),
    FIXED32(zzaoj.INT, 5),
    BOOL(zzaoj.BOOLEAN, 0),
    STRING(zzaoj.STRING, (zzaoj) null),
    GROUP(zzaoj.MESSAGE, (zzaoj) null),
    MESSAGE(zzaoj.MESSAGE, (zzaoj) null),
    BYTES(zzaoj.BYTE_STRING, (zzaoj) null),
    UINT32(zzaoj.INT, 0),
    ENUM(zzaoj.ENUM, 0),
    SFIXED32(zzaoj.INT, 5),
    SFIXED64(zzaoj.LONG, 1),
    SINT32(zzaoj.INT, 0),
    SINT64(zzaoj.LONG, 0);
    
    private final zzaoj zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zzaoj zzb() {
        return this.zzt;
    }

    private zzaog(zzaoj zzaoj, int i) {
        this.zzt = zzaoj;
        this.zzu = i;
    }
}
