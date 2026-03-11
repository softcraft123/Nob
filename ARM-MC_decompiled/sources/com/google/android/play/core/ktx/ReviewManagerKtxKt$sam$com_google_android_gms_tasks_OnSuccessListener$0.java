package com.google.android.play.core.ktx;

import com.google.android.gms.common.annotation.NoNullnessRewrite;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: com.google.android.play:review-ktx@@2.0.2 */
final class ReviewManagerKtxKt$sam$com_google_android_gms_tasks_OnSuccessListener$0 implements OnSuccessListener {
    private final /* synthetic */ Function1 function;

    ReviewManagerKtxKt$sam$com_google_android_gms_tasks_OnSuccessListener$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.function = function1;
    }

    public final /* synthetic */ void onSuccess(@NoNullnessRewrite(reason = "Can be null for Task<Void> but this is uncommon.") Object obj) {
        this.function.invoke(obj);
    }
}
