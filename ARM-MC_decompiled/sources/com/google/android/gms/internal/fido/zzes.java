package com.google.android.gms.internal.fido;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzes extends zzei {
    private final zzdn zza;
    private final Level zzb;
    private final Set zzc;
    private final zzea zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzes(String str, @NullableDecl String str2, boolean z, zzdn zzdn, boolean z2, boolean z3) {
        super(str2);
        Level level = Level.ALL;
        Set zzd2 = zzeu.zza;
        zzea zzb2 = zzeu.zzb;
        this.zza = zzdn;
        this.zzb = level;
        this.zzc = zzd2;
        this.zzd = zzb2;
    }
}
