package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
public final /* synthetic */ class bs implements StandardIntegrityManager.StandardIntegrityTokenProvider {
    public final /* synthetic */ bt a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public /* synthetic */ bs(bt btVar, long j, long j2, int i) {
        this.a = btVar;
        this.b = j;
        this.c = j2;
    }

    public final Task request(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.a.a(this.b, this.c, 0, standardIntegrityTokenRequest);
    }
}
