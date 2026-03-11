package com.google.android.play.core.splitinstall.testing;

import java.io.File;
import java.io.FileFilter;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzl implements FileFilter {
    public static final /* synthetic */ zzl zza = new zzl();

    private /* synthetic */ zzl() {
    }

    public final boolean accept(File file) {
        int i = FakeSplitInstallManager.zza;
        return file.getName().endsWith(".apk");
    }
}
