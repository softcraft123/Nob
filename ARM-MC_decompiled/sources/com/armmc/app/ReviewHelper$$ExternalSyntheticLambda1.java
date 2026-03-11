package com.armmc.app;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReviewHelper$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public final /* synthetic */ ReviewManager f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ ReviewHelper f$2;

    public /* synthetic */ ReviewHelper$$ExternalSyntheticLambda1(ReviewManager reviewManager, Activity activity, ReviewHelper reviewHelper) {
        this.f$0 = reviewManager;
        this.f$1 = activity;
        this.f$2 = reviewHelper;
    }

    public final void onComplete(Task task) {
        ReviewHelper.recordServerStop$lambda$1(this.f$0, this.f$1, this.f$2, task);
    }
}
