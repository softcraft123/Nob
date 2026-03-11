package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzz implements IntentSenderForResultStarter {
    final /* synthetic */ Activity zza;

    zzz(zzaa zzaa, Activity activity) {
        this.zza = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        int i5 = i4;
        int i6 = i3;
        int i7 = i2;
        Intent intent2 = intent;
        int i8 = i;
        this.zza.startIntentSenderForResult(intentSender, i8, intent2, i7, i6, i5);
    }
}
