package com.armmc.app;

import java.lang.Thread;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PumpkinService$$ExternalSyntheticLambda1 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ PumpkinService f$0;

    public /* synthetic */ PumpkinService$$ExternalSyntheticLambda1(PumpkinService pumpkinService) {
        this.f$0 = pumpkinService;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        PumpkinService.onCreate$lambda$1(this.f$0, thread, th);
    }
}
