package com.armmc.app.ui.servers;

import android.widget.CompoundButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda31 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ MaterialButton f$0;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda31(MaterialButton materialButton) {
        this.f$0 = materialButton;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ServersFragment.showAlphaWarningDialog$lambda$13(this.f$0, compoundButton, z);
    }
}
