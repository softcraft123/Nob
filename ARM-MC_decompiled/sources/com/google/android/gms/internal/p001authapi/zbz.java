package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.identity.AuthorizationClient;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.zba;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api.zbz  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
public final class zbz extends GoogleApi implements AuthorizationClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd = zbas.zba();

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbx zbx = new zbx();
        zbb = zbx;
        zbc = new Api("Auth.Api.Identity.Authorization.API", zbx, clientKey);
    }

    public zbz(Activity activity, zba zba2) {
        super(activity, zbc, zba2, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<AuthorizationResult> authorize(AuthorizationRequest authorizationRequest) {
        Preconditions.checkNotNull(authorizationRequest);
        AuthorizationRequest.Builder zba2 = AuthorizationRequest.zba(authorizationRequest);
        zba2.zbb(this.zbd);
        AuthorizationRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbar.zbc).run(new zbw(this, build)).setAutoResolveMissingFeatures(false).setMethodKey(1534).build());
    }

    public final AuthorizationResult getAuthorizationResultFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, NotificationCompat.CATEGORY_STATUS, Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                AuthorizationResult authorizationResult = (AuthorizationResult) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "authorization_result", AuthorizationResult.CREATOR);
                if (authorizationResult != null) {
                    return authorizationResult;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    public zbz(Context context, zba zba2) {
        super(context, zbc, zba2, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
