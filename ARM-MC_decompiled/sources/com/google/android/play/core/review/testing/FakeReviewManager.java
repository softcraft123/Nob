package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;

/* compiled from: com.google.android.play:review@@2.0.2 */
public class FakeReviewManager implements ReviewManager {
    private final Context zza;
    private ReviewInfo zzb;
    private int zzc = 0;

    public FakeReviewManager(Context context) {
        this.zza = context;
    }

    public Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo != this.zzb) {
            return Tasks.forException(new ReviewException(-2));
        }
        this.zzc++;
        return Tasks.forResult(null);
    }

    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo zzc2 = ReviewInfo.zzc(PendingIntent.getBroadcast(this.zza, 0, new Intent(), AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), false);
        this.zzb = zzc2;
        return Tasks.forResult(zzc2);
    }
}
