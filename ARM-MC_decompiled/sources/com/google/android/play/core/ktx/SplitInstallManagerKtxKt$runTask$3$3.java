package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "exception", "Ljava/lang/Exception;", "onFailure"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
final class SplitInstallManagerKtxKt$runTask$3$3 implements OnFailureListener {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    SplitInstallManagerKtxKt$runTask$3$3(CancellableContinuation<? super T> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        this.$continuation.resumeWith(Result.m516constructorimpl(ResultKt.createFailure(exc)));
    }
}
