package com.armmc.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/armmc/app/ReviewHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "recordServerStop", "", "activity", "Landroid/app/Activity;", "isEligibleForReview", "", "stopCount", "", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ReviewHelper.kt */
public final class ReviewHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_LAST_REVIEW_TIME = "last_review_request_time";
    private static final String KEY_STOP_COUNT = "server_stop_count";
    private static final int MIN_STOPS_REQUIRED = 3;
    private static final String TAG = "ReviewHelper";
    private static final long THREE_MONTHS_MS = 7776000000L;
    private final SharedPreferences prefs;

    public ReviewHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences("review_prefs", 0);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/armmc/app/ReviewHelper$Companion;", "", "<init>", "()V", "TAG", "", "KEY_STOP_COUNT", "KEY_LAST_REVIEW_TIME", "MIN_STOPS_REQUIRED", "", "THREE_MONTHS_MS", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ReviewHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void recordServerStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = this.prefs.getInt(KEY_STOP_COUNT, 0) + 1;
        this.prefs.edit().putInt(KEY_STOP_COUNT, i).apply();
        if (isEligibleForReview(i)) {
            ReviewManager create = ReviewManagerFactory.create(activity);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            create.requestReviewFlow().addOnCompleteListener(new ReviewHelper$$ExternalSyntheticLambda1(create, activity, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void recordServerStop$lambda$1(ReviewManager reviewManager, Activity activity, ReviewHelper reviewHelper, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            reviewManager.launchReviewFlow(activity, (ReviewInfo) task.getResult()).addOnCompleteListener(new ReviewHelper$$ExternalSyntheticLambda0(reviewHelper));
        } else {
            Integer.valueOf(Log.w(TAG, "Failed to request review flow", task.getException()));
        }
    }

    /* access modifiers changed from: private */
    public static final void recordServerStop$lambda$1$lambda$0(ReviewHelper reviewHelper, Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        reviewHelper.prefs.edit().putLong(KEY_LAST_REVIEW_TIME, System.currentTimeMillis()).apply();
        Log.d(TAG, "In-app review flow completed");
    }

    private final boolean isEligibleForReview(int i) {
        if (i < 3) {
            return false;
        }
        long j = this.prefs.getLong(KEY_LAST_REVIEW_TIME, 0);
        return j == 0 || System.currentTimeMillis() - j >= THREE_MONTHS_MS;
    }
}
