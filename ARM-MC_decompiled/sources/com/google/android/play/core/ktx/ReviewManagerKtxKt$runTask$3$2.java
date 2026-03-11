package com.google.android.play.core.ktx;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "result", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* compiled from: com.google.android.play:review-ktx@@2.0.2 */
final class ReviewManagerKtxKt$runTask$3$2 extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReviewManagerKtxKt$runTask$3$2(CancellableContinuation<? super T> cancellableContinuation) {
        super(1);
        this.$continuation = cancellableContinuation;
    }

    public final void invoke(T t) {
        this.$continuation.resumeWith(Result.m516constructorimpl(t));
    }
}
