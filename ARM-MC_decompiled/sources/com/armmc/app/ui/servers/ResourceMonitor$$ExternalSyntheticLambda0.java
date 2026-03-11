package com.armmc.app.ui.servers;

import android.content.Context;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ResourceMonitor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ ResourceMonitor$$ExternalSyntheticLambda0(int i, Context context) {
        this.f$0 = i;
        this.f$1 = context;
    }

    public final void run() {
        ResourceMonitor.startMonitoring$lambda$1(this.f$0, this.f$1);
    }
}
