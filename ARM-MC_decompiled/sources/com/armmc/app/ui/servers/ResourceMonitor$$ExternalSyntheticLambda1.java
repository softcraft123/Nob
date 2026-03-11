package com.armmc.app.ui.servers;

import android.content.Context;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ResourceMonitor$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ ResourceMonitor$$ExternalSyntheticLambda1(int i, Context context) {
        this.f$0 = i;
        this.f$1 = context;
    }

    public final void run() {
        ResourceMonitor.resumeMonitoring$lambda$3$lambda$2(this.f$0, this.f$1);
    }
}
