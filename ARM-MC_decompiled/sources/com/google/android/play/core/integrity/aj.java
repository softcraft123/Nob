package com.google.android.play.core.integrity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.ae;
import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.d;
import com.google.android.play.integrity.internal.s;
import com.google.android.play.integrity.internal.y;
import java.util.ArrayList;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class aj {
    final ae a;
    /* access modifiers changed from: private */
    public final s b;
    /* access modifiers changed from: private */
    public final String c;
    /* access modifiers changed from: private */
    public final at d;
    /* access modifiers changed from: private */
    public final k e;

    aj(Context context, s sVar, at atVar, k kVar) {
        this.c = context.getPackageName();
        this.b = sVar;
        this.d = atVar;
        this.e = kVar;
        if (!ai.b(context)) {
            sVar.b("Phonesky is not installed.", new Object[0]);
            this.a = null;
            return;
        }
        this.a = new ae(context, sVar, "IntegrityService", ak.a, ae.a, (y) null);
    }

    static /* bridge */ /* synthetic */ Bundle a(aj ajVar, byte[] bArr, Long l, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l != null) {
            bundle.putLong("cloud.prj", l.longValue());
        }
        ArrayList arrayList = new ArrayList();
        d.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(d.a(arrayList)));
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final Task b(Activity activity, Bundle bundle) {
        if (this.a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, (Throwable) null));
        }
        int i = bundle.getInt("dialog.intent.type");
        this.b.d("requestAndShowDialog(%s, %s)", this.c, Integer.valueOf(i));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Bundle bundle2 = bundle;
        this.a.t(new ag(this, taskCompletionSource, bundle2, activity, taskCompletionSource, i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, (Throwable) null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
                ao aoVar = (ao) integrityTokenRequest;
            }
            this.b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.a.t(new af(this, taskCompletionSource, decode, cloudProjectNumber, (Parcelable) null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e2) {
            return Tasks.forException(new IntegrityServiceException(-13, e2));
        }
    }
}
