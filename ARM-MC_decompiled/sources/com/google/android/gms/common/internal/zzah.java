package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzah {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    static Intent zza(Context context, zzn zzn) throws zzaf {
        Bundle bundle;
        ContentProviderClient acquireUnstableContentProviderClient;
        String zza2 = zzn.zza();
        if (zza2 == null) {
            return new Intent().setComponent(zzn.zzc());
        }
        Intent intent = null;
        if (zzn.zzd()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", zza2);
            try {
                acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(zza);
                if (acquireUnstableContentProviderClient != null) {
                    bundle = acquireUnstableContentProviderClient.call("serviceIntentCall", (String) null, bundle2);
                    acquireUnstableContentProviderClient.release();
                    if (bundle != null) {
                        Intent intent2 = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                        if (intent2 != null) {
                            intent = intent2;
                        } else {
                            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("serviceMissingResolutionIntentKey");
                            if (pendingIntent != null) {
                                StringBuilder sb = new StringBuilder(zza2.length() + 72);
                                sb.append("Dynamic lookup for intent failed for action ");
                                sb.append(zza2);
                                sb.append(" but has possible resolution");
                                Log.w("ServiceBindIntentUtils", sb.toString());
                                throw new zzaf(new ConnectionResult(25, pendingIntent));
                            }
                        }
                    }
                    if (intent == null) {
                        Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action: ".concat(zza2));
                    }
                } else {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
            } catch (RemoteException | IllegalArgumentException e) {
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
            } catch (Throwable th) {
                acquireUnstableContentProviderClient.release();
                throw th;
            }
        }
        return intent == null ? new Intent(zza2).setPackage(zzn.zzb()) : intent;
    }
}
