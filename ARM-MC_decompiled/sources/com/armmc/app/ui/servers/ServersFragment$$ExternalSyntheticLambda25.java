package com.armmc.app.ui.servers;

import com.armmc.app.ui.servers.ServersFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda25 implements Function0 {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ ServersFragment f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ ServersFragment.FrpConnectionParams f$3;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda25(Ref.IntRef intRef, ServersFragment serversFragment, int i, ServersFragment.FrpConnectionParams frpConnectionParams) {
        this.f$0 = intRef;
        this.f$1 = serversFragment;
        this.f$2 = i;
        this.f$3 = frpConnectionParams;
    }

    public final Object invoke() {
        return ServersFragment.handleFrpDisconnection$lambda$67(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
