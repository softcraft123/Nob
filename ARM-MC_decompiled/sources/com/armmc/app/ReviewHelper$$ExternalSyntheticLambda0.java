package com.armmc.app;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReviewHelper$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ ReviewHelper f$0;

    public /* synthetic */ ReviewHelper$$ExternalSyntheticLambda0(ReviewHelper reviewHelper) {
        this.f$0 = reviewHelper;
    }

    public final void onComplete(Task task) {
        ReviewHelper.recordServerStop$lambda$1$lambda$0(this.f$0, task);
    }
}
