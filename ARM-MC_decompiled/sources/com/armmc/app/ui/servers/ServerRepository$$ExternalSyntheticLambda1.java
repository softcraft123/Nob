package com.armmc.app.ui.servers;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServerRepository$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int f$0;

    public /* synthetic */ ServerRepository$$ExternalSyntheticLambda1(int i) {
        this.f$0 = i;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(ServerRepository.deleteServer$lambda$3(this.f$0, (ServerData) obj));
    }
}
