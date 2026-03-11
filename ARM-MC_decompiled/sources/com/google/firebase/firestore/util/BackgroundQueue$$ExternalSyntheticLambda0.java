package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.BackgroundQueue;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BackgroundQueue$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ BackgroundQueue.State f$1;

    public /* synthetic */ BackgroundQueue$$ExternalSyntheticLambda0(Runnable runnable, BackgroundQueue.State state) {
        this.f$0 = runnable;
        this.f$1 = state;
    }

    public final void run() {
        BackgroundQueue.submit$lambda$1(this.f$0, this.f$1);
    }
}
