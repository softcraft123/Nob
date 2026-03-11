package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class bj extends y {
    final /* synthetic */ bk a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bj(bk bkVar, String str, long j) {
        super(str, j);
        this.a = bkVar;
    }

    /* access modifiers changed from: package-private */
    public final Task b(Activity activity, Bundle bundle) {
        bundle.putLong("cloud.prj", this.a.e);
        return this.a.c.c(activity, bundle);
    }
}
