package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzi implements DynamiteModule.VersionPolicy {
    zzi() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int i = 0;
        int zza = iVersions.zza(context, str, false);
        selectionResult.remoteVersion = zza;
        if (zza != 0) {
            i = 1;
        }
        selectionResult.selection = i;
        return selectionResult;
    }
}
