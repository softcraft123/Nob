package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "onStateUpdate"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
final class SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1 implements SplitInstallStateUpdatedListener {
    final /* synthetic */ ProducerScope<SplitInstallSessionState> $$this$callbackFlow;
    final /* synthetic */ Set<Integer> $sessionsAlreadyOffered;

    SplitInstallManagerKtxKt$requestProgressFlow$1$globalSessionListener$1(Set<Integer> set, ProducerScope<? super SplitInstallSessionState> producerScope) {
        this.$sessionsAlreadyOffered = set;
        this.$$this$callbackFlow = producerScope;
    }

    public final void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "state");
        this.$sessionsAlreadyOffered.add(Integer.valueOf(splitInstallSessionState.sessionId()));
        SplitInstallManagerKtxKt.tryOffer(this.$$this$callbackFlow, splitInstallSessionState);
    }
}
