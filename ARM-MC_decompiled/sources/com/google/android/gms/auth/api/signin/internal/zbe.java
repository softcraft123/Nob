package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.GmsClient;

/* compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
public final class zbe extends GmsClient {
    private final GoogleSignInOptions zba;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zbe(android.content.Context r8, android.os.Looper r9, com.google.android.gms.common.internal.ClientSettings r10, com.google.android.gms.auth.api.signin.GoogleSignInOptions r11, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks r12, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener r13) {
        /*
            r7 = this;
            r3 = 91
            r0 = r7
            r1 = r8
            r2 = r9
            r4 = r10
            r5 = r12
            r6 = r13
            r0.<init>((android.content.Context) r1, (android.os.Looper) r2, (int) r3, (com.google.android.gms.common.internal.ClientSettings) r4, (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) r5, (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r6)
            if (r11 == 0) goto L_0x0013
            com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder r8 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
            r8.<init>(r11)
            goto L_0x0018
        L_0x0013:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder r8 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder
            r8.<init>()
        L_0x0018:
            java.lang.String r9 = com.google.android.gms.internal.p001authapi.zbas.zba()
            r8.setLogSessionId(r9)
            java.util.Set r9 = r4.getAllRequestedScopes()
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0044
            java.util.Set r9 = r4.getAllRequestedScopes()
            java.util.Iterator r9 = r9.iterator()
        L_0x0031:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0044
            java.lang.Object r10 = r9.next()
            com.google.android.gms.common.api.Scope r10 = (com.google.android.gms.common.api.Scope) r10
            r11 = 0
            com.google.android.gms.common.api.Scope[] r11 = new com.google.android.gms.common.api.Scope[r11]
            r8.requestScopes(r10, r11)
            goto L_0x0031
        L_0x0044:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r8 = r8.build()
            r0.zba = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zbe.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.auth.api.signin.GoogleSignInOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener):void");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof zbs ? (zbs) queryLocalInterface : new zbs(iBinder);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final Intent getSignInIntent() {
        return zbm.zbc(getContext(), this.zba);
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final boolean providesSignIn() {
        return true;
    }

    public final GoogleSignInOptions zba() {
        return this.zba;
    }
}
