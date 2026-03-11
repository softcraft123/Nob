package com.armmc.app.ui.servers;

import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda40 implements Function2 {
    public final /* synthetic */ ServersFragment f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda40(ServersFragment serversFragment, int i, String str) {
        this.f$0 = serversFragment;
        this.f$1 = i;
        this.f$2 = str;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ServersFragment.startFRPClientWithRetry$lambda$48(this.f$0, this.f$1, this.f$2, ((Integer) obj).intValue(), (String) obj2);
    }
}
