package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "result", "kotlin.jvm.PlatformType", "onSuccess", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
final class SplitInstallManagerKtxKt$runTask$3$2<TResult> implements OnSuccessListener {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    SplitInstallManagerKtxKt$runTask$3$2(CancellableContinuation<? super T> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onSuccess(T t) {
        this.$continuation.resumeWith(Result.m516constructorimpl(t));
    }
}
