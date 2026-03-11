package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzm implements DynamiteModule.VersionPolicy {
    zzm() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int i;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zzb = iVersions.zzb(context, str);
        selectionResult.localVersion = zzb;
        int i2 = 1;
        int i3 = 0;
        if (zzb != 0) {
            i = iVersions.zza(context, str, false);
            selectionResult.remoteVersion = i;
        } else {
            i = iVersions.zza(context, str, true);
            selectionResult.remoteVersion = i;
        }
        int i4 = selectionResult.localVersion;
        if (i4 != 0) {
            i3 = i4;
        } else if (i == 0) {
            i2 = 0;
            selectionResult.selection = i2;
            return selectionResult;
        }
        if (i < i3) {
            i2 = -1;
        }
        selectionResult.selection = i2;
        return selectionResult;
    }
}
