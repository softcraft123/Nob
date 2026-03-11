package com.armmc.app;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SplitInstallHelper$$ExternalSyntheticLambda2 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ SplitInstallHelper$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        SplitInstallHelper.installModule$lambda$2(this.f$0, obj);
    }
}
