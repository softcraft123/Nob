package com.armmc.app.ui.servers;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServerRepository$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ ServerData f$0;

    public /* synthetic */ ServerRepository$$ExternalSyntheticLambda0(ServerData serverData) {
        this.f$0 = serverData;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(ServerRepository.saveServer$lambda$2(this.f$0, (ServerData) obj));
    }
}
