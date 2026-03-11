package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.splitinstall.internal.zzcb;
import java.io.File;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzaf implements zzcb {
    private final zzcb zza;

    public zzaf(zzcb zzcb) {
        this.zza = zzcb;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        String string;
        Context zzb = ((zzad) this.zza).zzb();
        try {
            Bundle bundle = zzb.getPackageManager().getApplicationInfo(zzb.getPackageName(), 128).metaData;
            if (!(bundle == null || (string = bundle.getString("local_testing_dir")) == null)) {
                return new File(zzb.getExternalFilesDir((String) null), string);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }
}
