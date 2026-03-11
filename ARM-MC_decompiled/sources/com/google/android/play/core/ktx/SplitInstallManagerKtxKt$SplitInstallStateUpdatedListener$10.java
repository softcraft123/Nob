package com.google.android.play.core.ktx;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "onStateUpdate"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
final class SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$10 implements SplitInstallStateUpdatedListener {
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onCanceled;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onCanceling;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onDownloaded;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onDownloading;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onFailed;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onInstalled;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onInstalling;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onNonTerminalStatus;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onPending;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onRequiresConfirmation;
    final /* synthetic */ Function1<SplitInstallSessionState, Unit> $onTerminalStatus;

    SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$10(Function1<? super SplitInstallSessionState, Unit> function1, Function1<? super SplitInstallSessionState, Unit> function12, Function1<? super SplitInstallSessionState, Unit> function13, Function1<? super SplitInstallSessionState, Unit> function14, Function1<? super SplitInstallSessionState, Unit> function15, Function1<? super SplitInstallSessionState, Unit> function16, Function1<? super SplitInstallSessionState, Unit> function17, Function1<? super SplitInstallSessionState, Unit> function18, Function1<? super SplitInstallSessionState, Unit> function19, Function1<? super SplitInstallSessionState, Unit> function110, Function1<? super SplitInstallSessionState, Unit> function111) {
        this.$onFailed = function1;
        this.$onPending = function12;
        this.$onRequiresConfirmation = function13;
        this.$onDownloading = function14;
        this.$onDownloaded = function15;
        this.$onInstalling = function16;
        this.$onInstalled = function17;
        this.$onCanceling = function18;
        this.$onCanceled = function19;
        this.$onTerminalStatus = function110;
        this.$onNonTerminalStatus = function111;
    }

    public final void onStateUpdate(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkNotNullParameter(splitInstallSessionState, "state");
        switch (splitInstallSessionState.status()) {
            case 0:
            case 6:
                this.$onFailed.invoke(splitInstallSessionState);
                break;
            case 1:
                this.$onPending.invoke(splitInstallSessionState);
                break;
            case 2:
                this.$onDownloading.invoke(splitInstallSessionState);
                break;
            case 3:
                this.$onDownloaded.invoke(splitInstallSessionState);
                break;
            case 4:
                this.$onInstalling.invoke(splitInstallSessionState);
                break;
            case 5:
                this.$onInstalled.invoke(splitInstallSessionState);
                break;
            case 7:
                this.$onCanceled.invoke(splitInstallSessionState);
                break;
            case 8:
                this.$onRequiresConfirmation.invoke(splitInstallSessionState);
                break;
            case 9:
                this.$onCanceling.invoke(splitInstallSessionState);
                break;
        }
        if (splitInstallSessionState.hasTerminalStatus()) {
            this.$onTerminalStatus.invoke(splitInstallSessionState);
        } else {
            this.$onNonTerminalStatus.invoke(splitInstallSessionState);
        }
    }
}
