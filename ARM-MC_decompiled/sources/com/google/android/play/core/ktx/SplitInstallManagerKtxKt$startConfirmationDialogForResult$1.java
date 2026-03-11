package com.google.android.play.core.ktx;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: com.google.android.play:feature-delivery-ktx@@2.1.0 */
/* synthetic */ class SplitInstallManagerKtxKt$startConfirmationDialogForResult$1 implements IntentSenderForResultStarter {
    final /* synthetic */ Fragment $tmp0;

    SplitInstallManagerKtxKt$startConfirmationDialogForResult$1(Fragment fragment) {
        this.$tmp0 = fragment;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Intrinsics.checkNotNullParameter(intentSender, "p0");
        this.$tmp0.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
