package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "exception", "Ljava/lang/Exception;", "Lkotlin/jvm/internal/EnhancedNullability;", "onFailure"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: com.google.android.play:review-ktx@@2.0.2 */
final class ReviewManagerKtxKt$runTask$3$3 implements OnFailureListener {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    ReviewManagerKtxKt$runTask$3$3(CancellableContinuation<? super T> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        this.$continuation.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(exc)));
    }
}
