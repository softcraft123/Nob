package com.armmc.app.ui.servers;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MotdBuilderDialog$$ExternalSyntheticLambda1 implements TextView.OnEditorActionListener {
    public final /* synthetic */ MotdBuilderDialog f$0;

    public /* synthetic */ MotdBuilderDialog$$ExternalSyntheticLambda1(MotdBuilderDialog motdBuilderDialog) {
        this.f$0 = motdBuilderDialog;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return MotdBuilderDialog.setupListeners$lambda$13(this.f$0, textView, i, keyEvent);
    }
}
