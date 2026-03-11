package com.armmc.app.ui.logs;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LogsFragment$$ExternalSyntheticLambda3 implements TextView.OnEditorActionListener {
    public final /* synthetic */ LogsFragment f$0;

    public /* synthetic */ LogsFragment$$ExternalSyntheticLambda3(LogsFragment logsFragment) {
        this.f$0 = logsFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return LogsFragment.setupCommandInput$lambda$8(this.f$0, textView, i, keyEvent);
    }
}
