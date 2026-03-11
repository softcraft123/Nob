package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt", f = "SplitInstallManagerKtx.kt", i = {}, l = {120}, m = "requestSessionState", n = {}, s = {})
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
final class SplitInstallManagerKtxKt$requestSessionState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    SplitInstallManagerKtxKt$requestSessionState$1(Continuation<? super SplitInstallManagerKtxKt$requestSessionState$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplitInstallManagerKtxKt.requestSessionState((SplitInstallManager) null, 0, this);
    }
}
