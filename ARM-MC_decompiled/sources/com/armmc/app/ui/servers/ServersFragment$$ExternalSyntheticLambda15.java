package com.armmc.app.ui.servers;

import com.armmc.app.api.TunnelApiService;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda15 implements Function0 {
    public final /* synthetic */ TunnelApiService.TunnelRequestResponse f$0;
    public final /* synthetic */ ServersFragment f$1;
    public final /* synthetic */ ServerData f$2;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda15(TunnelApiService.TunnelRequestResponse tunnelRequestResponse, ServersFragment serversFragment, ServerData serverData) {
        this.f$0 = tunnelRequestResponse;
        this.f$1 = serversFragment;
        this.f$2 = serverData;
    }

    public final Object invoke() {
        return ServersFragment.requestTunnelAndStartFRP$lambda$39$lambda$36(this.f$0, this.f$1, this.f$2);
    }
}
